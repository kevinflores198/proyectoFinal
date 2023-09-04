package com.socialFashion.proyectoFinal.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Enumeraciones.Role;

/**
 * repositorioUsuario
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, String>{
    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    public Usuario buscarPorEmail(@Param("email") String email);

    @Query("SELECT u FROM Usuario u WHERE u.role = :role")
    public Usuario usuarioPorRol(@Param("role") Role role);
    
    @Query("SELECT u FROM Usuario u WHERE u.id = :idUser")
    public Usuario usuarioById(@Param("idUser") String idUser);

    @Query("SELECT u FROM Usuario u WHERE u.alta = false")
    public List<Usuario> usuariosDeBaja();
} 
