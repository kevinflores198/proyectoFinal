package com.egg.noticia.servicios;

import com.egg.noticia.entidades.Noticia;
import com.egg.noticia.excepciones.MiException;
import com.egg.noticia.repositorios.NoticiaRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicioNoticia {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    @Transactional
    public void crearNoticia(
        String titulo, 
        String cuerpo) throws MiException {

        validar(titulo, cuerpo);

        Noticia noticia = new Noticia();

        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);

        noticiaRepositorio.save(noticia);
    }

    public List<Noticia> listarNoticias() {

        List<Noticia> noticias = new ArrayList();

        noticias = noticiaRepositorio.findAll();

        return noticias;
    }

    
    public void modificar(
        String id, 
        String titulo, 
        String cuerpo) throws MiException {

        validar(titulo, cuerpo);

        Optional<Noticia> respuesta = noticiaRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Noticia noticia = respuesta.get();

            noticia.setTitulo(titulo);
            noticia.setCuerpo(cuerpo);

            noticiaRepositorio.save(noticia);
            
        } else {
            throw new MiException("no se encontro la notica");
        }
    }

    public Noticia getOne(String id) {

        return noticiaRepositorio.getOne(id);

    }

    public void eliminarNoticia(String id) throws MiException {

        validarID(id);

        try {
            Noticia noticiaEncontrada = noticiaRepositorio.getOne(id);

            noticiaRepositorio.delete(noticiaEncontrada);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    private void validar(String titulo, String cuerpo) throws MiException {

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo no puede estar vacio o ser nulo");
        }
        if (cuerpo.isEmpty() || cuerpo == null) {
            throw new MiException("El cuerpo no puede estar vacio o ser nulo");
        }
    }
    
    private void validarID(String id) throws MiException {

        if (id.isEmpty() || id == null) {
            throw new MiException("El id no puede estar vacio o ser nulo");
        }
        
    }

}
