package com.socialFashion.proyectoFinal.Entidades;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.socialFashion.proyectoFinal.Enumeraciones.ReportsComentario;

/**
 * ReportComentario
 */
@Entity
public class ReportComentario {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idReport;
    
    private String idUser;

    @ManyToOne
    private Comentario comentario;

    private String Reason; 
    //private Boolean alta;

    @Enumerated(EnumType.STRING)
    private ReportsComentario typeReport;

    public ReportComentario(String idUser, Comentario comentario, String reason,
            ReportsComentario typeReport) {
        this.idUser = idUser;
        this.comentario = comentario;
        Reason = reason;
        this.typeReport = typeReport;
    }

    //Getter y Setter

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public ReportsComentario getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsComentario typeReport) {
        this.typeReport = typeReport;
    }
    
}
