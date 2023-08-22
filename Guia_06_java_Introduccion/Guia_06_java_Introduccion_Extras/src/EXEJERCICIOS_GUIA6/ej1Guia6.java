package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej1Guia6 {

public static void main(String[] args) {
/*Dado un tiempo en minutos, calcular su 
equivalente en días y horas. Por ejemplo, si el
usuario ingresa 1600 minutos, el sistema 
debe calcular su equivalente: 1 día, 26 horas.*/
    
Scanner hola = new Scanner (System.in);

int minutos, minutos2, horas, dias;

System.out.println("Ingrese los minutos");
    
minutos = hola.nextInt();
    
horas = (minutos/60);
minutos2 = minutos % 60;
dias = (horas/24);
horas = horas % 24;

System.out.println(minutos +" minutos son: " + dias + " dias y " + horas + " horas con " +minutos2+ " minutos");

    }   
}
