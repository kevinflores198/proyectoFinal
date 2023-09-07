package com.socialFashion.proyectoFinal.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsComentario;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsPublicacion;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReportePublicacion;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioPublicacion;

@Service
public class ServicioReportPublicacion {
    
    @Autowired
    private RepositorioReportePublicacion repoReportPubli;

    @Autowired
    private RepositorioPublicacion repoPubli;

    @Transactional
    public void crearReportePublicacion(String idPublicacion, String idUser, String reason, String typeReport) throws MiException{

        validar(idPublicacion, idUser, reason, typeReport);

        ReportPublicacion reporte = new ReportPublicacion();

        reporte.setIdUser(idUser);

        Optional<Publicacion> respuesta = repoPubli.findById(idPublicacion);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            reporte.setPublicacion(publicacion);
        }else{
            throw new MiException("No se encontró la publicacion");
        }

        reporte.setReason(reason.toLowerCase());

        try {
            ReportsPublicacion reportType = ReportsPublicacion.valueOf(typeReport.toUpperCase());
            if (reportType == ReportsPublicacion.OTRO) {
                if (reporte.getReason().isEmpty()) {
                    throw new MiException("La razon no puede estar vacia si el tipo de reporte es OTRO");
                }
            }
            reporte.setTypeReport(reportType);
            
        } catch (MiException ex) {
            throw new MiException("El tipo de reporte no es valido");
        }
        repoReportPubli.save(reporte);
    }

    public void eliminarReporte(String idReportPublicacion){

        ReportPublicacion reportPublicacion = repoReportPubli.getById(idReportPublicacion);
        repoReportPubli.delete(reportPublicacion);

    }

    public List<ReportPublicacion> listarReportesPulicacion(){
        List<ReportPublicacion> reports = new ArrayList<>();
        reports = repoReportPubli.findAll();
        return reports;
    }

    public ReportPublicacion getOne(String idReportPublicacion){
        return repoReportPubli.ReportPubliByID(idReportPublicacion);
    }

    private void validar(String idPublicacion, String idUser, String reason, String report) throws MiException{

        if(idPublicacion == null || idPublicacion.isEmpty()){
            throw new MiException("El id de la publicacion no puede estar vacio");
        }if(idUser == null || idUser.isEmpty()){
            throw new MiException("El id del usuario no puede estar vacio");
        }if(reason == null){
            throw new MiException("La razon del reporte no puede ser nula");
        }if(report == null || report.isEmpty()){
            throw new MiException("El tipo de reporte no puede estar vacio");
        }

    }
}
