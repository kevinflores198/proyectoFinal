package com.socialFashion.proyectoFinal.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Usuario;

/**
 * repositorioUsuario
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String>{
    @Query("SELECT u FROM Usuario u Where u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);
} 
