package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
//import com.socialFashion.proyectoFinal.Enumeraciones.ReportsComentario;
//import com.socialFashion.proyectoFinal.Enumeraciones.ReportsPublicacion;
//import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
//import java.util.ArrayList;
//import java.util.Arrays;
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
    public String reportarUsuario(@PathVariable String id, ModelMap model) {
        /*
        List<ReportsUser> reports = new ArrayList<>();
        for (ReportsUser value : ReportsUser.values()) {
            reports.add(value);
        }
        model.addAttribute("reports", reports);
        */
        return "report.html";
    }

    @PostMapping("/reportar-usuario/{idUser}")
    public String completarReporteUsuario(@RequestParam Usuario idUser, @RequestParam String idUserReported,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model) {

        try {
            servicioReportUsuario.crearReporte(idUser, idUserReported, reason, typeReport);
            model.put("exito", "Usuario reportado exitosamente");
        } catch (MiException e) {
            model.put("error", "Error al reportar el usuario");
        }
        return "report.html";

    }
    
    
    //POST --> GET ?¿
    @PostMapping("/eliminarReporteUsuario/{idUser}") //Usuario
    public String eliminarReporteUsuario(@PathVariable String idUser, ModelMap model) {
        try {
            servicioReportUsuario.eliminarReporte(idUser);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {
            model.put("error", "No se pudo eliminar el reporte");
        }
        return "reports-list.html"; //Ver url

    }
//--------------------- COMENTARIOS -----------------------

    @GetMapping("/reportar-comentario/{idComent}")
    public String reportarComentario(@PathVariable String idComent, ModelMap model) {
        /*  ------ TESTEAR ------
        List<ReportsComentario> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsComentario.values()));
        model.addAttribute("reports", reports);
        */
        return "report.html"; //Ver url
    }

    @PostMapping("/reportar-comentario/{idComent}")
    public String completarReporteComentario(@RequestParam String idComent, @RequestParam String idUser,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model) {
        try {
            servicioReportComentario.crearReporte(idComent, idUser, reason, typeReport);
            model.put("exito", "Comentario reportado exitosamente");
        } catch (MiException e) {
            model.put("error", "Error al reportar el comentario");
        }
        return "report.html";
    }

    
    //POST --> GET ?¿
    @PostMapping("/eliminarReporteComentario/{idComent}") //Comentario
    public String eliminarReporteComentario(@PathVariable String idComent, ModelMap model) {
        try {
            servicioReportComentario.eliminarReporte(idComent);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {

            model.put("error", "No se pudo eliminar el reporte");
        }

        return "reports-list.html"; //Ver url

    }

    // ----------------- PUBLICACION --------------------
    @GetMapping("/reportar-publicacion/{idPublicacion}")
    public String reportarPublicacion(@PathVariable String idPublicacion, ModelMap model) {
        /*
        List<ReportsPublicacion> reports = new ArrayList<>();
        for (ReportsPublicacion value : ReportsPublicacion.values()) {
            reports.add(value);
        }
        model.addAttribute("reports", reports);
        */
        return "report.html";
    }

    @PostMapping("/reportar-publicacion/{idPublicacion}")
    public String completarReportePublicacion(@RequestParam String idPublicacion, @RequestParam String idUser,
            @RequestParam String reason, @RequestParam String reports, ModelMap model) {

        try {
            servicioReportPublicacion.crearReportePublicacion(idPublicacion, idUser, reason, reports);
            model.put("exito", "Publicacion reportada exitosamente");
        } catch (MiException e) {
            model.put("error", "Error al reportar la publicacion");
        }
        return "report.html";

    }

    
    //POST --> GET ?¿
    @PostMapping("/eliminarReportePublicacion/{idReportPublicacion}")
    public String eliminarReportePublicacion(@PathVariable String idReportPublicacion, ModelMap model) {
        try {
            servicioReportPublicacion.eliminarReporte(idReportPublicacion);
            model.put("exito", "reporte eliminado correctamente");

        } catch (Exception e) {
            model.put("error", "No se pudo eliminar el reporte");
        }
        return "reports-list.html"; //Ver url

    }

    @GetMapping("/listarReportes")
    public String listarReportes(ModelMap model) {
        List<ReportUser> usuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> comentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> publicaciones = servicioReportPublicacion.listarReportesPulicacion();

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("publicaciones", publicaciones);

        return "reports-list.html";
    }

}
