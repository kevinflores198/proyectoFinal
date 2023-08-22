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
package herenciasej4.calculosFormas;

import java.util.Scanner;

public abstract class calculosFormas {

    protected float radio;
    protected float area;
    protected float perimetro;
    protected float base;
    protected float altura;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public float calcularAreaCirculo() {
        area = (float) Math.PI * (radio * radio);
        System.out.println("El area del circulo es : " + area);
        return area;
    }

    public float calcularPerimetroCirculo() {
        perimetro = 2 * (float) Math.PI * radio;
        System.out.println("El perimetro del circulo es: " + perimetro);
        return perimetro;
    }

    public float calcularAreaRectangulo() {
        area = (base * altura);
        System.out.println("El area del rectangulo es : " + area);
        return area;
    }

    public float calcularPerimetroRectangulo() {
        perimetro = (base + altura) * 2;
        System.out.println("El perimetro del rectangulo es: " + perimetro);
        return perimetro;
    }

}
