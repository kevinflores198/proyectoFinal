package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import java.util.ArrayList;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/publicar/{id}")
    public String publicar(@PathVariable String id, ModelMap model){
        /*  ------ PROBAR -------
        List<Categorias> categorias = new ArrayList<>();
        for(Categorias categoria : Categorias.values()){
            categorias.add(categoria);
        }
        model.addAttribute("categorias", categorias);
        */
        return "publicacion.html";
    }

    @PostMapping("/publicar/{id}")
    public String cargarPublicacion(@PathVariable String idUser, @RequestParam String label, @RequestParam MultipartFile archivo, @RequestParam String content, ModelMap modelo){

        try {
            servicioPublicacion.crearPublicacion(idUser, label, archivo, content);

            modelo.put("exito", "Publicación cargada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo cargar la publicación");
        }
        return "publicacion-form.html";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPublicacion(@PathVariable String id, ModelMap modelo) {

        try {

            servicioPublicacion.eliminar(id);

            modelo.put("exito", "Publicación eliminada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo eliminar la publicación");

        }
        return "perfil.html";
        
    }

    // A revisar este metodo que lo hice para mostrar el formulario de edición de
    // etiquetas y contenido.
    @GetMapping("/editar/{id}")
    public String modificarPublicacion(@PathVariable String id, ModelMap modelo) {

        modelo.put("Publicacion", servicioPublicacion.getOne(id));

        return "publicacion.html";
    }

    @PostMapping("/editar/{id}")
    public String modificadoPublicacion(@PathVariable String id, @RequestParam String newLabel,
         @RequestParam String newContent, ModelMap modelo) {

        try {

            servicioPublicacion.modificarPublicacion(newLabel, id, newContent);

            modelo.put("exito", "Publicación editada correctamente");

        } catch (MiException ex) {

            modelo.put("error", "No se pudo editar la publicación");
        }

        return "perfil.html";
        
    }

    //VISTA DE LISTA DE PUBLICACIONES 
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/listar-publicaciones")
    public String listaPublicaciones(ModelMap modelo) {

        List<Publicacion>publicaciones=servicioPublicacion.listaPublicacion();
        modelo.addAttribute("publicaciones", publicaciones);

        //RETORNAR A SU HTML 
        return "lista-publicaciones.html";

    }

    //VISTA DE CARTA 
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/card/{id}")
    public String CartaPublicacion(@PathVariable String id, ModelMap modelo) {

        Publicacion publicacion = servicioPublicacion.getOne(id);
        modelo.addAttribute("publicacion", publicacion);

        //RETORNAR A SU HTML 
        return "detail.html";

    }
    
    @GetMapping("/MG+/{id}")
    public void agregarLike(@PathVariable String id){
        servicioPublicacion.agregarLike(id);
    }
    
    @GetMapping("/MG-/{id}")
    public void sacarLike(@PathVariable String id){
        servicioPublicacion.sacarLike(id);
    }
}