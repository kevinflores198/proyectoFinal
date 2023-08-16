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
    public String publicacion(@PathVariable String idUser, @RequestParam String label, @RequestParam MultipartFile archivo, @RequestParam String content, ModelMap modelo){

        try {
            servicioPublicacion.crearPublicacion(idUser, label, archivo, content);

            modelo.put("exito", "Publicacion creada correctamente");
            
            return "profile.html";
        }catch(MiException ex){

            modelo.put("error", "No se logro cargar la publicacion");

            return "profile.html";

        }
        
    }

}