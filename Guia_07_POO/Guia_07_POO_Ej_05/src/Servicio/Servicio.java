package Servicio;

import Cuenta.Bancaria;
import java.util.Scanner;

public class Servicio {

    static Scanner leer = new Scanner(System.in);
    Bancaria a = new Bancaria();

    public void objetoCuenta(Bancaria a) {

        System.out.println("Ingrese su numero de cuenta");
        a.setNumeroCuenta(leer.nextInt());
        System.out.println("Ingrese su DNI");
        a.setDNI(leer.nextInt());
        System.out.println("Ingrese su saldo actual");
        a.setSueldoActual(leer.nextInt());
    }

    public double Ingresar(Bancaria a) {

        double dinero, total;

        System.out.println("Ingrese cuanto dinero quiere agregar a su cuenta:");
        dinero = leer.nextDouble();
        total = a.getSueldoActual() + dinero;
        
        System.out.println("Usted tiene: $" + total);
        return total;
    }

    public double Retiro(double a) {

        double retiro, resta;

        System.out.println("Ingrese dinero a retirar");
        retiro = leer.nextDouble();
        resta = a - retiro;

        if (retiro > a) {
            resta = 0;
            System.out.println("La cuenta quedó en $" + 0);
        } else {
            System.out.println("Usted tiene: $" + resta);
        }
        return resta;
    }

    public double extraccionRapida(double a) {

        double extraccion;
        double calculo;
        calculo = a * 20 / 100;

        do {
            System.out.println("Usted puede sacar hasta $" + calculo + " \n¿Cuanto desea sacar?\n");
            extraccion = leer.nextDouble();
        } while (extraccion > calculo);

        System.out.println("Usted ha retirado $" + extraccion + " y ahora tiene $" + (a - extraccion) + " en su cuenta.");

        return (a - extraccion);
    }

    public double consultarSaldo(double cons) {
        double consulta;
        System.out.println("Desea saber cuanto saldo ha quedado en su cuenta?\n");
        System.out.println("1. Saber\n2. Salir\n");
        consulta = leer.nextDouble();
        if (consulta == 1) {
            System.out.println("\nSu saldo es de " + cons);
        } else if (consulta == 2) {
            System.out.println("Gracias por usar esta cuenta\n");
        } else if (consulta != 1 || consulta != 2) {
            System.out.println("No ha usado una de las dos opciones, gracias por usar la cuenta");
        }
        return cons;
    }

    public double consultarDatos(Bancaria b) {
        System.out.println("\nEste ha sido el recorrido por su cuenta hoy\n");
        System.out.println("Numero de cuenta: " + b.getNumeroCuenta());
        System.out.println("DNI: " + b.getDNI());
        System.out.println("Su sueldo actual es "+consultarSaldo(b.getSueldoActual()));
        System.out.println("Gracias por ingresar a nuestro sistema");
        return 0;
    }
}
