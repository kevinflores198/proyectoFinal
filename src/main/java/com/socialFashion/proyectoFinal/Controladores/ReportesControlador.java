
package com.socialFashion.proyectoFinal.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.socialFashion.proyectoFinal.Servicios.ServicioReportUser;

@Controller
@RequestMapping("/reporte")
public class ReportesControlador {
    
    @Autowired
    private ServicioReportUser servicioReportUsuario;
    
    servicioReportUsuario
    
}
