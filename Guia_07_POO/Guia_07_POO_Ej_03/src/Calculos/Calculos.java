package Calculos;

import java.util.Scanner;

public class Calculos {

    private double num1, num2;

    public Calculos() {
    }

    public Calculos(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public void crearOperacion() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el primer numero");
        num1 = leer.nextDouble();
        System.out.println("Ingrese el segundo numero");
        num2 = leer.nextDouble();

    }

    public double suma() {
        return num1 + num2;
    }

    public double resta() {
        return num1 - num2;
    }

    public double multiplicacion() {
        while (num1 != 0 || num2 != 0) {
            return num1 * num2;
        }
        return 0;
    }

    public double division() {
        while (num1 != 0 || num2 != 0) {
            return num1 / num2;
        }
        return 0;
    }

}
