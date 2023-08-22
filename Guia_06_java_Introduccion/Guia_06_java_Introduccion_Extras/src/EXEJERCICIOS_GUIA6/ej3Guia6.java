package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej3Guia6 {

static Scanner hola = new Scanner (System.in);
    
public static void main(String[] args) {
    /*Elaborar un algoritmo en el cuál se 
    ingrese una letra y se detecte si se 
    trata de una vocal.
Caso contrario mostrar un mensaje. 
    Nota: investigar la función equals() de la clase String.
*/
    System.out.println("Ingrese una vocal");
    
    String letra=hola.next().toUpperCase();
    
    if("A".equals(letra)||"E".equals(letra)||"I".equals(letra)||"O".equals(letra)||"U".equals(letra)){
        
        System.out.println("correcto");
    }else{
        System.out.println("incorrecto");
        }
    }
}