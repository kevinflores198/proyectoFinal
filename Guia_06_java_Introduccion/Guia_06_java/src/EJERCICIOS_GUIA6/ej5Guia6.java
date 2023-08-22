package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej5Guia6 {

    static Scanner leer = new Scanner(System.in);
    
        /*Escribir un programa que lea un número entero
    por teclado y muestre por pantalla el doble, el
    triple y la raíz cuadrada de ese número. 
    Nota: investigar la función Math.sqrt().*/

    public static void main(String[] args) {

        int num1, doble, triple;

        double raiz;

        System.out.println("Ingrese un numero entero");

        num1 = leer.nextInt();

        doble = (num1 * 2);
        triple = (num1 * 3);
        raiz = Math.sqrt(num1);

        System.out.println("el doble de ese numero es : " + doble);
        System.out.println("el triple de ese numero es : " + triple);
        System.out.println("la raiz cuadrada de ese numero es : " + raiz);
    }
}
