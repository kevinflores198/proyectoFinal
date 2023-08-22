package extrasej2guia7;

import Puntos.Puntos;
import ServicioPunto.ServicioPunto;

public class ExtrasEj2Guia7 {

    public static void main(String[] args) {

        Puntos p = new Puntos();
        ServicioPunto sp = new ServicioPunto();

        sp.crearPuntos(p);
        sp.CalculoDistancia(p);
    }
}
