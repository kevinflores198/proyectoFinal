package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej3Guia6 {

    static Scanner leer = new Scanner(System.in);

    /*Escribir un programa que pida una frase y 
    la muestre toda en mayúsculas y después toda
    en minúsculas. Nota: investigar la función 
    toUpperCase() y toLowerCase() en Java. */
    public static void main(String[] args) {

        String frase;

        System.out.println("Ingrese una frase");

        frase = leer.nextLine();

        System.out.println("\nMAYUSCULAS: " + frase.toUpperCase());
        System.out.println("");
        System.out.println("MINUSCULAS: " + frase.toLowerCase());

    }
}
