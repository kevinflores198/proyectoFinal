/*
Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas
geométricas, en este caso un círculo y un rectángulo. Ya que este cálculo se va a repetir en las
dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
dos métodos para calcular el área, el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el
resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package herenciasej4;

import herenciasej4.circulo.circulo;
import herenciasej4.rectangulo.rectangulo;
import java.util.Scanner;

public class HerenciasEj4 {

    public static void main(String[] args) {

        int respuesta = 0;

        Scanner leer = new Scanner(System.in);
        circulo c = new circulo();
        rectangulo r = new rectangulo();

        System.out.println("Ingrese la figura que quiere crear:\n"
                + "1. circulo\n"
                + "2. Rectangulo\n");

        respuesta = leer.nextInt();

        if (respuesta == 1) {
            c.crearCircunferencia();
        } else if (respuesta == 2) {
            r.crearRectangulo();
        }

        do {

            System.out.println("\nLe gustaria crear otra figura?\n"
                    + "1. circulo\n"
                    + "2. Rectangulo\n"
                    + "3. Salir");

            respuesta = leer.nextInt();

            if (respuesta == 1) {
                c.crearCircunferencia();
            }
            if (respuesta == 2) {
                r.crearRectangulo();
            }
        } while (respuesta == 1 || respuesta == 2);

        System.out.println("\nAdios");

    }

}
