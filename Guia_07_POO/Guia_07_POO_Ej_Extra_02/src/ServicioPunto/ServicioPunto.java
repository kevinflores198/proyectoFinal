package ServicioPunto;

import Puntos.Puntos;
import java.util.Scanner;

public class ServicioPunto {

    Puntos p = new Puntos();
    Scanner leer = new Scanner(System.in);

    public void crearPuntos(Puntos p) {
        double punto1, punto2, x1, x2, y1, y2;

        punto1 = p.getP1();
        punto2 = p.getP2();
        x1 = p.getX1();
        x2 = p.getX2();
        y1 = p.getY1();
        y2 = p.getY2();

        System.out.println("Ingrese por favor la x del punto 1: ");
        p.setX1(leer.nextInt());
        System.out.println("Ingrese por favor el y del punto 1: ");
        p.setY1(leer.nextInt());
        System.out.println("[" + p.getX1() + "," + p.getY1() + "]");
        System.out.println("Ingrese por favor el x del punto 2: ");
        p.setX2(leer.nextInt());
        System.out.println("Ingrese por favor el y del punto 2: ");
        p.setY2(leer.nextInt());
        System.out.println("[" + p.getX2() + "," + p.getY2() + "]");

    }

    public double CalculoDistancia(Puntos p) {

        double distancia;
        distancia = Math.sqrt((Math.pow(p.getX2() - p.getX1(), 2) + Math.pow((p.getY2() - p.getY1()), 2)));

        System.out.println("La distancia entre cada punto es de: ");
        System.out.println(distancia);

        return distancia;
    }
}
