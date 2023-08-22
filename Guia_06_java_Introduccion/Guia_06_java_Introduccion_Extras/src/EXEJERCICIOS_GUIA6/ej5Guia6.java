package EXEJERCICIOS_GUIA6;

import java.util.Scanner;

public class ej5Guia6 {
    
static Scanner hola = new Scanner(System.in);

public static void main(String[] args) {
/*Una obra social tiene tres clases de socios:
- Los socios tipo ‘A’ abonan una cuota mayor, 
pero tienen un 50% de descuento en
todos los tipos de tratamientos.
- Los socios tipo ‘B’ abonan una cuota moderada
y tienen un 35% de descuento para
los mismos tratamientos que los socios del tipo A.
- Los socios que menos aportan, los de tipo ‘C’, 
no reciben descuentos sobre dichos
tratamientos.

Solicite una letra (carácter) que representa 
la clase de un socio, y luego un valor
real que represente el costo del tratamiento 
(previo al descuento) y determine el
importe en efectivo a pagar por dicho socio.*/ 

   int claseSocio,tratamiento;
   double precio1,precio2;
   
   do{     
        System.out.println("Por favor ingrese que clase de cliente es:\n");
    
        System.out.println("1. A (Con cuota mayor)\n2. B (Con cuota moderada)\n3. C (Con cuota sin descuento)");
        
        claseSocio = hola.nextInt();
        
        System.out.println("Por favor ingrese el costo del tratamiento");
    
        tratamiento = hola.nextInt();
        
        precio1 = tratamiento - (tratamiento*50)/100;
        precio2 = tratamiento - (tratamiento*35)/100;
       
        switch(claseSocio){
            
            case 1:
                System.out.println("El tratamiento tiene un costo de: $" + tratamiento + ". El cliente con cuota A recibira un 50% de descuento y el precio total es $" + precio1 + "\n");
                break;
            case 2:
                System.out.println("El tratamiento tiene un costo de: $" + tratamiento + ". El cliente con cuota B recibira un 35% de descuento y el precio total es $" + precio2 + "\n");
                break;
            case 3:
                System.out.println("El tratamiento tiene un costo de: $" + tratamiento + ". El cliente con cuota C no recibira despuento, por lo tanto debera pagar  $" + tratamiento + "\n");
                break;
        }
    }while(claseSocio<4);
        System.out.println("Lo sentimos no tenemos una cuarta opcion.\n\nGracias por usar nuestro programa.");
   }

public static void limpiarConsola() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}

}