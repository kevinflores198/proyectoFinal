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

@Controller
@RequestMapping("/perfil")
public class UsuarioControlador{

    @Autowired
    private ServicioPublicacion servicioPublicacion;

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

}