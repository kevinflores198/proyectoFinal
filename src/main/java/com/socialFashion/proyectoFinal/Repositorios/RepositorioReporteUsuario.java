
package com.socialFashion.proyectoFinal.Repositorios;

import com.socialFashion.proyectoFinal.Entidades.ReportUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReporteUsuario extends JpaRepository<ReportUser, String> {
    
    @Query("SELECT r FROM ReporteUsuario r WHERE r.idReporte = :idReporte")
    public ReportUser ReportUsuarioByID(@Param("idReporte") String idReporte);
    //NO DEBERIA RETORNAR UNA LISTA? PUEDE TENER VARIOS REPORTES
    
    
}
