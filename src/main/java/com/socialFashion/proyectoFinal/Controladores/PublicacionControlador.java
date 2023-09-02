package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
// import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    

    // @GetMapping("/publicar/{id}")
    // public String publicar(@PathVariable String id, ModelMap model){
    //     /*  ------ PROBAR -------
    //     List<Categorias> categorias = new ArrayList<>();
    //     for(Categorias categoria : Categorias.values()){
    //         categorias.add(categoria);
    //     }
    //     model.addAttribute("categorias", categorias);
    //     */
    //     return "publicacion.html";
    // }

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
    public String CartaPublicacion(@PathVariable String id, ModelMap modelo) {

        Publicacion publicacion = servicioPublicacion.getOne(id);
        // Usuario usuario = publicacion.getUser();
        // modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("publicacion", publicacion);

        //RETORNAR A SU HTML 
        return "detail.html";

    }
    
    @GetMapping("/MGmore/{id}")
    public String agregarLike(@PathVariable String id, ModelMap modelo){
        
        servicioPublicacion.Like(id, true);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        modelo.addAttribute("publicaciones", publicaciones);
        
        modelo.addAttribute("validar", true);
        
        modelo.addAttribute("likeada", id);

        return "main.html";
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
    
    @GetMapping("/MGless/{id}")
    public String sacarLike(@PathVariable String id, ModelMap modelo){
        
        servicioPublicacion.Like(id, false);

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("validar", false);

        return "main.html";
    }
}