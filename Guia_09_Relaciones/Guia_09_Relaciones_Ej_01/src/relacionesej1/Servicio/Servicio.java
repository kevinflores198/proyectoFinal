package relacionesej1.Servicio;

import java.util.Scanner;
import relacionesej1.Entidades.Perro;
import relacionesej1.Entidades.Persona;

/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */

public class Servicio {

    Scanner leer = new Scanner(System.in);

    public Perro crearPerro(Perro perro1) {

        System.out.println("Ingrese el nombre del perro:");
        perro1.setNombre(leer.next());
        System.out.println("Ingrese la raza:");
        perro1.setRaza(leer.next());
        System.out.println("Ingrese la edad:");
        perro1.setEdad(leer.nextInt());
        System.out.println("Ingrese el tamaño");
        perro1.setTamaño(leer.next());

        return perro1;

    }

    public void crearPersona(Persona persona1, Perro perro1) {

        System.out.println("Ingrese el nombre de la persona:");
        persona1.setNombre(leer.next());
        System.out.println("Ingrese el apellido de la persona:");
        persona1.setApellido(leer.next());
        System.out.println("Ingrese la edad:");
        persona1.setEdad(leer.nextInt());
        System.out.println("Ingrese el dni");
        persona1.setDNI(leer.nextInt());

        persona1.setPerro(crearPerro(perro1));  //hace la relacion entre la persona y el perro

    }

    public void mostrarTodo(Persona persona1) {
        System.out.println(persona1.getNombre());
        System.out.println(persona1.getApellido());
        System.out.println(persona1.getEdad());
        System.out.println(persona1.getDNI());
        System.out.println(persona1.getPerro());
    }

}
