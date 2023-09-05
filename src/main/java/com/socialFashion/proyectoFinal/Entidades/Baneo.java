package com.socialFashion.proyectoFinal.Entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Baneo {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.DATE)
    private Date inicioBan;

    @OneToOne
    private Usuario user;

    public Baneo() {
    }

    public Baneo(Date inicioBan, Usuario user) {
        this.inicioBan = inicioBan;
        this.user = user;
    }

    public Date getInicioBan() {
        return inicioBan;
    }

    public void setInicioBan(Date inicioBan) {
        this.inicioBan = inicioBan;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
