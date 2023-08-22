/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIOS_INTRODUCCION_GUIA6;

import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class ej9Guia6 {

    /**
     * @param args the command line arguments
     * 
     * 
     * 
     * Escriba un programa que lea 20 números. 
     * Si el número leído es igual a cero se debe 
     * salir del bucle y mostrar el mensaje "Se 
     * capturó el numero cero". El programa deberá 
     * calcular y mostrar el
    resultado de la suma de los números leídos, 
    * pero si el número es negativo no debe sumarse.
    Nota: recordar el uso de la sentencia break.
     */
    
    
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
         System.out.println("Escriba 20 numeros, cuando se ingrese el 0 o un numero negativo, se cortará");
    int numero;
    
    do {
        numero = leer.nextInt();
        System.out.println("Su numero es " + numero + " puede continuar con otro numero");
    } while (numero > 0 && numero <= 20);
    }
    }
    
    
