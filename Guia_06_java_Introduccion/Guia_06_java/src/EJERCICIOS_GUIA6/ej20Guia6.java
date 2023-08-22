package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej20Guia6 {

static Scanner hola = new Scanner (System.in);

public static void main(String[] args) {

/*Un cuadrado mágico 3 x 3 es una matriz 3 x 3 
formada por números del 1 al 9 donde la
suma de sus filas, sus columnas y sus diagonales 
son idénticas. Crear un programa que
permita introducir un cuadrado por teclado y 
determine si este cuadrado es mágico o no.
El programa deberá comprobar que los números 
introducidos son correctos, es decir,
están entre el 1 y el 9.*/

int matriz[][]= new int[3][3];
      int sumaFilas1=0,sumaFilas2=0,sumaFilas3=0,sumaColumnas1=0,sumaColumnas2=0,sumaColumnas3=0,sumaDiagonal1=0,sumaDiagonal2=0;
        Scanner entradaScanner= new Scanner(System.in);
        
        for (int i = 0; i < 3; i++){   
            for (int j = 0; j < 3; j++)
            {
                System.out.println("Ingrese un numero"); 
               int numero=entradaScanner.nextInt();
               matriz[i][j]=numero;
            }
            
        }
        System.out.println("");
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print("["+matriz[i][j]+"]");  
            }
            
            System.out.println("");
        }
        
        
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
            if (i==0){
                sumaFilas1+=matriz[0][j];
            }if (i==1){
                sumaFilas2+=matriz[1][j];
            }if (i==2){
                sumaFilas3+=matriz[2][j];
            }
            }
            
    System.out.println("");
    
        }
        
    System.out.print("\nLa suma de la fila 1 es : "+sumaFilas1);
    System.out.print("\nLa suma de la fila 1 es : "+sumaFilas2);
    System.out.println("\nLa suma de la fila 1 es : "+sumaFilas3);
    
    System.out.println("");
    
    sumaColumnas1 = (matriz[0][0] + matriz[1][0] + matriz[2][0]);
    sumaColumnas2 = (matriz[0][1] + matriz[1][1] + matriz[2][1]);
    sumaColumnas3 = (matriz[0][2] + matriz[1][2] + matriz[2][2]);
    
    System.out.print("\nLa suma de la columna 1 es : "+sumaColumnas1);
    System.out.print("\nLa suma de la columna 2 es : "+sumaColumnas2);
    System.out.print("\nLa suma de la columna 3 es : "+sumaColumnas3);
    
    System.out.println("");
    
    sumaDiagonal1 = (matriz[0][0] + matriz[1][1] + matriz[2][2]);
    sumaDiagonal2 = (matriz[2][0] + matriz[1][1] + matriz[0][2]);

    System.out.print("\nLa suma de la diagonal 1 es : "+sumaDiagonal1);
    System.out.print("\nLa suma de la diagonal 2 es : "+sumaDiagonal2);
      
    System.out.println("");

    if (sumaFilas1==sumaFilas2 && sumaFilas1==sumaFilas3 && sumaFilas1 == sumaColumnas1 && sumaFilas1==sumaColumnas2 && sumaFilas1 == sumaColumnas3 && sumaFilas1 == sumaDiagonal1 && sumaFilas1 == sumaDiagonal2){
        System.out.println("Es magica");
    }else{
        System.out.println("No es magica");
    }
    }
}