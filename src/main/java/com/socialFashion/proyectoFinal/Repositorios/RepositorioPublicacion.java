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
public interface RepositorioPublicacion extends JpaRepository<Publicacion,String> {
    
    @Query("SELECT p FROM Publicacion p WHERE p.user.id = :idUsuario")
    public List<Publicacion> publicacionesByUser(@Param("idUsuario") String idUsuario);

    @Query("SELECT p FROM Publicacion p ORDER BY p.initialDate DESC")
    public List<Publicacion> publicacionesByDateDesc(@Param("initialDate") String initialDate);

    @Query("SELECT p FROM Publicacion p ORDER BY p.initialDate ASC")
    public List<Publicacion> publicacionesByDateAsc(@Param("initialDate") String initialDate);

    @Query("SELECT p FROM Publicacion p WHERE p.label LIKE :categoria")
    public List<Publicacion> publicacionesByLabel(@Param("categoria") Categorias categoria);
    
}
