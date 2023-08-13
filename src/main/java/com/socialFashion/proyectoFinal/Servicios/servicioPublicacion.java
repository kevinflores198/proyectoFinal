package com.socialFashion.proyectoFinal.Servicios;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.socialFashion.proyectoFinal.Entidades.Imagen;
import com.socialFashion.proyectoFinal.Entidades.Publicacion;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Exceptions.MiException;
import com.socialFashion.proyectoFinal.repositorios.RepositorioUsuario;
import com.socialFashion.proyectoFinal.repositorios.repositorioPublicacion;

public class servicioPublicacion {
    @Autowired
    private servicioImagen sImg;

    @Autowired
    private RepositorioUsuario repoUser;

    @Autowired
    private repositorioPublicacion repoPubli;

    @Transactional
    public void crearPublicacion(String idUser, String label, MultipartFile archivo, String content)
            throws MiException {

        validacion(idUser, label, archivo, content);

        Publicacion publicacion = new Publicacion();

        Optional<Usuario> usuarioRespuesta = repoUser.findById(idUser);

        if (usuarioRespuesta.isPresent()) {
            Usuario usuario = new Usuario();
            usuario = usuarioRespuesta.get();

            publicacion.setUser(usuario); // agregar id de usuarios desde repo usuario

            publicacion.setLabel(label);

            Imagen image = new Imagen();
            image = sImg.guardar(archivo);
            publicacion.setImage(image);

            publicacion.setContent(content);
            publicacion.setLikes(0);
            publicacion.setAlta(true);
            publicacion.setInitialDate(new Date());

            repoPubli.save(publicacion);
        }else{
            throw new MiException("No se encontró el usuario");
        }

    }

    @Transactional
    public void eliminar(String idPublicacion) throws MiException {

        Publicacion publicacion = repoPubli.getById(idPublicacion);

        repoPubli.delete(publicacion);

    }

    @Transactional
    public void modificarPublicacion(String label, String idPublicacion, String content) throws MiException {
        if (label == null || label.isEmpty()) {
            throw new MiException("la categoria no puede estar vacia");
        }
        if (content == null) {
            throw new MiException("la descripcion no puede ser nula");
        }

        Optional<Publicacion> rsp = repoPubli.findById(idPublicacion);
        if (rsp.isPresent()) {
            Publicacion publicacion = rsp.get();
            publicacion.setLabel(label);
            publicacion.setContent(content);
        }

    }

    public void validacion(String idUser, String label, MultipartFile archivo, String content) throws MiException {
        if (idUser.isEmpty() || idUser == null) {
            throw new MiException("el id del usuario no puede estar vacio");
        }
        if (label == null || label.isEmpty()) {
            throw new MiException("la categoria no puede estar vacia");
        }
        if (archivo == null || archivo.isEmpty()) {
            throw new MiException("la publicacion tiene que contener una imagen");
        }
        if (content == null) {
            throw new MiException("la descripcion no puede ser nula");
        }
    }

}
