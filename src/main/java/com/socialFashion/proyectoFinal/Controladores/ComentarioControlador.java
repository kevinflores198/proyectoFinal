package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/comentarios")
public class ComentarioControlador {

    @Autowired
    private ServicioComentario servicioComentario;

    @PostMapping("/crear")
    public String crearComentario(@ModelAttribute Comentario comentario, ModelMap model) {
        try {
            servicioComentario.crearComentario(comentario.getIdUser(), comentario.getPublicacion().getId(), comentario.getComment());
            model.put("exito", "Comentario publicado exitosamente");
        } catch (MiException e) {
            model.put("error", e.getMessage());
        } catch (Exception e) {
            model.put("error", "No se pudo publicar el comentario.");
        }
        return "detail.html";
    }

    @GetMapping("/listar")
    public String obtenerTodosLosComentarios(ModelMap model) {
        try {
            List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
            model.put("comentarios", comentarios);
        } catch (Exception e) {
            model.put("error", "Error interno del servidor");
        }
        return "lista_comentarios";
    }

//   @GetMapping("/{id}")
//    public String obtenerComentarioPorId(@PathVariable String id, ModelMap model) {
//        try {
//            Optional<Comentario> comentario = servicioComentario.obtenerComentarioPorId(id);
//            model.put("comentario", comentario.orElse(null));
//        } catch (Exception e) {
//            model.put("error", "No se encontró ningun comentario.");
//        }
//        return "detalle_comentario";
//    }

    @PostMapping("/eliminar/{id}")
    public String eliminarComentario(@PathVariable String id, ModelMap model) {
        try {
            servicioComentario.eliminarComentario(id);
            model.put("Exito", "Comentario eliminado exitosamente");
        } catch (Exception e) {
            model.put("error", "Error interno del servidor");
        }
        return "vista";
    }
}

