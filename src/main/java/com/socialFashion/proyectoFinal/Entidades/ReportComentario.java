package com.socialFashion.proyectoFinal.Entidades;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private String idComentario;
    private String Reason; 
    private Boolean alta;

    @Enumerated(EnumType.STRING)
    private ReportsComentario typeReport;

    public ReportComentario(String idUser, String idComentario, String idReport, String reason, Boolean alta,
            ReportsComentario TypeReport) {
        this.idUser = idUser;
        this.idComentario = idComentario;
        this.idReport = idReport;
        Reason = reason;
        this.alta = alta;
        this.typeReport = TypeReport;
    }

    public ReportComentario() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }

    public String getIdReport() {
        return idReport;
    }

    public void setIdReport(String idReport) {
        this.idReport = idReport;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public ReportsComentario getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsComentario typeReport) {
        this.typeReport = typeReport;
    }

   
    
    
    
    
    
}
