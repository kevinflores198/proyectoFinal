package EXEJERCICIOS_GUIA6;

import java.util.Scanner;


public class ej3Guia622 {

static Scanner hola = new Scanner (System.in);

    public static void main(String[] args) {
    /*Elaborar un algoritmo en el cuál se 
    ingrese una letra y se detecte si se 
    trata de una vocal.
    Caso contrario mostrar un mensaje. 
    Nota: investigar la función equals() de la clase String.
*/
    String vocal;
    
    System.out.println("Ingrese una vocal");
    
    vocal = hola.next();
    vocal = vocal.toLowerCase();
    
    if("a".equals(vocal)||"e".equals(vocal)||"i".equals(vocal)||"o".equals(vocal)||"u".equals(vocal)){
        System.out.println("Ingresaste una vocal");
        
    }else{
        System.out.println("No ingresaste una vocal");
    }
    
    
    
    
    }
    
}
