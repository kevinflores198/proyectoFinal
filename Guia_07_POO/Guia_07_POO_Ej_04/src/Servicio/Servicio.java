package Servicio;

import Rectangulo.Rectangulo;
import java.util.Scanner;

public class Servicio {
    
    Rectangulo r = new Rectangulo();
    Scanner leer = new Scanner(System.in);

    public void datosRectangulo(Rectangulo r) {
        System.out.println("Ingrese la altura del rectangulo");
        r.setAltura(leer.nextInt());
        System.out.println("Ingrese la base del rectangulo");
        r.setBase(leer.nextInt());
    }

    public void baseAltura(Rectangulo r) {
        System.out.println("La superficie del triangulo es: " + r.getBase() * r.getAltura());
        System.out.println("La perimetro del triangulo es: " + (r.getBase() + r.getAltura()) * 2);
    }

    public void dibujarRectangulo(Rectangulo r) {

        for (int i = 0; i < r.getBase(); i++) {
            for (int j = 0; j < r.getAltura(); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
