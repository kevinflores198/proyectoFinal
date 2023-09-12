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
        System.out.println("se ingreso al URL");
        List<ReportsUser> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsUser.values()));
        model.addAttribute("tipoReporte", reports);
        model.addAttribute("usuario", servicioUsuario.getOne(id));

        System.out.println("se cargo todo");
        return "report-usuario.html";
    }

    @PostMapping("/reportar-usuario/{idUser}")
    public String completarReporteUsuario(@PathVariable(name = "idUser") String idUserReported,
            @RequestParam String reason, @RequestParam String typeReport, ModelMap model, HttpSession session) {

        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportUsuario.crearReporte(servicioUsuario.getOne(logueado.getId()).getId(), servicioUsuario.getOne(idUserReported), reason,
                    typeReport);
            model.put("exito", "Usuario reportado exitosamente");
            
            List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
            model.addAttribute("publicaciones", publicaciones);

            model.addAttribute("usuario", servicioUsuario.getOne(logueado.getId()));

            return "main.html";

        } catch (MiException ex) {

            model.put("error", "Error al reportar el usuario");
            List<ReportsUser> reports = new ArrayList<>();
            reports.addAll(Arrays.asList(ReportsUser.values()));
            model.addAttribute("tipoReporte", reports);
            return "report-usuario.html";
        }
        

    }

    // --------------------- COMENTARIOS -----------------------

    @GetMapping("/reportar-comentario/{idComent}")
    public String reportarComentario(@PathVariable String idComent, ModelMap model) {
        List<ReportsComentario> reports = new ArrayList<>();
        reports.addAll(Arrays.asList(ReportsComentario.values()));
        model.addAttribute("tipoReporte", reports);
        model.addAttribute("coment", servicioComentario.getOne(idComent));

        return "report-comentario.html";
    }

    @PostMapping("/reportar-comentario/{idComent}")
    public String completarReporteComentario(@PathVariable String idComent, @RequestParam String reason,
            @RequestParam String typeReport, ModelMap model, HttpSession session) {
        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportComentario.crearReporte(idComent, servicioUsuario.getOne(logueado.getId()).getId(), reason, typeReport);

            model.put("exito", "Comentario reportado exitosamente");

            Publicacion publicacion = servicioComentario.getOne(idComent).getPublicacion();
            model.addAttribute("publicacion", publicacion);

            List<Comentario> comentarios = servicioComentario.getComentariosByPublicacion(publicacion.getId());
            model.addAttribute("comentarios", comentarios);

            model.addAttribute("usuario", servicioUsuario.getOne(logueado.getId()));

            List<ReportsPublicacion> reportes = new ArrayList<>();
            for (ReportsPublicacion reporte : ReportsPublicacion.values()) {
                reportes.add(reporte);
            }
            model.addAttribute("tipoReporte", reportes);

            return "detail.html";

        } catch (MiException e) {

            model.put("error", "Error al reportar el comentario");

            List<ReportsComentario> reportes = new ArrayList<>();
            for (ReportsComentario reporte : ReportsComentario.values()) {
                reportes.add(reporte);
            }
            model.addAttribute("tipoReporte", reportes);
            
            return "report-comentario.html";
        }

        
    }

    // ----------------- PUBLICACION --------------------

    @PostMapping("/reportar-publicacion/{idPublicacion}")
    public String completarReportePublicacion(@PathVariable String idPublicacion,
            @RequestParam String reason, @RequestParam(name="typeReport") String typeReport, ModelMap model, HttpSession session) {

        try {
            Usuario logueado = (Usuario) session.getAttribute("usuariosession");
            servicioReportPublicacion.crearReportePublicacion(idPublicacion, servicioUsuario.getOne(logueado.getId()).getId(), reason, typeReport);

            List<ReportsPublicacion> reportes = new ArrayList<>();
            for (ReportsPublicacion reporte : ReportsPublicacion.values()) {
                reportes.add(reporte);
            }
            model.addAttribute("tipoReporte", reportes);

            model.addAttribute("publicacion", servicioPublicacion.getOne(idPublicacion));

            model.addAttribute("comentarios", servicioComentario.getComentariosByPublicacion(idPublicacion));

            model.addAttribute("usuario", servicioUsuario.getOne(logueado.getId()));

            model.put("exito", "Publicacion reportada exitosamente");
        } catch (MiException e) {

            List<ReportsPublicacion> reportes = new ArrayList<>();
            for (ReportsPublicacion reporte : ReportsPublicacion.values()) {
                reportes.add(reporte);
            }
            model.addAttribute("tipoReporte", reportes);

            model.put("error", "Error al reportar la publicacion");

        }
        return "detail.html";

    }

// REPORTES DE USUARIO

    @GetMapping("/reporteUsuario/ban/{idReporte}")
    public String banReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo, HttpSession session) throws MiException{

        servicioUsuario.banearUsuario(repoReportUsuario.getById(idReporte).getUserReported().getId());
        servicioReportUsuario.eliminarReporte(idReporte);
        
        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteUsuario/eliminar/{idReporte}")
    public String eliminarUsuarioReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo, HttpSession session) throws MiException{

        servicioUsuario.delete(repoReportUsuario.getById(idReporte).getUserReported().getId());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteUsuario/{idReporte}")
    public String eliminarReporteUser(@PathVariable(name = "idReporte") String idReporte, ModelMap modelo, HttpSession session) throws MiException{

        servicioReportUsuario.eliminarReporte(idReporte);
        
        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

// REPORTES DE COMENTARIO

    @GetMapping("/reporteComentario/eliminar/{idReporte}")
    public String eliminarComentarioReporteComentario(@PathVariable String idReporte, ModelMap modelo, HttpSession session){

        servicioComentario.eliminarComentario(repoReportComentario.getById(idReporte).getComentario().getIdComent());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reporteComentario/{idReporte}")
    public String eliminarReporteComentario(@PathVariable String idReporte, ModelMap modelo, HttpSession session){

        servicioReportComentario.eliminarReporte(idReporte);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

// REPORTES DE PUBLICACION

    @GetMapping("/reportePublicacion/eliminar/{idReporte}")
    public String eliminarPublicacionReportePublicacion(@PathVariable String idReporte, ModelMap modelo, HttpSession session) throws MiException{

        servicioPublicacion.eliminar(repoReportPublicacion.getById(idReporte).getPublicacion().getId());

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

    @GetMapping("/reportePublicacion/{idReporte}")
    public String eliminarReportePublicacion(@PathVariable String idReporte, ModelMap modelo, HttpSession session){

        servicioReportPublicacion.eliminarReporte(idReporte);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Usuario> usuarios = servicioUsuario.listUsers();
        List<Comentario> comentarios = servicioComentario.obtenerTodosLosComentarios();
        List<ReportUser> reportUsuarios = servicioReportUsuario.listarReportes();
        List<ReportComentario> reportComentarios = servicioReportComentario.listarReportes();
        List<ReportPublicacion> reportPublicaciones = servicioReportPublicacion.listarReportesPulicacion();
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();

        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("usuarios", usuarios);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("reportesUsuario", reportUsuarios);
        modelo.addAttribute("reportesPublicacion", reportPublicaciones);
        modelo.addAttribute("reportesComentario", reportComentarios);

        return "listado.html";
    }

    }


