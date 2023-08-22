package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej19Guia6 {

static Scanner hola = new Scanner (System.in);

public static void main(String[] args) {

/*
Realice un programa que compruebe si 
una matriz dada es anti simétrica. Se dice que una
matriz A es anti simétrica cuando ésta 
es igual a su propia traspuesta, pero cambiada de
signo. Es decir, A es anti simétrica si 
A = -AT. La matriz traspuesta de una matriz A se
denota por AT y se obtiene cambiando sus 
filas por columnas (o viceversa).
*/

int dimension = 4;

//diseñamos la matriz:
int[][]matriz;
matriz = new int[dimension][dimension];

matriz[0][0] = 0;
matriz[0][1] = -2;
matriz[0][2] = 4;

matriz[1][0] = 2;
matriz[1][0] = 0;
matriz[1][1] = 2;

matriz[1][2] = -4;
matriz[2][1] = -2;
matriz[2][2] = 0;

//Definimos los lados:

System.out.println("La matriz antes\n");
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
    for (int j = 0 ; j < d ; j++){
                trans[j][i] = - m [i][j];
            }
        }
    System.out.println("La matriz despues");
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
             for(int i = 0; i < d; i++){
            for(int j = 0; j < d; j++){
                trans[j][i] = -m[i][j];
            }
        }
        AntiSimetrica(m,trans,d);
    }

public static void AntiSimetrica(int m[][], int t[][], int d ){
    
    boolean anti = true;
    
for (int i = 0 ; i < d ; i++){
    for (int j = 0 ; j <d ; j++){
            if(m[i][j] != t[j][i]*(-1));
            anti = false;
            }
        }
if(anti == false){
    System.out.println("la matriz no es antisimetrica");
}else{
    System.out.println("la matriz es antisimetrica");
}


}
}