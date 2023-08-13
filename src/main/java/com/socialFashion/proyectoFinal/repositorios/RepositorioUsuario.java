package com.socialFashion.proyectoFinal.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Usuario;

/**
 * repositorioUsuario
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String>{
    
} 
