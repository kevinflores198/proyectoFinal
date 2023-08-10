package com.socialFashion.proyectoFinal.Entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;

@Entity
public class ReportUser {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String idUser;
    private String idUserReported;

    @Enumerated(EnumType.STRING)
    private ReportsUser typeReport;

    private String reason;
    private boolean alta;
    
    public ReportUser() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    public String getIdUserReported() {
        return idUserReported;
    }
    public void setIdUserReported(String idUserReported) {
        this.idUserReported = idUserReported;
    }
    public ReportsUser getTypeReport() {
        return typeReport;
    }
    public void setTypeReport(ReportsUser typeReport) {
        this.typeReport = typeReport;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public boolean isAlta() {
        return alta;
    }
    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    
}
