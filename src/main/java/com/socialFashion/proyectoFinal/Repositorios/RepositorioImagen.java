package com.socialFashion.proyectoFinal.Repositorios;

import com.socialFashion.proyectoFinal.Entidades.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

/**
 * repositorioImangen
 */
@Repository
public interface RepositorioImagen extends JpaRepository<Imagen, String>{

    @Query("SELECT i FROM Imagen i WHERE i.id = '77e668fd-c794-4cfd-803f-9cae281957e8'")
    public MultipartFile imagenPredeterminada();
    
}
