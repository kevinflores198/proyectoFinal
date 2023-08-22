/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIOS_INTRODUCCION_GUIA6;

import java.awt.BorderLayout;
import java.util.Scanner;

/**
 *
 * @author kevin
 */
public class ej10Guia6 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
    /*Realizar un programa que lea 4 números 
    (comprendidos entre 1 y 20)
    e imprima el número
    ingresado seguido de tantos asteriscos 
    como indique su valor. 
        
    Por ejemplo:
    5 *****
    3 ***
    11 ***********
    2 **
        
    */
    
    Scanner leer = new Scanner(System.in);
    
    System.out.println("Digite un numero : "); 
    
    int n = leer.nextInt();
    
    if (n>1 && n<=20) {
        
         System.out.print(n);
         
        for (int i = 0; i <= n; i++) {
            
            System.out.print("*");
        }
                }else {
        System.out.print("El numero ingresado en invalido");
    
        }
    }
}
    