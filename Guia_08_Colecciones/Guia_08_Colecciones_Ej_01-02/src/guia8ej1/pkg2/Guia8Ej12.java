package guia8ej1.pkg2;

import guia8ej1.pkg2.Raza.Raza;
import guia8ej1.pkg2.Servicio.ServicioRaza;

public class Guia8Ej12 {

    public static void main(String[] args) {

        ServicioRaza sr = new ServicioRaza();
        Raza r = new Raza();

        sr.razas();
        sr.mostrar();
        sr.buscarYEliminar();

    }

}
