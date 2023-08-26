package com.socialFashion.proyectoFinal.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialFashion.proyectoFinal.Servicios.ServicioUsuario;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
   
    @Autowired
    private ServicioUsuario servicioUsuario;
    
   //@GetMapping("/dashboard"){} NO HACE FALTA PORQ NO HAY VISTAS DIFERENTES DE MAIN 

   //VISTA DE ALL REPORTS

   
   
   

   
}