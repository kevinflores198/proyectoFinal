package Ej10Guia7.servicio;

import Ej10guia7.arreglos.Entidades;
import java.util.Arrays;
import java.util.Scanner;

public class Servicios {

    double x = 0.5;
    Entidades a = new Entidades();
    Scanner leer = new Scanner(System.in);

    public Entidades llenarAyB() {
        
        for (int i = 0; i < 50; i++) {
            a.getA()[i] = Math.random() * 10;
        }

        a.setA(a.getA());
        System.out.println("Arreglo A:");
        System.out.println(Arrays.toString(a.getA()));
        Arrays.sort(a.getA());

        a.setA(a.getA());
        System.out.println("Arreglo A ordenado:");
        System.out.println(Arrays.toString(a.getA()));

        System.out.println("Arreglo B: ");

        Arrays.fill(a.getB(), x);

        for (int i = 0; i < 20; i++) {
            a.getB()[i] = a.getA()[i];
        }
        System.out.println("/");

        a.setB(a.getB());
        System.out.println("Arreglos:");
        System.out.println(Arrays.toString(a.getA()));
        System.out.println(Arrays.toString(a.getB()));

        return a;
    }
}
