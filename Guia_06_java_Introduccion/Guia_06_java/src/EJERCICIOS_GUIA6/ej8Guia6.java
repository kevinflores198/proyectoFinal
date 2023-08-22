package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej8Guia6 {

    static Scanner hola = new Scanner(System.in);

    /*Realizar un programa que solo permita introducir 
    solo frases o palabras de 8 de largo. Si el
    usuario ingresa una frase o palabra de 8 de largo 
    se deberá de imprimir un mensaje por
    pantalla que diga “CORRECTO”, en caso contrario, 
    se deberá imprimir “INCORRECTO”.
    Nota: investigar la función Length() en Java.*/
    public static void main(String[] args) {

        String frase;
        int largo;

        System.out.println("Ingrese una frase");

        frase = hola.nextLine();

        largo = frase.length();

        if (largo == 8) {
            System.out.println("CORRECTO, la frase tiene 8 digitos");
        } else if (largo > 8) {
            System.out.println("INCORRECTO, la frase tiene mas de 8 digitos");
        } else if (largo < 8) {
            System.out.println("INCORRECTO, la frase tiene menos de 8 digitos");
        }
    }
}
