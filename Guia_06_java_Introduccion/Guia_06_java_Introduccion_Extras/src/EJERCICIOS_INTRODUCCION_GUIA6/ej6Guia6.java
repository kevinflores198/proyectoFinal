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
public class ej6Guia6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    
    int num1, num2;
        System.out.println("Ingrese un numero");
        num1 = leer.nextInt();
        System.out.println("Ingresa otro numero");
        num2 = leer.nextInt();
        
        if(num1>25 && num2>25){
        System.out.println("Los numeros son mayores a 25");
        }else if (num1<25 && num2<25){
        System.out.println("Los numeros no son mayores a 25");
        }else if(num1<25 || num2>25){
            System.out.println("El primero numero es menor a 25 y el segundo lo supera");
        }else { 
            System.out.println("El primero numero es mayor a 25 y el segundo lo no");
        }
    }
}

