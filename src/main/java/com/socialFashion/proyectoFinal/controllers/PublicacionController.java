package com.socialFashion.proyectoFinal.controllers;

import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.servicioPublicacion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/publicacion")
public class PublicacionController {
    

    @GetMapping("/publicar")
    public String publicar(@PathVariable String idUser, @RequestParam String label, @RequestParam MultipartFile archivo, @RequestParam String content, ModelMap modelo){

try {
    servicioPublicacion.crearPublicacion(idUser,label, archivo, content);

            modelo.put("exito", "Publicacion creada correctamente");

            return "profile.html";

        }catch(MiException ex){

            modelo.put("error", "No se logro cargar la publicacion");

            return "profile.html";
            
            
            
             @GetMapping("/{id}/eliminar")
             public String eliminarPublicacion(@PathVariable Long id, ModelMap modelo) {

        try {
            servicioPublicacion.eliminarPublicacion(id);

            modelo.put("exito", "Publicación eliminada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo eliminar la publicación");
        }
        return "profile.html";
    }
             
    @PostMapping("/{id}/eliminar")
    public String eliminarPublicacion(@PathVariable Long id) {
        servicioPublicacion.eliminarPublicacion(id);
        return "profile.html";
    }

    // A revisar este metodo que lo hice para mostrar el formulario de edición de etiquetas y contenido.
    @GetMapping("/{id}/editar")
    public String mostrarModificacion(@PathVariable Long id, ModelMap modelo) {

        Publicacion publicacion = servicioPublicacion.obtenerPublicacionPorId(id);

        modelo.put("publicacion", publicacion);

        return ""; //???
    }

    // A revisar este metodo que lo hice para guardar la edición de etiquetas y contenido.
    @PostMapping("/{id}/editar")
    public String guardarEdicionPublicacion(@PathVariable Long id, @RequestParam String newLabel,@RequestParam MultipartFile newArchivo, @RequestParam String newContent, ModelMap modelo) {
        
            try {
                servicioPublicacion.editarPublicacion(id, newLabel, newArchivo, newContent);
                
                modelo.put("exito", "Publicación editada correctamente");
                
        } catch (MiException ex) {
            
            modelo.put("error", "No se pudo editar la publicación");
        }
        return "profile.html";
    }
}


        }
   }
    
}

   






