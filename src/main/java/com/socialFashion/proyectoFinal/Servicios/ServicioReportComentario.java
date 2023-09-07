package com.socialFashion.proyectoFinal.Servicios;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsComentario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteComentario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioComentario;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioReportComentario {

    @Autowired
    RepositorioReporteComentario repoReporteComentario;

    @Autowired
    RepositorioComentario repoComent;

    @Transactional
    public void crearReporte(String idComent, String idUser,
            String reason, String typeReport) throws MiException {

        if (idComent.isEmpty()) {
            throw new MiException("El Numero de ID del comentario no puede ser nulo");
        }
        if (idUser.isEmpty() || idUser == null) {
            throw new MiException("El ID de usuario no puede ser nulo");
        }
        if (reason.isEmpty() || reason == null) {
            throw new MiException("La razon no puede estar vacia");
        }

        ReportComentario reporte = new ReportComentario();

        reporte.setIdUser(idUser);

        Optional<Comentario> rsp = repoComent.findById(idComent);
        if (rsp.isPresent()) {
            Comentario coment = rsp.get();
            reporte.setComentario(coment);
        } else {
            throw new MiException("No se encontro el comentario");
        }

        reporte.setReason(reason);

        try {
            ReportsComentario reportType = ReportsComentario.valueOf(typeReport.toUpperCase());
            if (reportType == ReportsComentario.OTRO) {
                if (reporte.getReason().isEmpty()) {
                    throw new MiException("La razon no puede estar vacia si el tipo de reporte es OTRO");
                }
            }
            reporte.setTypeReport(reportType);
        } catch (Exception e) {
            throw new MiException("El tipo de reporte no es valido");
        }

        repoReporteComentario.save(reporte);

    }

    @Transactional
    public void eliminarReporte(String idReport) {
        repoReporteComentario.deleteById(idReport);
    }

    @Transactional
    public List<ReportComentario> listarReportes() {
        List<ReportComentario> reportes = new ArrayList<>();
        reportes = repoReporteComentario.findAll();
        return reportes;
    }

    @Transactional
    public ReportComentario buscarReporte(String idReport) throws MiException {

        if (idReport == null || idReport.isEmpty()) {
            throw new MiException("El ID del reporte no puede ser nulo");
        }
        return repoReporteComentario.ReportComentariobyID(idReport);
    }

}
