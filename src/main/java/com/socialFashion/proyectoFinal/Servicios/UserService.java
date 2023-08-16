package com.socialFashion.proyectoFinal.Servicios;



import java.util.Optional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Role;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void register(String name, String email , Date birthDate , String password , String password2 , String description, MultipartFile image) throws MiException{
        validate(name, password, password2);
        Usuario user = new Usuario();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setAlta(true);
        user.setBirthDate(birthDate);
        user.setRole(Role.USER);

        //PERSISTO IMAGEN
         Imagen imagen = servicioImagen.guardar(image);
        //LA GUARDO EN EL USUARIO 
         user.setImage(imagen);;

        userRepository.save(user);

    }

    @Transactional
    public void update(String id, String name, String email , String password , String password2 , String description) throws MiException{
        validate(name, password, password2);
        Optional<Usuario> answer = userRepository.findById(id);
        if (answer.isPresent()) {

            Usuario user = answer.get();

            user.setName(name);
            user.setEmail(email);
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            user.setAlta(true);
            user.setRole(Role.USER);

        }

    }

    @Transactional
    public void delete(String id , String name){

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

    @Transactional(readOnly=true)
    public List<Usuario> listUsers() {

        List<Usuario> users = new ArrayList();

        users = userRepository.findAll();

        return users;
    }

    public Usuario getOne(String name){
        return userRepository.getOne(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }


    
}
