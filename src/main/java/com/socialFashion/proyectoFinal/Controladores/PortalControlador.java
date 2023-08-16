package com.socialFashion.proyectoFinal.Controladores;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private ServicioUsuario servicioUsuario;


    //VISTA INDEX
    @GetMapping("/")
    public String index() {
        
        return "index.html";

    }

    //VISTA DE REGISTRAR
    @GetMapping("/registrar")
    public String registrar() {

        return "login.html";
    }

    //FORMULARIO DE REGISTRO DE USUARIO
    @PostMapping("/registro")
    public String registro(@RequestParam String name, @RequestParam String email, @RequestParam Date birthDate,@RequestParam String password, @RequestParam
            String password2, ModelMap modelo, MultipartFile image) {

        try {
            servicioUsuario.register(name, email, birthDate, password, password2, password2, image);

            modelo.put("exito", "Usuario registrado correctamente!");

            return "index.html";
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", name);
            modelo.put("email", email);

            return "login.html";
        }

    }








}
