package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.time.LocalDate;

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

    private String label;
    private Imagen image;
    private String content;

    @Temporal(TemporalType.DATE)
    private LocalDate initialDate;

    //@OneToMany    
    //private ArrayList<Comentario> comments;

    private Integer likes;

    private Boolean alta;

    public Publicacion() {
    }

    public Publicacion(Usuario user, String label, Imagen image, String content, LocalDate initialDate,
            Integer likes, Boolean alta) {
        this.user = user;
        this.label = label;
        this.image = image;
        this.content = content;
        this.initialDate = initialDate;
        this.likes = likes;
        this.alta = alta;
    }

    //Getter y Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario usuario) {
        this.user = usuario;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    
}