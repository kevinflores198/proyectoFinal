package com.socialFashion.proyectoFinal.Servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;
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
    public void crearReportePublicacion(String idPublicacion, String idUser, String reason, String reports) throws MiException{

        validar(idPublicacion, idUser, reason, reports);

        ReportPublicacion reportPubli = new ReportPublicacion();

        reportPubli.setIdUser(idUser);

        Optional<Publicacion> respuesta = repoPubli.findById(idPublicacion);
        if(respuesta.isPresent()){
            Publicacion publicacion = respuesta.get();
            reportPubli.setPublicacion(publicacion);
        }else{
            throw new MiException("No se encontró la publicacion");
        }

        reportPubli.setReason(reason.toLowerCase());

        switch (reports) {
            case "disgusto":
                reportPubli.setTypeReport(ReportsPublicacion.DISGUSTO);
                break;
            case "spam":
                reportPubli.setTypeReport(ReportsPublicacion.SPAM);
                break;
            case "sexual":
                reportPubli.setTypeReport(ReportsPublicacion.SEXUAL);
                break;
            case "inapropiado":
                reportPubli.setTypeReport(ReportsPublicacion.INAPROPIADO);
                break;
            case "violencia":
                reportPubli.setTypeReport(ReportsPublicacion.VIOLENCIA);
                break;
            case "desinformacion":
                reportPubli.setTypeReport(ReportsPublicacion.DESINFORMACION);
                break;
            case "estafa":
                reportPubli.setTypeReport(ReportsPublicacion.ESTAFA);
                break;
            case "bullyng":
                reportPubli.setTypeReport(ReportsPublicacion.BULLYNG);
                break;
            case "autolesion":
                reportPubli.setTypeReport(ReportsPublicacion.AUTOLESION);
                break;
            case "ilegal":
                reportPubli.setTypeReport(ReportsPublicacion.ILEGAL);
                break;
            case "etnia":
                reportPubli.setTypeReport(ReportsPublicacion.ETNIA);
                break;
            case "otro":
                if(reason.isEmpty()){
                    throw new MiException("Es necesario que se especifique una razon");
                }
                reportPubli.setTypeReport(ReportsPublicacion.OTRO);
                break;
        }
        repoReportPubli.save(reportPubli);
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
