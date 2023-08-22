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
public class ej8Guia6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*
    Escriba un programa que valide si una nota está 
    entre 0 y 10, sino está entre 0 y 10 la nota se
    pedirá de nuevo hasta que la nota sea correcta. 
   */
    
    Scanner leer = new Scanner(System.in);
    
    int num1 = 0;
    
    System.out.println("Ingrese un numero entre 0 y 10");
 
    while (num1>=0 && num1<=10){
        num1 = leer.nextInt();
        num1 = num1 ++;
    }System.out.println("El numero no esta mas entre 0 y 10");
}

}