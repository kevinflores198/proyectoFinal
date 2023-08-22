package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej2Guia6 {

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
    
    int a,b,c,d;
    
    a = 1;
    b = 2;
    c = 3;
    d = 4;
    
    System.out.println("Numeros antes");
    
    System.out.println(" "+a+" "+b+" "+c+" "+d);  
    
    b=c;
    c=a;
    a=d;
    d=b;
    
    System.out.println("Numeros despues");
    
    System.out.println(" "+b+" "+c+" "+a+" "+d);  
    }
    
}
