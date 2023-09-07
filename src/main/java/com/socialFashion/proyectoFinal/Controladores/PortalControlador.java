package com.socialFashion.proyectoFinal.Controladores;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioBaneo;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportComentario;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportPublicacion;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;

    @Autowired
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    private ServicioComentario servicioComentario;
    
    @Autowired
    private RepositorioPublicacion repoPublicacion;

    @Autowired
    private RepositorioBaneo repoBaneo;

    @Autowired
    private ServicioReportComentario servicioReportComentario;

    @Autowired
    private ServicioReportUser servicioReportUsuario;

    @Autowired
    private ServicioReportPublicacion servicioReportPublicacion;
    

    // VISTA INDEX
    @GetMapping("/")
    public String index(ModelMap modelo) {

        List<Publicacion> topDiez = servicioPublicacion.topDiez();
        modelo.addAttribute("publicaciones", topDiez);

        return "index.html";

    }

    @GetMapping("/filtro/{filtro}/{categoria}")
    public String index(@PathVariable Integer filtro, @PathVariable Categorias categoria, ModelMap modelo, HttpSession session){

        List<Publicacion> publicaciones = servicioPublicacion.publicacionesPorFiltro(filtro, categoria);
        modelo.addAttribute("publicaciones", publicaciones);
        
        if(session.getAttribute("usuariosession")!=null){
            List<Usuario> topUsuarios = new ArrayList();
            for (Publicacion publicacion : publicaciones) {
                if(!topUsuarios.contains(publicacion.getUser())){
                    topUsuarios.add(publicacion.getUser());
                }
            }
            modelo.addAttribute("topUsuarios", topUsuarios);
            return "main.html";
        }
        return "index.html";
    }

    // VISTA DE REGISTRAR
    @GetMapping("/registrar")
    public String registrar(ModelMap modelo) {
        // ---------------- PROBAR ------------------
        //modelo.addAttribute("imagenPred", repoImagen.imagenPredeterminada());
        return "guest.html";
    }

    // FORMULARIO DE REGISTRO DE USUARIO
    @PostMapping("/registro")
    public String registro(@RequestParam(name = "name") String name,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "birthDate") String birthDate,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "password2") String password2,
            MultipartFile image, ModelMap modelo) {

        try {
            servicioUsuario.register(name, email, DateConverter(birthDate), password, password2, image);

            modelo.put("exito", "Usuario registrado correctamente!");
            
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            modelo.put("email", email);
            
        }
        
        return "guest.html";

    }

    // VISTA DE LOGIN
    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if (error != null) {
            System.out.println(error);
            modelo.put("error", "Usuario o Clave incorrectos!");
        }
        return "guest.html";
    }

    @GetMapping("/check")
    public String checkAlta(HttpSession session, ModelMap model) throws MiException{
        
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");

        if(!usuario.getAlta()){
            Date hoy = new Date();
            
            long tiempoTrascurrido = hoy.getTime() - repoBaneo.banByUser(usuario.getId()).getInicioBan().getTime();
            TimeUnit unidad = TimeUnit.DAYS;

            long dias = unidad.convert(tiempoTrascurrido, TimeUnit.MILLISECONDS);
            if((14-dias) <= 0){
                model.put("error", "Deberías poder ingresar, en breves momentos entrará un admin para desbanearte");
            }else{
                model.put("error", "Estas baneado, no puedes ingresar hasta dentro de " + (14-dias) + "dias");
            }
            return "guest.html";
        }

        return "redirect:/main";
    }
    
    //VISTA MAIN 
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/main")
    public String inicio(HttpSession session, ModelMap modelo) {

        List<Publicacion> publicaciones = servicioPublicacion.listaPublicacion();
        List<Publicacion> topPublicaciones = repoPublicacion.listaTop();
        modelo.addAttribute("publicaciones", publicaciones);
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        modelo.addAttribute("usuario", servicioUsuario.getOne(logueado.getId()));
        List<Usuario> topUsuarios = new ArrayList();
        for (Publicacion publicacion : topPublicaciones) {
            if(!topUsuarios.contains(publicacion.getUser())){
                topUsuarios.add(publicacion.getUser());
            }
        }
        modelo.addAttribute("topUsuarios", topUsuarios);

        return "main.html";
    }

    private Date DateConverter(String fecha) {

        Date birthDate = new Date();

        birthDate.setDate(Integer.valueOf(fecha.substring(8, 10)));
        birthDate.setMonth(Integer.valueOf(fecha.substring(5, 7)) - 1);
        birthDate.setYear(Integer.valueOf(fecha.substring(0, 4))-1900);

        return birthDate;

    }

    //VISTA LISTA DE USUARIOS
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/listado")
    public String listado(ModelMap modelo, HttpSession session) {

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
    
    //VISTA PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/perfil/{id}")
    public String perfil(@PathVariable String id, ModelMap modelo) {
        List<Categorias> categorias = new ArrayList<>();
        for(Categorias categoria : Categorias.values()){
            categorias.add(categoria);
        }
        Usuario usuario = servicioUsuario.getOne(id);
        List<Publicacion> publicaciones = repoPublicacion.publicacionesByUser(id);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("publicaciones", publicaciones);
        modelo.addAttribute("categorias", categorias);

        return "perfil.html";

    }

    //VISTA ACTUALIZAR PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_DISIGNER')")
    @GetMapping("/perfil/modificar/{id}")
    public String modificarPerfil(@PathVariable String id, ModelMap modelo) {

        Usuario usuario = servicioUsuario.getOne(id);
        modelo.addAttribute("usuario", usuario);

        return "editar-perfil.html";

    }

    //FORM ACTUALIZAR PERFIL
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/perfil/modificado/{id}")
    public String perfilModificado(@PathVariable String id,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "password2") String password2,
            MultipartFile image, ModelMap modelo) {
        try {

            servicioUsuario.update(id, name, password, password2, image);

            List<Categorias> categorias = new ArrayList<>();
            for(Categorias categoria : Categorias.values()){
                categorias.add(categoria);
            }
            Usuario usuario = servicioUsuario.getOne(id);
            List<Publicacion> publicaciones = repoPublicacion.publicacionesByUser(id);
            modelo.addAttribute("usuario", usuario);
            modelo.addAttribute("publicaciones", publicaciones);
            modelo.addAttribute("categorias", categorias);

            modelo.put("exito", "Usuario modificado correctamente!");

            return "redirect:/perfil/".concat(id);

        } catch (MiException ex) {

            Usuario usuario = servicioUsuario.getOne(id);
            modelo.addAttribute("usuario", usuario);
            modelo.put("error", ex.getMessage());
            modelo.put("name", name);
            
            return "editar-perfil.html";
        }

        
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable String id, ModelMap modelo, HttpSession session) throws MiException{
        
        servicioUsuario.delete(id);

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

    @GetMapping("/ban/{id}")
    public String BanUsuario(@PathVariable String id, ModelMap modelo, HttpSession session) throws MiException{
        
        boolean alta = servicioUsuario.getOne(id).getAlta();
        
        servicioUsuario.banearUsuario(id);
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
