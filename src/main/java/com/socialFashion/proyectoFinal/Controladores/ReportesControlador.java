package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsComentario;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsPublicacion;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioComentario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioUsuario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;
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
    
    @Autowired
    private RepositorioComentario repoComent;
    
    @Autowired
    private RepositorioUsuario repoUser;
    
    @Autowired
    private RepositorioPublicacion repoPubli;

    @GetMapping("/reportar-usuario/{idUser}")
    public String reportarUsuario(@PathVariable(name="idUser") String id, ModelMap model) {
        List<ReportsUser> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsUser.values()));
        model.addAttribute("reports", reports);
        return "report.html";
    }

    @PostMapping("/reportar-usuario/{idUser}")
    public String completarReporteUsuario(@PathVariable(name="idUser") String idUserReported,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model, HttpSession session) {

        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportUsuario.crearReporte(logueado.getId(), repoUser.usuarioById(idUserReported), reason, typeReport);
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
        List<ReportsComentario> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsComentario.values()));
        model.addAttribute("reports", reports);
        return "report.html"; //Ver url
    }

    @PostMapping("/reportar-comentario/{idComent}")
    public String completarReporteComentario(@PathVariable String idComent, @RequestParam String reason,
            @RequestParam String typeReport, ModelMap model, HttpSession session) {
        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportComentario.crearReporte(idComent, logueado.getId(), reason, typeReport);
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
        List<ReportsPublicacion> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsPublicacion.values()));
        model.addAttribute("reports", reports);
        return "report.html";
    }

    @PostMapping("/reportar-publicacion/{idPublicacion}")
    public String completarReportePublicacion(@PathVariable String idPublicacion,
            @RequestParam String reason, @RequestParam String reports, ModelMap model, HttpSession session) {

        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportPublicacion.crearReportePublicacion(idPublicacion, logueado.getId(), reason, reports);
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
