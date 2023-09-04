package com.socialFashion.proyectoFinal.Servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialFashion.proyectoFinal.Entidades.Baneo;
import com.socialFashion.proyectoFinal.Entidades.Usuario;
import com.socialFashion.proyectoFinal.Repositorios.RepositorioBaneo;

@Service
public class ServicioBaneo {
    
    @Autowired
    private RepositorioBaneo repoBan;

    public void cargarBan(Usuario usuario){
        Baneo ban = new Baneo();

        ban.setInicioBan(new Date());
        ban.setUser(usuario);

        repoBan.save(ban);
    }

    public void eliminarBan(String id){
        repoBan.delete(repoBan.banByUser(id));
    }

}
