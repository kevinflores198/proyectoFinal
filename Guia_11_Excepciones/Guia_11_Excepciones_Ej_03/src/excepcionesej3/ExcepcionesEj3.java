package excepcionesej3;

import excepcionesej3.entidades.DivisionNumero;
import java.util.Scanner;

public class ExcepcionesEj3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        DivisionNumero d = new DivisionNumero();
        int intentos = 3, convertidor1, convertidor2;

        do {

            try {

                System.out.print("ingrese el primer numero\n>");
                d.setNum1(leer.next());

                System.out.print("Ingrese el segundo numero\n>");
                d.setNum2(leer.next());
                
                convertidor1 = Integer.parseInt(d.getNum1());
                convertidor2 = Integer.parseInt(d.getNum2());

                System.out.println("\nLos numeros divididos: " + (float)(convertidor1 / convertidor2));
                intentos--;
                break;

            } catch (NumberFormatException e) {
                intentos--;
                if (intentos == 0) {
                    System.out.println("\nError: Debía ingresar un numero");
                    System.out.println("\nYa no le quedan intentos, reinicie el programa\n");
                } else {
                    System.out.println("\nError: Debe ingresar numeros");
                    System.out.println("\nLe quedan " + intentos + " intentos de 3\n");
                }

            } catch (ArithmeticException e) {
                intentos--;
                if (intentos == 0) {
                    System.out.println("\nError: El numero ingresado es 0 y no podemos dividir a 0");
                    System.out.println("\nYa no le quedan intentos, reinicie el programa\n");
                } else {
                    System.out.println("\nError: El numero ingresado es 0 y no podemos dividir a 0\n");
                    System.out.println("\nLe quedan " + intentos + " intentos de 3\n");
                }
            }
        } while (intentos != 0);
    }
}
