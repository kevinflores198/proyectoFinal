/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona.
 */
package relacionesej1;

import java.util.Scanner;
import relacionesej1.Entidades.Perro;
import relacionesej1.Entidades.Persona;
import relacionesej1.Servicio.Servicio;

public class RelacionesEj1 {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona();
        Perro perro2 = new Perro();
        Perro perro1 = new Perro();
        Servicio s = new Servicio();
        Scanner leer = new Scanner(System.in);

        s.crearPersona(persona1, perro1);
        s.mostrarTodo(persona1);

        s.crearPersona(persona2, perro2);
        s.mostrarTodo(persona2);
    }
}
