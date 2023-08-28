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
    
    @Query("SELECT p FROM Publicacion p ORDER BY p.likes DESC")
    public List<Publicacion> listaTopDiez();
    
    //HACER QUERY DE POR FECHA ASC, DESC
    //HACER QUERY POR CATEGORIA
    //HACER QUERY POR NOMBRE DE DISEÑADOR ASC, DESC
}
