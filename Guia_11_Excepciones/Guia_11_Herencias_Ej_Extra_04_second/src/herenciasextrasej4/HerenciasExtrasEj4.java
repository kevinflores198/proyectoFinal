/*
Sistema Gestión Facultad. Se pretende realizar una aplicación para una facultad que gestione
la información sobre las personas vinculadas con la misma y que se pueden clasificar en tres
tipos: estudiantes, profesores y personal de servicio. A continuación, se detalla qué tipo de
información debe gestionar esta aplicación:
• Por cada persona, se debe conocer, al menos, su nombre y apellidos, su número de
identificación y su estado civil.
• Con respecto a los empleados, sean del tipo que sean, hay que saber su año de
incorporación a la facultad y qué número de despacho tienen asignado.
• En cuanto a los estudiantes, se requiere almacenar el curso en el que están
matriculados.
• Por lo que se refiere a los profesores, es necesario gestionar a qué departamento
pertenecen (lenguajes, matemáticas, arquitectura, ...).
• Sobre el personal de servicio, hay que conocer a qué sección están asignados
(biblioteca, decanato, secretaría, ...).
El ejercicio consiste, en primer lugar, en definir la jerarquía de clases de esta aplicación. A
continuación, debe programar las clases definidas en las que, además de los constructores,
hay que desarrollar los métodos correspondientes a las siguientes operaciones:
• Cambio del estado civil de una persona.
• Reasignación de despacho a un empleado.
• Matriculación de un estudiante en un nuevo curso.
• Cambio de departamento de un profesor.
• Traslado de sección de un empleado del personal de servicio.
• Imprimir toda la información de cada tipo de individuo. Incluya un programa de prueba
que instancie objetos de los distintos tipos y pruebe los métodos desarrollados.
 */
package herenciasextrasej4;

import herenciasextrasej4.entidades.empleado;
import herenciasextrasej4.entidades.estudiante;
import herenciasextrasej4.entidades.persona;
import herenciasextrasej4.entidades.personalDeServicio;
import herenciasextrasej4.entidades.profesor;
import java.util.ArrayList;
import java.util.Scanner;

public class HerenciasExtrasEj4 {

    public static void main(String[] args) {

        /*
        Imprimir toda la información de cada tipo de individuo. Incluya un programa de prueba
que instancie objetos de los distintos tipos y pruebe los métodos desarrollados.

         */
        Scanner leer = new Scanner(System.in);
        persona persona = new persona();
        estudiante estudiante = new estudiante();
        empleado empleado = new empleado();
        personalDeServicio personalDeServicio = new personalDeServicio();
        profesor profesor = new profesor();
        ArrayList<estudiante> listaEstudiantes = new ArrayList();
        ArrayList<profesor> listaProfesores = new ArrayList();
        ArrayList<personalDeServicio> listaPersonalDeServicio = new ArrayList();

        int respuesta;

        System.out.println("Sistema de Gestión de la Facultad\n");

        do {
            listaEstudiantes.add(estudiante);
            listaProfesores.add(profesor);
            listaPersonalDeServicio.add(personalDeServicio);

            System.out.println("\nIngrese persona a completar\n"
                    + "\n1. Estudiante"
                    + "\n2. Personal de servicio"
                    + "\n3. Profesor"
                    + "\n4. Salir\n");

            respuesta = leer.nextInt();

            switch (respuesta) {
                case 1:
                    estudiante.crearPersona();
                    estudiante.matriculacion();

                    break;
                case 2:
                    personalDeServicio.crearPersona();
                    personalDeServicio.seccionAsignada();
                    personalDeServicio.infoEmpleado();
                    break;
                case 3:
                    profesor.crearPersona();
                    profesor.departamento();
                    profesor.infoEmpleado();
                    break;
            }
        } while (respuesta != 4);

        System.out.println("\nLe gustaria ver las personas ingresadas?"
                + "\n1. Si"
                + "\n2. No");

        respuesta = leer.nextInt();

        if (respuesta == 1) {

            do {

                System.out.println("\n¿Que lista de personas desea ver?\n"
                        + "\n1. Estudiantes"
                        + "\n2. Personal de servicio"
                        + "\n3. Profesores"
                        + "\n4. Salir\n");

                respuesta = leer.nextInt();

                switch (respuesta) {
                    case 1:

                        System.out.println("---Lista de estudiantes---");
                        for (estudiante estudiantes : listaEstudiantes) {
                            System.out.println(estudiantes);
                        }
                        break;
                    case 2:
                        System.out.println("---Lista de profesores---");
                        for (profesor profesores : listaProfesores) {
                            System.out.println(profesores);
                        }
                        break;
                    case 3:
                        System.out.println("---Lista de personal---");
                        for (personalDeServicio personal : listaPersonalDeServicio) {
                            System.out.println(personal);
                        }
                        break;
                }
            } while (respuesta != 4);

        } else if (respuesta == 2) {

            System.out.println("\nOk no se mostraran las personas");

        }

        System.out.println("\nLe gustaria hacer alguna modificaion?"
                + "\n1. Si"
                + "\n2. No");

        respuesta = leer.nextInt();

        if (respuesta == 1) {
            do {
                System.out.println("\n------Modificaciones------"
                        + "\n1. Estudiantees"
                        + "\n2. Personal de servicio"
                        + "\n3. Profesores"
                        + "\n4. Salir");

                respuesta = leer.nextInt();

                switch (respuesta) {
                    case 1:
                        estudiante.cambiarMatriculacion();
                        estudiante.cambiarEstadoCivil();

                        break;
                    case 2:
                        personalDeServicio.cambiarEstadoCivil();
                        personalDeServicio.trasladoDeSeccion();
                        break;
                    case 3:
                        profesor.cambiarEstadoCivil();
                        profesor.cambioDepartamento();
                        break;
                    case 4:
                        respuesta = 4;
                }
            } while (respuesta != 4);
            System.out.println("\nLe gustaria ver las personas que cambió?"
                    + "\n1. Si"
                    + "\n2. No");

            respuesta = leer.nextInt();

            if (respuesta == 1) {

                System.out.println("---Lista de estudiantes---");
                for (estudiante estudiantes : listaEstudiantes) {
                    System.out.println(estudiantes);
                }

                System.out.println("---Lista de profesores---");
                for (profesor profesores : listaProfesores) {
                    System.out.println(profesores);
                }

                System.out.println("---Lista de personal---");
                for (personalDeServicio personal : listaPersonalDeServicio) {
                    System.out.println(personal);
                }

            } else if (respuesta == 2) {

                System.out.println("\nOk no se mostraran las personas");
            }

        } else if (respuesta == 2) {
            System.out.println("\nGracias por usar el Sistema de Gestión de la Facultad");
        }

        System.out.println("\nGracias por usar el Sistema de Gestión de la Facultad");
    }
}
