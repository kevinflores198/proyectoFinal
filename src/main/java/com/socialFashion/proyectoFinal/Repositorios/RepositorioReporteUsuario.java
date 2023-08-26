
package com.socialFashion.proyectoFinal.Repositorios;

import com.socialFashion.proyectoFinal.Entidades.ReportComentario;
import com.socialFashion.proyectoFinal.Entidades.ReportUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReporteUsuario extends JpaRepository<ReportUser, String> {
    

    @Query("SELECT r FROM ReportUser r WHERE r.idReporte = :idReporte")
    public ReportUser ReportUsuarioByID(@Param("idReporte") String idReporte);
    
    @Query("SELECT r FROM ReportUser r WHERE r.user.id = :idUser")
    public List<ReportUser> reportUsuarioByIdUser(@Param("idUser")String idUser);
    
}
