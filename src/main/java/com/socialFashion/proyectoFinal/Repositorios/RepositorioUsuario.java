package com.socialFashion.proyectoFinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * repositorioUsuario
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String>{
    
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    public Usuario BuscarUsuarioPorID(@Param("id")String id);
    
} 
