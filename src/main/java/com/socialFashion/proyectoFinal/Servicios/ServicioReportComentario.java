
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
    RepositorioReporteComentario repoComentario;

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
            throw new MiException("No se encontro comentario");
        }

        reporte.setReason(reason);

        switch (typeReport.toLowerCase()) {
            case "spam":
                reporte.setTypeReport(ReportsComentario.SPAM);
                break;
            case "sexual":
                reporte.setTypeReport(ReportsComentario.SEXUAL);
                break;
            case "inapropiado":
                reporte.setTypeReport(ReportsComentario.INAPROPIADO);
                break;
            case "bullying":
                reporte.setTypeReport(ReportsComentario.BULLYNG);
                break;
            case "racismo":
                reporte.setTypeReport(ReportsComentario.RACISMO);
                break;
            case "violencia":
                reporte.setTypeReport(ReportsComentario.VIOLENCIA);
                break;
            case "otro":
                if (typeReport.isEmpty()) {
                    throw new MiException("Es necesario que se especifique una razon");
                }
                reporte.setTypeReport(ReportsComentario.OTRO);
                break;
        }

        repoComentario.save(reporte);

    }

    @Transactional
    public void eliminarReporte(String idReport) {
        repoComentario.deleteById(idReport);
    }

    @Transactional
    public List<ReportComentario> listarReportes() {
        List<ReportComentario> reportes = new ArrayList<>();
        reportes = repoComentario.findAll();
        return reportes;
    }

    @Transactional
    public ReportComentario buscarReporte(String idReport) throws MiException {

        if (idReport == null || idReport.isEmpty()) {
            throw new MiException("El ID del reporte no puede ser nulo");
        }
        return repoComentario.ReportComentariobyID(idReport);
    }

}
