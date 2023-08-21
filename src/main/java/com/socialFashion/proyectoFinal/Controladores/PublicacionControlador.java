package com.socialFashion.proyectoFinal.controllers;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
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
public class PublicacionControlador {

    private ServicioPublicacion servicioPublicacion;

    @GetMapping("/publicar{id}")
    public String publicar(@PathVariable String idUser, @RequestParam String label, @RequestParam MultipartFile archivo, @RequestParam String content, ModelMap modelo){

        try {

            servicioPublicacion.crearPublicacion(idUser,label, archivo, content);

            modelo.put("exito", "Publicacion creada correctamente");

        }catch(MiException ex){

            modelo.put("error", "No se logro cargar la publicacion");

        }
        return "publicacion.html";
    }
    @PostMapping("/publicar/{id}")
    //Hacer PostMapping

    @GetMapping("/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable String id, ModelMap modelo) {

        try {
            servicioPublicacion.eliminar(id);

            modelo.put("exito", "Publicación eliminada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo eliminar la publicación");
        }
        return "profile.html";
    }

    // A revisar este metodo que lo hice para mostrar el formulario de edición de
    // etiquetas y contenido.
    @GetMapping("/editar/{id}")
    public String modificarPublicacion(@PathVariable String id, ModelMap modelo) {

        Publicacion publicacion = servicioPublicacion.getOne(id);

        modelo.put("publicacion", publicacion);

        return "publicacion.html"; // ???
    }

    // A revisar este metodo que lo hice para guardar la edición de etiquetas y
    // contenido.
    @PostMapping("/editar/{id}")
    public String guardarEdicionPublicacion(@PathVariable String id, @RequestParam String newLabel,
         @RequestParam String newContent, ModelMap modelo) {

        try {
            servicioPublicacion.modificarPublicacion(newLabel, id, newContent);

            modelo.put("exito", "Publicación editada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo editar la publicación");
        }

        return "profile.html";
    }
}