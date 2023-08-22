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
public class ej4Guia6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer = new Scanner(System.in);
    
    String name;
    int year;
    
        System.out.println("Ingrese su numbre");
        name = leer.next();
        System.out.println("Ingrese su edad");
        year = leer.nextInt();
        System.out.println("This is " + name + " and I am " + year);
    
    }
    
}
