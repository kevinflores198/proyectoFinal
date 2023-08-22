package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej1Guia6 {

    /*Escribir un programa que pida dos números enteros 
    por teclado y calcule la suma de los dos. 
    El programa deberá después mostrar el resultado de la suma
     */
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        System.out.println("Ingrese dos numeros para sumar");

        int num1, num2, suma;
        num1 = read.nextInt();
        num2 = read.nextInt();
        suma = (num1 + num2);
        System.out.println("La suma de los dos numeros es " + suma);
    }
}
