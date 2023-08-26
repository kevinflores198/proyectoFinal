package com.socialFashion.proyectoFinal.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/perfil")
public class UsuarioControlador{

    @Autowired
    private ServicioPublicacion servicioPublicacion;
    @Autowired
    private ServicioUsuario servicioUsuario;

    //VISTA PERFIL//
    @GetMapping("/perfil")
    public String perfil() {
        
        return "profile.html";

    }

    //CREAR UNA PUBLICACION//
    @PostMapping("/publicacion")
    public String publicacion(){

      return "vistapublicacion.html?";

    }

    //ACTUALIZAR PERFIL//
    @GetMapping("/actualiza")
    public String registrar() {

        return "vistaUpdate.html?";
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(@PathVariable String id, @RequestParam(name="name") String name, 
    @RequestParam(name="email") String email, 
    @RequestParam(name="birthDate") String birthDate, 
    @RequestParam(name="password") String password, 
    @RequestParam(name="password2") String password2, 
    MultipartFile image, ModelMap modelo){

      try {
            
        servicioUsuario.update(id, name, email, password, password2, image);

        modelo.put("exito", "Datos actualizados");

        return "profile.html";

    } catch (MiException ex) {
        
        modelo.put("error", ex.getMessage());
        modelo.put("nombre", name);
        modelo.put("email", email);

        return "vistaUpdate.html?";
    }

    }

}