package excepcionesej5;

import java.util.Scanner;

public class ExcepcionesEj5 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        /*
    Escribir un programa en Java que juegue con el usuario a adivinar un número. 
    La computadora debe generar un número aleatorio entre 1 y 500, y el usuario 
    tiene que intentar adivinarlo. 
    Para ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. 
    Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
carácter fallido como un intento.
         */

        int numeroAleatorio = 1 + (int) (Math.random() * 10), numero = -1, intentos = 0;

        System.out.println("-----------Adivina el numero-----------");

        try {
            System.out.print("\nIngrese el numero de intentos a probar: ");
            intentos = leer.nextInt();

            do {

                System.out.print("\nIngrese el numero: ");

                try {

                    numero = Integer.parseInt(leer.next());
                    intentos--;

                    if (numero > numeroAleatorio) {
                        System.out.print("\nEl numero a adivinar es menor");
                        if (intentos == 0) {
                            System.out.println("\nYa no le quedan intentos");
                        } else {
                            System.out.println("\nLe quedan " + intentos + " intentos");
                        }
                    }

                    if (numero < numeroAleatorio) {
                        System.out.println("\nEl numero a adivinar es mayor");
                        if (intentos == 0) {
                            System.out.println("\nYa no le quedan intentos");
                        } else {
                            System.out.println("\nLe quedan " + intentos + " intentos");
                        }
                    }

                    if (numero == numeroAleatorio) {
                        System.out.print("\nA acertado!! el numero es: " + numeroAleatorio + "\n");

                        if (intentos == 0) {
                            System.out.println("\nHa utilizado todos los intentos");
                        } else {
                            System.out.println("\nLe quedaron " + intentos + " intentos sin usar\n");
                        }
                        break;
                    }

                } catch (NumberFormatException e) {
                    intentos--;
                    if (intentos == 0) {
                        System.out.println("\nError: Debía ingresar numeros");
                        System.out.println("\nYa no le quedan intentos");
                    } else {
                        System.out.println("\nError: Debe ingresar numeros");
                        System.out.println("\nLe quedan " + intentos + " intentos");
                    }
                }

            } while (intentos > 0);

            if (numero != numeroAleatorio) {
                System.out.println("\nLo sentimos pero no gano el juego, el numero era " + numeroAleatorio);
            }

        } catch (Exception e) {
            System.out.println("\nError: Lo ingresado no es un numero. Reinicie el programa");

        }

    }

}
