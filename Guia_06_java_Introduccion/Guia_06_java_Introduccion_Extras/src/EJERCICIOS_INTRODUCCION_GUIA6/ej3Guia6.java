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
public class ej3Guia6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
    Scanner leer = new Scanner(System.in);
        
    int num1,num2,answer;
    System.out.println("Enter a number");  
       num1 = leer.nextInt();
    System.out.println("Enter a number else");
       num2 = leer.nextInt();

       answer = (num1 + num2);

    System.out.println("La suma de esos dos numeros es " + answer);
    }
}
