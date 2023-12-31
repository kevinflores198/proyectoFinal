
package com.socialFashion.proyectoFinal.Repositorios;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReporteComentario extends JpaRepository<ReportComentario, String> {
    
    @Query("SELECT r FROM ReportComentario r WHERE r.idReport = :idReport")
    public ReportComentario ReportComentariobyID(@Param("idReport")String idReport);
    
    @Query("SELECT r FROM ReportComentario r WHERE r.comentario.idComent = :idComent")
    public List<ReportComentario> reportComentarioByIdComentario(@Param("idComent")String idComent);

}
