package com.socialFashion.proyectoFinal.Repositorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;

/**
 * repositorioPublicacion
 */
@Repository
public interface repositorioPublicacion extends JpaRepository<Publicacion,String> {
    
    @Query("SELECT p FROM Publicacion p WHERE p.alta = :alta")
    public List<Publicacion> publicaciones(@Param("alta")Boolean alta);
    
}
