package com.egg.noticia.controladores;

import com.egg.noticia.entidades.Noticia;
import com.egg.noticia.servicios.servicioNoticia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    servicioNoticia noticiaServicio;

    @GetMapping("/")
    public String index(ModelMap modelo) {

        try {
            List<Noticia> noticias = noticiaServicio.listarNoticias();

            modelo.addAttribute("noticias", noticias);

        } catch (Exception e) {

            modelo.put("error", e.getMessage());
        }

        return "index.html";
    }

}
