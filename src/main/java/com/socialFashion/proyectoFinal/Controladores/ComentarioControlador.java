package com.socialFashion.proyectoFinal.Controladores;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioUsuario;
import com.socialFashion.proyectoFinal.Servicios.ServicioComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/comentario")
public class ComentarioControlador {
    
    @Autowired
    private ServicioComentario servicioComentario;

    @Autowired
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioReportComentario servicioReportComentario;

    @Autowired
    private ServicioReportPublicacion servicioReportPublicacion;

    @Autowired
    private ServicioReportUser servicioReportUsuario;

    @PostMapping("/comentar/{idPublicacion}")
    public String cargarComentario(@PathVariable String idPublicacion, @RequestParam() String comment
        , HttpSession session, ModelMap modelo) throws MiException{
        
        try {
            String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();
            servicioComentario.crearComentario(idUsuario, idPublicacion, comment);

            List<Comentario> comentarios = servicioComentario.getComentariosByPublicacion(idPublicacion);
            
            modelo.addAttribute("comentarios", comentarios);
            modelo.addAttribute("publicacion", servicioPublicacion.getOne(idPublicacion));
            modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));
            
        } catch (MiException ex) {
            modelo.put("error", "No se pudo cargar el comentario debido a " + ex.getMessage());
        }

        return "detail.html";
    }

    @GetMapping("/detail/eliminar/{idComent}")
    public String eliminarComentario(@PathVariable String idComent, ModelMap modelo, HttpSession session){

        Publicacion publicacion = servicioComentario.getOne(idComent).getPublicacion();
        modelo.addAttribute("publicacion", publicacion);
        
        String idUsuario = ((Usuario) session.getAttribute("usuariosession")).getId();
        modelo.addAttribute("usuario", servicioUsuario.getOne(idUsuario));

        servicioComentario.eliminarComentario(idComent);

        List<Comentario> comentarios = servicioComentario.getComentariosByPublicacion(publicacion.getId());
        modelo.addAttribute("comentarios", comentarios);

        return "detail.html";
    }

    @GetMapping("/listado/eliminar/{idComent}")
    public String eliminarComentarioLista(@PathVariable String idComent, ModelMap modelo, HttpSession session){

        servicioComentario.eliminarComentario(idComent);

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
