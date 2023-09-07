
package com.socialFashion.proyectoFinal.Entidades;

import com.socialFashion.proyectoFinal.Enumeraciones.ReportsUser;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ReportUser {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String idReporte;
    
    
    private String idUser;
    
    @ManyToOne
    private Usuario UserReported;
    
    private String reason;
    
    
    @Enumerated(EnumType.STRING)
    private ReportsUser typeReport;

    public ReportUser() {
    }

    public ReportUser(String idUser, Usuario UserReported, String reason, ReportsUser typeReport) {
        this.idUser = idUser;
        this.UserReported = UserReported;
        this.reason = reason;
        this.typeReport = typeReport;
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Usuario getUserReported() {
        return UserReported;
    }

    public void setUserReported(Usuario UserReported) {
        this.UserReported = UserReported;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReportsUser getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(ReportsUser typeReport) {
        this.typeReport = typeReport;
    }

           
}
