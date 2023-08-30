package com.socialFashion.proyectoFinal.Servicios;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Imagen;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioImagen;

@Service
public class ServicioImagen {
    @Autowired
    private RepositorioImagen repoImagen;

     public Imagen guardar(MultipartFile archivo) throws MiException{
        if (archivo != null) {
            try {

                Imagen imagen = new Imagen();

                imagen.setMime(archivo.getContentType());

                imagen.setNombre(archivo.getName());

                imagen.setContenido(archivo.getBytes());

                return repoImagen.save(imagen);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
