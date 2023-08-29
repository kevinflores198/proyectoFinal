package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioImagen;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;
    
    @Autowired
    private RepositorioPublicacion repoPublicacion;
    
    @Autowired
    private RepositorioImagen repoImagen;

    // PRU DE VISTA DETAIL.HTML
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/detail")
    public String publicacion() {

        return "detail.html";
    }

    // VISTA INDEX
    @GetMapping("/")
    public String index() {

        return "index.html";

    }

    // VISTA DE REGISTRAR
    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {
        // ---------------- PROBAR ------------------
        //modelo.addAttribute("imagenPred", repoImagen.imagenPredeterminada());
        return "guest.html";
    }

    // FORMULARIO DE REGISTRO DE USUARIO
    @PostMapping("/registro")
    public String registro(@RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "birthDate") String birthDate,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "password2") String password2,
            MultipartFile image, ModelMap modelo) {

        try {
            servicioUsuario.register(name, email, DateConverter(birthDate), password, password2, image);

            modelo.put("exito", "Usuario registrado correctamente!");
            
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            modelo.put("email", email);
            
        }
        
        return "guest.html";

    }

    // VISTA DE LOGIN
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            System.out.println(error);
            modelo.put("error", "Usuario o Clave incorrectos!");
        }
        return "guest.html";
    }
    
    //VISTA MAIN 
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/main")
    public String inicio(HttpSession session) {

        
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        if (logueado.getRole().toString().equals("ADMIN")) {
        return "main.html";
        }

        return "main.html";
    }

    private Date DateConverter(String fecha) {

        Date birthDate = new Date();

        birthDate.setDate(Integer.valueOf(fecha.substring(8, 10)));
        birthDate.setMonth(Integer.valueOf(fecha.substring(5, 7)) - 1);
        birthDate.setYear(Integer.valueOf(fecha.substring(0, 4))-1900);

        return birthDate;

    }

    //VISTA LISTA DE USUARIOS
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/listar-usuarios")
    public String listaUsuarios(ModelMap modelo) {

        List<Usuario> usuarios = servicioUsuario.listUsers();
        modelo.addAttribute("usuarios", usuarios);

        // RETORNAR A SU HTML
        return "lista-usuarios.html";

    }

    //VISTA PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_DISIGNER')")
    @GetMapping("/perfil/{id}")
    public String perfil(@PathVariable String id, ModelMap modelo) {
        
        Usuario usuario = servicioUsuario.getOne(id);
        List<Publicacion> publicaciones = repoPublicacion.publicacionesByUser(id);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("publicaciones", publicaciones);

        return "perfil.html";

    }

    //VISTA ACTUALIZAR PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_DISIGNER')")
    @GetMapping("/perfil/modificar/{id}")
    public String modificarPerfil(@PathVariable String id, ModelMap modelo) {

        Usuario usuario = servicioUsuario.getOne(id);
        modelo.addAttribute("usuario", usuario);

        return "form-usuario.html";

    }

    //FORM ACTUALIZAR PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_DISIGNER')")
    @PostMapping("/perfil/modificado/{id}")
    public String perfilModificado(@PathVariable String id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "password2") String password2,
            MultipartFile image, ModelMap modelo) {
        try {

            servicioUsuario.update(id, name, password, password2, image);

            modelo.put("exito", "Usuario modificado correctamente!");

            return "redirect:../perfil/"+id;

        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            
            return "form-usuario.html";
        }

        
    }

    
}
