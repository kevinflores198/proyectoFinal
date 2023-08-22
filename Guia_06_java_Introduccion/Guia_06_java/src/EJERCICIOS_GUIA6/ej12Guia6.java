
package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej12Guia6 {
    
static Scanner hola = new Scanner(System.in);

public static void main(String[] args) {
    
    /*Realizar un programa que simule el funcionamiento 
    de un dispositivo RS232, este tipo de
    dispositivo lee cadenas enviadas por el usuario. 
    Las cadenas deben llegar con un formato
    fijo: tienen que ser de un máximo de 5 caracteres 
    de largo, el primer carácter tiene que ser
    X y el último tiene que ser una O.
        
    Las secuencias leídas que respeten el formato se 
    consideran correctas, la secuencia
    especial “&&&&&” marca el final de los envíos 
    (llamémosla FDE), y toda secuencia distinta
    de FDE, que no respete el formato se considera incorrecta.
        
    Al finalizar el proceso, se imprime un informe 
    indicando la cantidad de lecturas correctas e
    incorrectas recibidas. Para resolver el ejercicio 
    deberá investigar cómo se utilizan las
    siguientes funciones de Java Substring(), Length(), equals(). 
*/
    String cadena,subcadena,subcadena2;
    int largo;
    
    do{
        System.out.println("Ingrese una frase que comience con x y finalice con o, tambien que tenga 5 caracteres: ");

        cadena = hola.next();
        
        largo = cadena.length();
        
        subcadena = cadena.substring(0,1);
        
        subcadena2 = cadena.substring(5); //si la palabra tiene menos que esto, me va salir error

 
        System.out.println("Perfecto! continue asi");
    
        cadena = hola.next();
         
    }while("x".equals(subcadena) && "o".equals(subcadena2) && largo<=5);
    
    System.out.println("Haz salido del bucle. Recuerde que tiene que ser de 5 letras, inicia con x y finaliza con o");
    }
}
