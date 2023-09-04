package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;

import com.socialFashion.proyectoFinal.Enumeraciones.Categorias;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.List;

/**
 * Publicacion
 */
@Entity
public class Publicacion {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @ManyToOne
    private Usuario user;

    @Enumerated(EnumType.STRING)
    private Categorias label;

    @OneToOne
    private Imagen image;
    
    private String content;

    @Temporal(TemporalType.DATE)
    private Date initialDate;

    private Integer comentarios;

    @OneToMany
    @ElementCollection
    private List<Usuario> usuarioLikes;

    private Integer likes;

    public Publicacion() {
        this.comentarios = 0;
        this.likes = 0;
    }
    
    public Publicacion(Usuario user, Categorias label, Imagen image, String content, Date initialDate,
            Integer comentarios, List<Usuario> usuarioLikes, Integer likes) {
        this.user = user;
        this.label = label;
        this.image = image;
        this.content = content;
        this.initialDate = initialDate;
        this.comentarios = comentarios;
        this.usuarioLikes = usuarioLikes;
        this.likes = likes;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Categorias getLabel() {
        return label;
    }

    public void setLabel(Categorias label) {
        this.label = label;
    }

    public Imagen getImage() {
        return image;
    }

    public void setImage(Imagen image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Integer getComentarios() {
        return comentarios;
    }

    public void setComentarios(Integer comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Usuario> getUsuarioLikes() {
        return usuarioLikes;
    }

    public void setUsuarioLikes(List<Usuario> usuarioLikes) {
        this.usuarioLikes = usuarioLikes;
    }

    
}