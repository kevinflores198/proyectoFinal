package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej1Guia622 {

static Scanner hola = new Scanner (System.in);
    
public static void main(String[] args) {
    
/*Dado un tiempo en minutos, calcular su 
equivalente en días y horas. Por ejemplo, si el
usuario ingresa 1600 minutos, el sistema 
debe calcular su equivalente: 1 día, 26 horas.*/

int minutos, dias, horas,mini;

System.out.println("Ingrese los minutos a calcular\n");

mini = hola.nextInt();
horas = (mini/60);
dias = (horas/24);
dias = mini/1440;
horas = (mini % 1440)/60;
minutos = ((mini % 1440) % 60);

System.out.println("Los "+mini+ " minutos son: "+horas+" horas y "+dias+" dias y "+minutos+" minutos");

        

    }
    
}
