package com.egg.noticia.controladores;

import com.egg.noticia.entidades.Noticia;
import com.egg.noticia.excepciones.MiException;
import com.egg.noticia.servicios.servicioNoticia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/noticia")
public class controladorNoticia {

    @Autowired
    servicioNoticia noticiaServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "noticia_form.html";
    }

    @PostMapping("/registro")
    public String registro(
        @RequestParam String titulo, 
        String cuerpo, 
        ModelMap modelo) {

        try {
            noticiaServicio.crearNoticia(titulo, cuerpo);
            modelo.put("Exito", "La noticia se creo correctamente");
        } catch (MiException e) {
            modelo.put("Error", e.getMessage());
            return "noticia_form.html";
        }
        return "redirect:../listar";
    }

    @GetMapping("/listar")
    public String listar(ModelMap modelo) {

        try {
            List<Noticia> noticias = noticiaServicio.listarNoticias();

            modelo.addAttribute("noticias", noticias);

        } catch (Exception e) {

            modelo.put("error", e.getMessage());
        }
        return "noticia_listar.html";

    }

    @GetMapping("/modificar/{id}")
    public String modificar(
        @PathVariable String id, 
        ModelMap modelo) {

        modelo.put("noticia", noticiaServicio.getOne(id));

        return "noticia_modificar.html";

    }

    @PostMapping("/modificar/{id}")
    public String modificar(
        @PathVariable String id, 
        String titulo, 
        String cuerpo, 
        ModelMap modelo) {

        try {
            noticiaServicio.modificar(id, titulo, cuerpo);

            return "redirect:../listar";

        } catch (MiException e) {

            modelo.put("error", e.getMessage());

            return "noticia_modificar.html";
        }

    }

    @GetMapping("/eliminar/{id}")
    public String eliminada(@PathVariable String id, ModelMap modelo) {

        try {
            noticiaServicio.eliminarNoticia(id);

            List<Noticia> noticias = noticiaServicio.listarNoticias();
            
            modelo.put("exito", "La noticia ha sido eliminada correctamente");

            return "redirect:../listar";

        } catch (Exception e) {

            modelo.put("error", e.getMessage());

            return "noticia_listar.html";
        }
    }
}
