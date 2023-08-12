package com.socialFashion.proyectoFinal.Entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 *Entidad Comentario
 */
@Entity
public class Comentario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idComent;
    
    private String idUser;
    private String idPublicacion;
    private String comments;
    private Boolean alta;
    private ReportComentario[] reports;
    
    public Comentario() {
    }

    public Comentario(String idComent, String idUser, String idPublicacion, String comments, Boolean alta,
            ReportComentario[] reports) {
        this.idComent = idComent;
        this.idUser = idUser;
        this.idPublicacion = idPublicacion;
        this.comments = comments;
        this.alta = alta;
        this.reports = reports;
    }

    public String getIdComent() {
        return idComent;
    }

    public void setIdComent(String idComent) {
        this.idComent = idComent;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public ReportComentario[] getReports() {
        return reports;
    }

    public void setReports(ReportComentario[] reports) {
        this.reports = reports;
    }

}