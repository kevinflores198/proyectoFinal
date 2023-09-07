package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsPublicacion;
// import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    private ServicioUsuario servicioUsuario;
    
    @Autowired
    private RepositorioPublicacion repoPublicacion;
    
    @Autowired
    private ServicioComentario servicioComentario;

    @PostMapping("/publicar/{idUser}")
    public String cargarPublicacion(@PathVariable String idUser, @RequestParam String label, @RequestParam MultipartFile archivo, @RequestParam String content, ModelMap modelo){

        try {
            System.out.println(idUser);
            System.out.println(label);
            System.out.println(content);
            servicioPublicacion.crearPublicacion(idUser, label, archivo, content);

            modelo.put("exito", "Publicación cargada correctamente");

            List<Categorias> categorias = new ArrayList<>();
            for(Categorias categoria : Categorias.values()){
                categorias.add(categoria);
            }
            Usuario usuario = servicioUsuario.getOne(idUser);
            List<Publicacion> publicaciones = repoPublicacion.publicacionesByUser(idUser);
            modelo.addAttribute("usuario", usuario);
            modelo.addAttribute("publicaciones", publicaciones);
            modelo.addAttribute("categorias", categorias);

        } catch (MiException ex) {

            modelo.put("error", "No se pudo cargar la publicación");
        }
        return "perfil.html";
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
    @GetMapping("/detail/{id}")
    public String CartaPublicacion(@PathVariable String id, ModelMap modelo, HttpSession session) {

        Publicacion publicacion = servicioPublicacion.getOne(id);
        modelo.addAttribute("publicacion", publicacion);

        List<Comentario> comentarios = servicioComentario.getComentariosByPublicacion(id);
        modelo.addAttribute("comentarios", comentarios);

        List<ReportsPublicacion> reportes = new ArrayList<>();
        for (ReportsPublicacion reporte : ReportsPublicacion.values()) {
            reportes.add(reporte);
        }
        modelo.addAttribute("tipoReporte", reportes);

        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        modelo.addAttribute("usuario", usuario);
        //RETORNAR A SU HTML 
        return "detail.html";

    }
    
    @GetMapping("/MG/{id}")
    public String agregarLike(@PathVariable String id, ModelMap modelo, HttpSession session){
        
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        servicioPublicacion.Like(id, usuario);

        return "redirect:/main";
    }
    @GetMapping("/detail/MG/{id}")
    public String agregarLikeDetail(@PathVariable String id, ModelMap modelo, HttpSession session){
        
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        servicioPublicacion.Like(id, usuario);

        return "redirect:/publicacion/detail/"+id;
    }

    // @GetMapping("/MGmore/{id}")
    // public String agregarLike(@PathVariable String id, ModelMap modelo/* , List<Publicacion> publis*/){
        
    //     servicioPublicacion.Like(id, true);
        
    //     List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
    //     //publis.add(servicioPublicacion.getOne(id));
    //     // for (Publicacion publicacion : publicaciones) {
    //     //     if(publis.contains(publicacion)){
    //     //         publicaciones.remove(publicacion);
    //     //     }
    //     // }

    //     modelo.addAttribute("publicaciones", publicaciones);
        
    //     modelo.addAttribute("validar", true);
        
    //     // modelo.addAttribute("likeadas", publis);

    //     return "main.html";
    // }

}