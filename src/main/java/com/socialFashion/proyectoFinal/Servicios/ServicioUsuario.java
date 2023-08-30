package com.socialFashion.proyectoFinal.Servicios;



import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.socialFashion.proyectoFinal.Entidades.Imagen;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Role;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioImagen;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteUsuario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario implements UserDetailsService {

    @Autowired
    private RepositorioUsuario userRepository;

    @Autowired
    private RepositorioReporteUsuario repositorioReporteUsuario;

    @Autowired
    private ServicioImagen servicioImagen;

    @Autowired
    private ServicioPublicacion servicioPublicacion;
    
    @Autowired
    private RepositorioImagen repoImagen;

    //PEDIR EL PARAM EL ROL

    @Transactional
    public void register(String name, String email, Date birthDate, String password, String password2, MultipartFile image) throws MiException{
        validate(name, password, password2);
        Usuario user = new Usuario();

        user.setName(name);
        user.setEmail(email);
        if(password.equals(password2)){
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAlta(true);
            if(mayoriaDeEdad(birthDate)){
                user.setBirthDate(birthDate);
                user.setRole(Role.USER);

                //PERSISTO IMAGEN
                Imagen imagen = servicioImagen.guardar(image);
                //LA GUARDO EN EL USUARIO 
                user.setImage(imagen);
            }else{
                throw new MiException("No sos mayor de edad");
            }
        }else{
            throw new MiException("Las contraseñas deben ser iguales");
        }
        

        userRepository.save(user);

    }

    @Transactional
    public void update(String id, String name, String password, String password2, MultipartFile image) throws MiException{
        validate(name, password, password2);
        Optional<Usuario> answer = userRepository.findById(id);
        if (answer.isPresent()) {

            Usuario user = answer.get();

            user.setName(name);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAlta(true);
            Imagen imagen = servicioImagen.guardar(image); 
            user.setImage(imagen);
            
        }

    }

    @Transactional
    public void delete(String id) throws MiException{

        for (Publicacion publicacion : servicioPublicacion.getPublicacionByUser(id)) {
            servicioPublicacion.eliminar(publicacion.getId());
        }

        for (ReportUser reportUser : repositorioReporteUsuario.reportUsuarioByIdUser(id)) {
            repositorioReporteUsuario.delete(reportUser);
        }
        
        Optional<Usuario> answer = userRepository.findById(id);
        if (answer.isPresent()) {
            List<Usuario> us = listUsers();
            us.stream().filter((user) -> (Objects.equals(user.getId(), id))).forEachOrdered((user) -> {
                userRepository.delete(user);
            });
        }

    }

    private void validate(String name,  String password, String password2) throws MiException {

        if (name.isEmpty() || name == null) {
            throw new MiException("el nombre no puede ser nulo o estar vacío");
        }
        
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }

        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }

    }

//    ------ Metodo para Imagen Predeterminada -------
//    private void validarImagen(MultipartFile image){
//        if(image.isEmpty()){
//            image = repoImagen.imagenPredeterminada();
//        }
//    }

    @Transactional(readOnly=true)
    public List<Usuario> listUsers() {
        return userRepository.findAll();
    }

    public Usuario getOne(String name){
        return userRepository.getOne(name);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Usuario usuario = userRepository.buscarPorEmail(email);
        
        if(usuario != null){
            
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRole().toString());
            
            permisos.add(p);
            
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        }else{
            return null;
        }
    }

    public Boolean mayoriaDeEdad(Date birthDate){

        Date hoy = new Date();
        
        int anioActual = hoy.getYear()+1900;

        if((anioActual - birthDate.getYear()) > 18 ){       
            
            return true;
            
        }else if((anioActual - birthDate.getYear()) == 18){
            
            if((hoy.getMonth() - birthDate.getMonth()) > 0){
                
                return true;
                
            }else if((hoy.getMonth() - birthDate.getMonth()) == 0){
                
                if((hoy.getDate() - birthDate.getDate()) >= 0){
                    
                    return true;

                }
            }
        }

        return false;

    }

    
}
