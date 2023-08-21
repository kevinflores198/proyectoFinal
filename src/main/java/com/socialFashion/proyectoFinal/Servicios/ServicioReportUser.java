package com.socialFashion.proyectoFinal.Servicios;

import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioReporteUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioReportUser {

    @Autowired
    RepositorioReporteUsuario repoUsuario;

    @Transactional
    public void crearReporte(Usuario idUser, String idUserReported,
            String reason, String typeReport) throws MiException {

        if (idUserReported.isEmpty() || idUserReported == null) {
            throw new MiException("El Numero de ID del usuario reportado no puede ser nulo");
        }
        if (idUser == null) {
            throw new MiException("El ID de usuario no puede ser nulo");
        }
        if (reason.isEmpty() || reason == null) {
            throw new MiException("La razon no puede estar vacia");
        }

        ReportUser reporte = new ReportUser();

        reporte.setUser(idUser);
        reporte.setIdUserReported(idUserReported);
        reporte.setReason(reason);

        try {
            ReportsUser reportType = ReportsUser.valueOf(typeReport.toUpperCase());
            reporte.setTypeReport(reportType);
        } catch (Exception e) {
            throw new MiException("El tipo de reporte no es valido");
        }

        repoUsuario.save(reporte);

    }

    @Transactional
    public void eliminarReporte(String idUserReported) {
        repoUsuario.deleteById(idUserReported);
    }

    @Transactional
    public List<ReportUser> listarReportes() {
        List<ReportUser> reportes = new ArrayList<>();
        reportes = repoUsuario.findAll();
        return reportes;
    }

    @Transactional
    public ReportUser buscarReporte(String idUserReported) throws MiException {

        if (idUserReported == null || idUserReported.isEmpty()) {
            throw new MiException("El ID del usuario reportado no puede ser nulo");
        }
        return repoUsuario.ReportUsuarioByID(idUserReported);
    }

}
