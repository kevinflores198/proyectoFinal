package com.socialFashion.proyectoFinal.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportPublicacion;

/**
 * RepositorioReportPublicacion
 */
@Repository
public interface RepositorioReportePublicacion extends JpaRepository<ReportPublicacion,String>{
    
    @Query("SELECT rp FROM ReportPublicacion rp WHERE rp.idReport = :idReport")
    public ReportPublicacion ReportPubliByID(@Param("idReport") String idReport);

    @Query("SELECT r FROM ReportPublicacion r WHERE r.publicacion.id = :idPublicacion")
    public List<ReportPublicacion> reportPublicacionByIdPublicacion(@Param("idPublicacion")String idPublicacion);

}
