package excepcionesej1;

import excepcionesej1.entidades.array;
import java.util.Scanner;

public class ExcepcionesEj1 {

    public static void main(String[] args) {

        /*
        Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
         */
        array a = new array();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        try {
            System.out.println("Ingrese un numero entre 0 y 4\n>");
            int numero = leer.nextInt();
            System.out.println(a.getArray()[numero]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Lo sentimos, el numero ingresado esta fuera de 0 y 4");
            
        }catch(Exception e){
            System.out.println("Lo ingresado no es un numero");
        }
    }

}
