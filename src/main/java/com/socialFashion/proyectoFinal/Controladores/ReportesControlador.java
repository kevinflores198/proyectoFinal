package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
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
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteComentario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReportePublicacion;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteUsuario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioUsuario;
import com.socialFashion.proyectoFinal.Servicios.ServicioComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

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
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    private ServicioComentario servicioComentario;

    @Autowired
    private RepositorioReporteUsuario repoReportUsuario;

    @Autowired
    private RepositorioReporteComentario repoReportComentario;

    @Autowired
    private RepositorioReportePublicacion repoReportPublicacion;

    @GetMapping("/reportar-usuario/{idUser}")
    public String reportarUsuario(@PathVariable(name = "idUser") String id, ModelMap model) {
        List<ReportsUser> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsUser.values()));
        model.addAttribute("reports", reports);
        return "report.html";
    }

    @PostMapping("/reportar-usuario/{idUser}")
    public String completarReporteUsuario(@PathVariable(name = "idUser") String idUserReported,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model, HttpSession session) {

        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportUsuario.crearReporte(logueado.getId(), servicioUsuario.getOne(idUserReported), reason,
                    typeReport);
            model.put("exito", "Usuario reportado exitosamente");
        } catch (MiException e) {
            model.put("error", "Error al reportar el usuario");
        }
        return "report.html";

    }

    // --------------------- COMENTARIOS -----------------------

    @GetMapping("/reportar-comentario/{idComent}")
    public String reportarComentario(@PathVariable String idComent, ModelMap model) {
        List<ReportsComentario> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsComentario.values()));
        model.addAttribute("reports", reports);
        return "report.html";
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

    // // POST --> GET ?¿
    // @PostMapping("/eliminarReporteComentario/{idComent}") // Comentario
    // public String eliminarReporteComentario(@PathVariable String idComent, ModelMap model) {
    //     try {
    //         servicioReportComentario.eliminarReporte(idComent);
    //         model.put("exito", "reporte eliminado correctamente");

    //     } catch (Exception e) {

    //         model.put("error", "No se pudo eliminar el reporte");
    //     }

    //     return "listado.html";

    // }

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

    // @PostMapping("/eliminarReportePublicacion/{idReportPublicacion}")
    // public String eliminarReportePublicacion(@PathVariable String idReportPublicacion, ModelMap model) {
    //     try {
    //         servicioReportPublicacion.eliminarReporte(idReportPublicacion);
    //         model.put("exito", "reporte eliminado correctamente");

    //     } catch (Exception e) {
    //         model.put("error", "No se pudo eliminar el reporte");
    //     }
    //     return "listado.html"; // Ver url

    // }

    @GetMapping("/listarReportes")
    public String listarReportes(@RequestParam(required = false, name = "tipoReporte") String tipoReporte,
            ModelMap model) {
        List<Object> reportes = new ArrayList<>();

        if (tipoReporte.equals("usuarios")) {
            List<ReportUser> usuarios = servicioReportUsuario.listarReportes();
            reportes.addAll(usuarios);
        } else if (tipoReporte.equals("comentarios")) {
            List<ReportComentario> comentarios = servicioReportComentario.listarReportes();
            reportes.addAll(comentarios);
        } else if (tipoReporte.equals("publicaciones")) {
            List<ReportPublicacion> publicaciones = servicioReportPublicacion.listarReportesPulicacion();
            reportes.addAll(publicaciones);
        } else {
            List<ReportUser> usuarios = servicioReportUsuario.listarReportes();
            List<ReportComentario> comentarios = servicioReportComentario.listarReportes();
            List<ReportPublicacion> publicaciones = servicioReportPublicacion.listarReportesPulicacion();
            reportes.addAll(usuarios);
            reportes.addAll(comentarios);
            reportes.addAll(publicaciones);
        }

        model.addAttribute("reportes", reportes);

        return "listado.html";
    }

        // ------------------------ Eliminar Reportes -------------------------

    //     @PostMapping("/eliminarReporteUsuario/{idUser}") // Usuario
    // public String eliminarReporteUsuario(@PathVariable String idUser, ModelMap model) {
    //     try {
    //         servicioReportUsuario.eliminarReporte(idUser);
    //         model.put("exito", "reporte eliminado correctamente");

    //     } catch (Exception e) {
    //         model.put("error", "No se pudo eliminar el reporte");
    //     }
    //     return "listado.html";
    
    // }

    @GetMapping("/reporteUsuario/ban/{idReporte}")
    public String banReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo) throws MiException{

        servicioReportUsuario.eliminarReporte(idReporte);
        servicioUsuario.banearUsuario(repoReportUsuario.getById(idReporte).getIdUserReported().getId());
        
        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteUsuario/eliminar/{idReporte}")
    public String eliminarUsuarioReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo) throws MiException{

        servicioUsuario.delete(repoReportUsuario.getById(idReporte).getIdUserReported().getId());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteUsuario/{idReporte}")
    public String eliminarReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo) throws MiException{

        servicioReportUsuario.eliminarReporte(idReporte);
        
        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }
    
    @GetMapping("/reporteComentario/eliminar/{idReporte}")
    public String eliminarComentarioReporteComentario(@PathVariable String idReporte, ModelMap modelo){

        servicioComentario.eliminarComentario(repoReportComentario.getById(idReporte).getComentario().getIdComent());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteComentario/{idReporte}")
    public String eliminarReporteComentario(@PathVariable String idReporte, ModelMap modelo){

        servicioReportComentario.eliminarReporte(idReporte);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }
    @GetMapping("/reportePublicacion/eliminar/{idReporte}")
    public String eliminarPublicacionReportePublicacion(@PathVariable String idReporte, ModelMap modelo) throws MiException{

        servicioPublicacion.eliminar(repoReportPublicacion.getById(idReporte).getPublicacion().getId());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reportePublicacion/{idReporte}")
    public String eliminarReportePublicacion(@PathVariable String idReporte, ModelMap modelo){

        servicioReportPublicacion.eliminarReporte(idReporte);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("cometarios", comentarios);
        modelo.addAttribute("repotesUsuario", reportUsuarios);
        modelo.addAttribute("repotespublicacion", reportPublicaciones);
        modelo.addAttribute("repotesComentario", reportComentarios);

        return "listado.html";
    }

    // @PostMapping("/eliminarReporte/{idReporte}")
    // public String eliminarReporte(@RequestParam("idReporte") String idReporte, @RequestParam("tipoReporte") String tipoReporte, ModelMap model){

    //     try {
    //         if("usuarios".equals(tipoReporte)){
    //             servicioReportUsuario.eliminarReporte(idReporte);
    //         } else if("comentarios".equals(tipoReporte)){
    //             servicioReportComentario.eliminarReporte(idReporte);
    //         } else if("publicaciones".equals(tipoReporte)){
    //             servicioReportPublicacion.eliminarReporte(idReporte);
    //         }

    //         model.put("exito", "Reporte eliminado correctamente");
            
    //     } catch (Exception e) {
    //         model.put("error", "No se pudo eliminar el reporte");   
    //     }

    //     return "listado.html";
    // }


    }


