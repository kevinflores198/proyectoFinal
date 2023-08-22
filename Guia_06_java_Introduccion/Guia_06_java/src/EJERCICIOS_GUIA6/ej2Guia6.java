package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej2Guia6 {

    public static void main(String[] args) {

        /*
        Escribir un programa que pida tu nombre, 
        lo guarde en una variable 
        y lo muestre por pantalla.
         */
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese su nombre");

        String palabra = leer.next();

        System.out.println("Su nombre es : " + palabra);
    }
}
