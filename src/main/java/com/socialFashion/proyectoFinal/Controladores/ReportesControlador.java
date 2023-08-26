package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/reporte")
public class ReportesControlador {

    @Autowired
    private ServicioReportUser servicioReportUsuario;

    @Autowired
    private ServicioReportComentario servicioReportComentario;

    @GetMapping("/reportar-usuario/{id}")
    public String reportarUsuario(@PathVariable String id) {
        return "reporte.html";
    }

    @PostMapping("/reportar-usuario/{id}")// Reporte de usuario 
    public String completarReporteUsuario(@RequestParam Usuario idUser, @RequestParam String idUserReported,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model) {

        try {
            servicioReportUsuario.crearReporte(idUser, idUserReported, reason, typeReport);
            model.addAttribute("exito", "Usuario reportado exitosamente");
        } catch (MiException e) {
            model.addAttribute("error", "Error al reportar el usuario");
        }
        return "reporte.html";

    }

    @PostMapping("/eliminarReporte/{id}") //Usuario
    public String eliminarReporteUsuario(@PathVariable String id, ModelMap model) {
        try {
            servicioReportUsuario.eliminarReporte(id);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {
            model.put("error", "No se pudo eliminar el reporte");
        }
        return ""; //Ver url

    }

    @GetMapping("/reportar-comentario/{id}")
    public String reportarComentario(@PathVariable String id) {
        return "reporte.html"; //Ver url
    }

    @PostMapping("/reportar-comentario/{id}")
    public String completarReporteComentario(@RequestParam String idComent, @RequestParam String idUser,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model) {
        try {
            servicioReportComentario.crearReporte(idComent, idUser, reason, typeReport);
            model.addAttribute("exito", "Comentario reportado exitosamente");
        } catch (MiException e) {
            model.addAttribute("error", "Error al reportar el comentario");
        }
        return "reporte.html";
    }

    @PostMapping("/eliminarReporte/{idComent}") //Comentario
    public String eliminarReporteComentario(@PathVariable String idComent, ModelMap model) {
        try {
            servicioReportComentario.eliminarReporte(idComent);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {

            model.put("error", "No se pudo eliminar el reporte");
        }

        return ""; //Ver url

    }

}
