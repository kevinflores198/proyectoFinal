/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXEJERCICIOS_GUIA6;

import java.util.Scanner;


public class ej2Guia622 {

static Scanner hola = new Scanner (System.in);

public static void main(String[] args) {
    
/*Declarar cuatro variables de tipo entero A, B, C y D y 
    asignarle un valor diferente a cada
una. A continuación, realizar las instrucciones 
    necesarias para que: B tome el valor de C, C
tome el valor de A, A tome el valor de D y D tome
    el valor de B. Mostrar los valores
iniciales y los valores finales de cada variable.
    Utilizar sólo una variable auxiliar.*/

int a=1,b=2,c=3,d=4,aux;

    System.out.println("Valores iniciales");
    
    System.out.println(a+" "+b+" "+c+" "+d);
    
    System.out.println("Valores finales");
    /*B tome el valor de 
    C tome el valor de A
    A tome el valor de D 
    D tome el valor de B.*/
    
    aux=b;
    b=c;
    c=a;
    a=d;
    d=aux;
    
    System.out.println(b+" "+c+" "+a+" "+d);

    }
    
}
