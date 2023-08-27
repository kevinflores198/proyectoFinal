package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import java.util.List;
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

    @Autowired
    private ServicioReportPublicacion servicioReportPublicacion;

    @GetMapping("/reportar-usuario/{idUser}")
    public String reportarUsuario(@PathVariable String id) {
        return "reporte.html";
    }

    @PostMapping("/reportar-usuario/{idUser}")
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

    @PostMapping("/eliminarReporteUsuario/{idUser}") //Usuario
    public String eliminarReporteUsuario(@PathVariable String idUser, ModelMap model) {
        try {
            servicioReportUsuario.eliminarReporte(idUser);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {
            model.put("error", "No se pudo eliminar el reporte");
        }
        return ""; //Ver url

    }
//--------------------- COMENTARIOS -----------------------

    @GetMapping("/reportar-comentario/{idComent}")
    public String reportarComentario(@PathVariable String idComent) {
        return "reporte.html"; //Ver url
    }

    @PostMapping("/reportar-comentario/{idComent}")
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

    @PostMapping("/eliminarReporteComentario/{idComent}") //Comentario
    public String eliminarReporteComentario(@PathVariable String idComent, ModelMap model) {
        try {
            servicioReportComentario.eliminarReporte(idComent);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {

            model.put("error", "No se pudo eliminar el reporte");
        }

        return ""; //Ver url

    }

    // ----------------- PUBLICACION --------------------
    @GetMapping("/reportar-publicacion/{idPublicacion}")
    public String reportarPublicacion(@PathVariable String idPublicacion) {
        return "reporte.html";
    }

    @PostMapping("/reportar-publicacion/{idPublicacion}")
    public String completarReportePublicacion(@RequestParam String idPublicacion, @RequestParam String idUser,
            @RequestParam String reason, @RequestParam String reports, ModelMap model) {

        try {
            servicioReportPublicacion.crearReportePublicacion(idPublicacion, idUser, reason, reports);
            model.addAttribute("exito", "Publicacion reportada exitosamente");
        } catch (MiException e) {
            model.addAttribute("error", "Error al reportar la publicacion");
        }
        return "reporte.html";

    }

    @PostMapping("/eliminarReportePublicacion/{idReportPublicacion}")
    public String eliminarReportePublicacion(@PathVariable String idReportPublicacion, ModelMap model) {
        try {
            servicioReportPublicacion.eliminarReporte(idReportPublicacion);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {
            model.put("error", "No se pudo eliminar el reporte");
        }
        return ""; //Ver url

    }

    @GetMapping("/listarReportes")
    public String listarReportes(ModelMap model) {
        List<ReportUser> usuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> comentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> publicaciones = servicioReportPublicacion.listarReportesPulicacion();

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("publicaciones", publicaciones);

        return "listaReportes.html";
    }

}
