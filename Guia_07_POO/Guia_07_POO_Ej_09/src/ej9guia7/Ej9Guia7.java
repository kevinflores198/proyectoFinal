package ej9guia7;

import Matematica.Matematica;
import Servicios.Servicios;

public class Ej9Guia7 {

    public static void main(String[] args) {

        Matematica m = new Matematica();
        Servicios s = new Servicios();

        m.setNum1((float) Math.random() * 10);

        m.setNum2((float) Math.random() * 10);
        System.out.println(m);
        System.out.println("");
        System.out.println("El numero mayor es: " + s.devolverMayor(m));
        System.out.println("\nEl numero mayor elevado al menor es: " + s.calcularPotencia(m));
        System.out.println("");
        System.out.println("Ahora se mostrara la raiz del menor numero");
        System.out.println(s.calcularRaiz(m));
    }
}
