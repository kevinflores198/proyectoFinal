package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej4Guia6 {

static Scanner hola = new Scanner(System.in);

public static void main(String[] args) {

/*Elaborar un algoritmo en el cuál se 
ingrese un número entre 1 y 10 y se muestre su
equivalente en romano.*/    

    System.out.println("Ingrese un numero");
    
    int num = hola.nextInt();
    
    switch(num){
    case 1:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: I");
    break;
    case 2:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: II");
    break;
    case 3:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: III");
    break;
    case 4:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: VI");
    break;
    case 5:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: V");
    break;
    case 6:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: VI");
    break;
    case 7:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: VII");
    break;
    case 8:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: VIII");
    break;
    case 9:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: IX");
    break;
    case 10:
    System.out.println("El numero ingresado es " + num + "\n\nY su equivalente en romano es: X");
        }
    }
}
