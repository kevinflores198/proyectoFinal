
package ej4guia7;

import Rectangulo.Rectangulo;
import Servicio.Servicio;

public class Ej4Guia7 {

    public static void main(String[] args) {

        Rectangulo r = new Rectangulo();
        Servicio s = new Servicio();

        s.datosRectangulo(r);
        s.baseAltura(r);
        s.dibujarRectangulo(r);
    }
}
