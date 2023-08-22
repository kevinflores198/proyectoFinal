package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej9Guia6 {

    static Scanner read = new Scanner(System.in);

    /*Escriba un programa que pida una frase o 
        palabra y valide si la primera letra de esa frase
        es una ‘A’. Si la primera letra es una ‘A’, 
        se deberá de imprimir un mensaje por pantalla que
        diga “CORRECTO”, en caso contrario, se deberá 
        imprimir “INCORRECTO”. Nota: investigar
        la función Substring y equals() de Java.*/
    public static void main(String[] args) {

        String frase;

        System.out.println("Ingrese una frase");

        frase = read.nextLine().substring(0, 1).toUpperCase();

        if ("A".equals(frase)) {

            System.out.println("CORRECTO, la frase comienza con la letra A");
        } else {
            System.out.println("INCORRECTO, la frase no comienza con la letra pensada");

        }
    }
}
