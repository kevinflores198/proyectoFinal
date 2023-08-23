package com.socialFashion.proyectoFinal.Controladores;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;
import java.time.Instant;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;
    
    // VISTA INDEX
    @GetMapping("/")
    public String index() {

        return "index.html";

    }

    // VISTA DE REGISTRAR
    @GetMapping("/registrar")
    public String registrar() {

        return "guest.html";
    }

    // FORMULARIO DE REGISTRO DE USUARIO
    @PostMapping("/registro")
    public String registro(@RequestParam(name="name") String name, 
            @RequestParam(name="email") String email, 
            @RequestParam(name="birthDate") String birthDate, 
            @RequestParam(name="password") String password, 
            @RequestParam(name="password2") String password2, 
            MultipartFile image, ModelMap modelo) {
        
        try {
            
            servicioUsuario.register(name, email, DateConverter(birthDate), password, password2, image);

            modelo.put("exito", "Usuario registrado correctamente!");

            return "main.html";
        } catch (MiException ex) {

            System.out.println(ex.getMessage());
            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            modelo.put("email", email);

            return "guest.html";
        }

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

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/main")
    public String inicio(HttpSession session) {
        
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        
        if (logueado.getRole().toString().equals("ADMIN")) {
            return "main.html";
        }
        
           return "main.html";
    }
    
    private Date DateConverter(String fecha){
        
        Date birthDate = new Date();
        
        birthDate.setDate(Integer.valueOf(fecha.substring(8, 10)));
        birthDate.setMonth(Integer.valueOf(fecha.substring(5, 7))-1);
        birthDate.setYear(Integer.valueOf(fecha.substring(1, 4))+100);
        
        return birthDate;
        
    }

    //PERFIL VISTA (PENDIENTE)

    //ACTUALIZAR PERFIL VISTA (PENDIENTE)

}
