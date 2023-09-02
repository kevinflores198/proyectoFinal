package com.socialFashion.proyectoFinal.Repositorios;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;

/**
 * repositorioPublicacion
 */
@Repository
public interface RepositorioPublicacion extends JpaRepository<Publicacion,String> {
    
    @Query("SELECT p FROM Publicacion p WHERE p.id = :id")
    public Publicacion publicacionById(@Param("id") String id);

    @Query("SELECT p FROM Publicacion p WHERE p.user.id = :idUsuario")
    public List<Publicacion> publicacionesByUser(@Param("idUsuario") String idUsuario);

    @Query("SELECT p FROM Publicacion p ORDER BY p.likes DESC")
    public List<Publicacion> listaTop();
    
    @Query("SELECT p FROM Publicacion p ORDER BY p.initialDate DESC")
    public List<Publicacion> publicacionesByDateDesc();

    @Query("SELECT p FROM Publicacion p ORDER BY p.initialDate ASC")
    public List<Publicacion> publicacionesByDateAsc();
    
    @Query("SELECT p FROM Publicacion p WHERE p.label LIKE :categoria")
    public List<Publicacion> publicacionesByLabel(@Param("categoria") Categorias categoria);
    
    @Query("SELECT p FROM Publicacion p ORDER BY p.user.name DESC")
    public List<Publicacion> findAllOrderByNombreDiseñadorDesc();

    @Query("SELECT p FROM Publicacion p ORDER BY p.user.name ASC")
    public List<Publicacion> findAllOrderByNombreDiseñadorAsc();
    
}
