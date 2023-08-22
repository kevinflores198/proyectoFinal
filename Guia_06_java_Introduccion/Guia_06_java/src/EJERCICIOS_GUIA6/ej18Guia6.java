package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej18Guia6 {

static Scanner hola = new Scanner (System.in);

public static void main(String[] args) {

/*Realizar un programa que rellene un matriz 
de 4 x 4 de valores aleatorios y muestre la
traspuesta de la matriz. La matriz traspuesta 
de una matriz A se denota por B y se obtiene
cambiando sus filas por columnas (o viceversa).
*/

int dimension = 4;

//diseñamos la matriz:
int[][]matriz;
matriz = new int[dimension][dimension];

//Definimos los lados:

for (int i = 0 ; i < dimension ; i++){
    for (int j = 0 ; j <dimension ; j++){
        matriz[i][j] = (int)(Math.random()*10);
        
        } 
    }
    System.out.println("\nLa matriz antes\n");
    for (int i = 0 ; i < dimension ; i++){
    for (int j = 0 ; j <dimension ; j++){
        if(j != dimension-1){
            System.out.print(matriz[i][j]+" ");
        }
        else{
            System.out.println(" "+matriz[i][j]);
        }
    }
    }
Transpuesta(matriz, dimension);
}

public static void Transpuesta(int m[][], int d){

int[][] trans;
trans = new int [d][d];

    for (int i = 0 ; i < d ; i++){
        for (int j = 0 ; j <d ; j++){
            trans[j][i] = m [i][j];
            }
        }
    System.out.println("\nLa matriz despues\n");
    
    for (int i = 0 ; i < d ; i++){
        for (int j = 0 ; j <d ; j++){
            if(j != d-1){
                System.out.print(" "+trans[i][j]+" ");
        }
        else{
            System.out.println(trans[i][j]);
            
                }
            }
        }
    }
}