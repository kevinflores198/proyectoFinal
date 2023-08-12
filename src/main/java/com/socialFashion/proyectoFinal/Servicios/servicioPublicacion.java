package com.socialFashion.proyectoFinal.Servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Comentario;
import com.socialFashion.proyectoFinal.Entidades.Imagen;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.repositorios.repositorioPublicacion;

public class servicioPublicacion {
    @Autowired
    private servicioImagen sImg;

    @Autowired
    private repositorioPublicacion repoPubli;

    @Transactional
    public void crearPublicacion(String idUser, String label, MultipartFile archivo, String content, ArrayList<Comentario> comments, Integer likes) throws MiException{
     validacion(idUser, label, archivo, content);
     Publicacion p = new Publicacion();
     p.setIdUser(idUser);//agregar id de usuarios desde repo usuario
     p.setLabel(label);
     Imagen image = new Imagen();
     image = sImg.guardar(archivo);
     p.setImage(image);
     p.setContent(content);
     //generar servicio de comentario generar comentario y report comentario
     p.setComments(null);
     p.setLikes(0);
     p.setAlta(true);
     p.setInitialDate(LocalDate.now());
     repoPubli.save(p);
    }

    
    @Transactional
    public void eliminar(String idPublicacion) throws MiException{
        
        Publicacion publicacion = repoPubli.getById(idPublicacion);
        
        repoPubli.delete(publicacion);

    }


    @Transactional
    public void modificarPublicacion(String label, String idPublicacion, String content) throws MiException{
        if(label == null || label.isEmpty()){
            throw new MiException("la categoria no puede estar vacia");
        }if(content == null){
            throw new MiException("la descripcion no puede ser nula");
        }

        Optional<Publicacion> rsp = repoPubli.findById(idPublicacion);
        if(rsp.isPresent()){
            Publicacion publicacion = rsp.get();
            publicacion.setLabel(label);
            publicacion.setContent(content);
        }
        
    }






    
    public void validacion(String idUser, String label, MultipartFile archivo, String content) throws MiException{
        if(idUser.isEmpty() || idUser == null){
            throw new MiException("el id del usuario no puede estar vacio");
        }if(label == null|| label.isEmpty()){
            throw new MiException("la categoria no puede estar vacia");
        }if(archivo == null || archivo.isEmpty()){
            throw new MiException("la publicacion tiene que contener una imagen");
        }if(content == null){
            throw new MiException("la descripcion no puede ser nula");
        }
    }



}
