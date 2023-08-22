package Entidad;

import java.util.Scanner;

public class Circunferencia {

    Scanner leer = new Scanner(System.in);
    private double radio;

    public Circunferencia() {
    }

    public Circunferencia(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void crearCircunferencia() {
        System.out.println("Ingrese el radio: ");
        radio = leer.nextDouble();
    }

    public void area(double radio) {
        double area = Math.PI * (this.radio * this.radio);
        System.out.println("El area es : " + area);

    }

    public void perimetro(double radio) {
        double perimetro = 2 * Math.PI * this.radio;
        System.out.println("El perimetro es: " + perimetro);
    }

    @Override
    public String toString() {
        return "Circunferencia{" + "leer=" + leer + ", radio=" + radio + '}';
    }

}
