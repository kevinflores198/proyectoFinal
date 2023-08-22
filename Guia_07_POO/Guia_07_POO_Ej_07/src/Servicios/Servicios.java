package Servicios;

import Persona.Persona;
import java.util.Locale;
import java.util.Scanner;

public class Servicios {

    Scanner leer = new Scanner(System.in).useLocale(Locale.US);

    public Persona crearPersona() {

        Persona a = new Persona();

        System.out.println("Ingrese los datos de la persona");
        System.out.println("Ingrese el nombre:");
        a.setNombre(leer.nextLine());
        System.out.println("Ingrese la edad:");
        a.setEdad(leer.nextInt());
        System.out.println("Ingrese el peso:");
        a.setPeso(leer.nextDouble());
        System.out.println("Ingrese la altura:");
        a.setAltura(leer.nextDouble());
        do {
            System.out.println("Sexo: (h: hombre - m: mujer - o: otro): ");
            a.setSexo(leer.next());
        } while (!"h".equals(a.getSexo()) && !a.getSexo().equals("m") && !a.getSexo().equals("o"));

        return a;
    }

    public double calcularIMC(Persona a) {
        System.out.println("Desea calcular su IMC? S/N");

        String respuesta = leer.next().toUpperCase();

        if ("S".equals(respuesta)) {
            
        }else if ("N".equals(respuesta)){
            System.out.println("\nGracias por ingresar");
        }
        double imc = 0;
        double resultado = a.getPeso() / (a.getAltura() * a.getAltura());

        System.out.println(resultado);
        if (resultado < 20) {
            System.out.println("\nEsta por debajo de su peso ideal su IMC es : " + resultado);
            imc = -1;
        } else if (resultado >= 20 && resultado <= 25) {
            System.out.println("\nEsta en su peso ideal su IMC es : " + resultado);
            imc = 0;
        } else if (resultado > 25) {
            System.out.println("\nEsta con sobrepeso su IMC es : " + resultado);
            imc = 1;
        }

        return imc;

    }

    public boolean esMayorDeEdad(Persona a) {

        boolean edadd;

        if (a.getEdad() > 18) {
            System.out.println("\nSos mayor de edad");
            edadd = true;
        } else {
            System.out.println("\nUsted es menor de edad");
            edadd = false;
        }
        return edadd;
    }

}
