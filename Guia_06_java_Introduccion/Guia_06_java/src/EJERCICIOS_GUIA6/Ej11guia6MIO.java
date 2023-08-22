/*
Realizar un programa que pida dos números enteros positivos por 
teclado y muestre por
pantalla el siguiente menú:
MENU
1. Sumar
2. Restar
3. Multiplicar
4. Dividir
5. Salir
Elija opción:
El usuario deberá elegir una opción y el programa deberá mostrar 
el resultado por pantalla
y luego volver al menú. El programa deberá ejecutarse hasta que 
se elija la opción 5.
Tener en cuenta que, si el usuario selecciona la opción 5, en 
vez de salir del programa
directamente, se debe mostrar el siguiente mensaje de 
confirmación: ¿Está seguro que
desea salir del programa (S/N)? Si el usuario selecciona 
el carácter ‘S’ se sale del
programa, caso contrario se vuelve a mostrar el menú.
 */
package EJERCICIOS_GUIA6;

import java.util.Scanner;

public class Ej11guia6MIO {

public static void main(String[] args) {
         
    Scanner leer = new Scanner(System.in);

    int num1,num2,opciones,suma,resta,multiplicacion,division,salir;


    System.out.println("Ingrese dos numeros positivos para poder calcular");
    
    num1 = leer.nextInt();
    
    System.out.println(" ");
    
    num2 = leer.nextInt();
    
    suma = (num1+num2);
    resta = (num1-num2);
    multiplicacion = (num1*num2);
    division = (num1%num2);

    do{

        System.out.println("Gracias, ha ingresado al menu de opciones\n\nQue desea hacer?\nIngrese uno de los numeros\n");
        
        System.out.println("1.Suma\n2.Resta\n3.Multiplicacion\n4.Division\n5.¿O desea salir?");
    
        opciones = leer.nextInt();
    
        switch(opciones){
            case 1:
                System.out.println("El resultado de: " + num1 + " + " + num2 + " es: " + suma +" \n ");
                break;
            case 2:
                System.out.println("El resultado de: " + num1 + " - " + num2 + " es: " + resta +" \n ");
                break;
            case 3:
                System.out.println("El resultado de: " + num1 + " * " + num2 + " es: " + multiplicacion +" \n ");
                break;
            case 4:
                System.out.println("El resultado de: " + num1 + " / " + num2 + " es: " + division + " \n ");
                break;
            case 5:
                opciones = Salir();
                break;
    }}while(opciones != 5);
        System.out.println("Gracias por usar nuestro programa!"); 
        
}        


    public static int Salir(){
    
    Scanner readln = new Scanner(System.in);
    
    int decision;
        
    System.out.print("Ingrese:\n1.Salir\n2.Volver al menu\n-->");
    
    decision = readln.nextInt();
    
    if(decision == 1){
        
    return 5;
    
    }else{
        
    return 0;
    
        }
    }
}
       
                    
                

                    