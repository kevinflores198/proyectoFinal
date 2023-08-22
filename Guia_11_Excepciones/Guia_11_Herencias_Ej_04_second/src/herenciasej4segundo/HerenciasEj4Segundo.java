package HerenciasEj4Segundo;

import HerenciasEj4Segundo.entidades.estudiante;
import HerenciasEj4Segundo.entidades.persona;
import HerenciasEj4Segundo.entidades.personalServicio;
import HerenciasEj4Segundo.entidades.profesor;
import java.util.Scanner;

/*
Sistema GestiÃ³n Facultad. Se pretende realizar una aplicaciÃ³n para una facultad que gestione
la informaciÃ³n sobre las personas vinculadas con la misma y que se pueden clasificar en tres
tipos: estudiantes, profesores y personal de servicio. A continuaciÃ³n, se detalla quÃ© tipo de
informaciÃ³n debe gestionar esta aplicaciÃ³n:
â€¢ Por cada persona, se debe conocer, al menos, su nombre y apellidos, su nÃºmero de
identificaciÃ³n y su estado civil.
â€¢ Con respecto a los empleados, sean del tipo que sean, hay que saber su aÃ±o de
incorporaciÃ³n a la facultad y quÃ© nÃºmero de despacho tienen asignado.
â€¢ En cuanto a los estudiantes, se requiere almacenar el curso en el que estÃ¡n
matriculados.
â€¢ Por lo que se refiere a los profesores, es necesario gestionar a quÃ© departamento
pertenecen (lenguajes, matemÃ¡ticas, arquitectura, ...).
â€¢ Sobre el personal de servicio, hay que conocer a quÃ© secciÃ³n estÃ¡n asignados
(biblioteca, decanato, secretarÃ­a, ...).
El ejercicio consiste, en primer lugar, en definir la jerarquÃ­a de clases de esta aplicaciÃ³n. A
continuaciÃ³n, debe programar las clases definidas en las que, ademÃ¡s de los constructores,
hay que desarrollar los mÃ©todos correspondientes a las siguientes operaciones:
â€¢ Cambio del estado civil de una persona.
â€¢ ReasignaciÃ³n de despacho a un empleado.
â€¢ MatriculaciÃ³n de un estudiante en un nuevo curso.
â€¢ Cambio de departamento de un profesor.
â€¢ Traslado de secciÃ³n de un empleado del personal de servicio.
â€¢ Imprimir toda la informaciÃ³n de cada tipo de individuo. Incluya un programa de prueba
que instancie objetos de los distintos tipos y pruebe los mÃ©todos desarrollados.
 */
public class HerenciasEj4Segundo {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.println("Bienvenido al programa de ingreso de gente de la Facultad");

        estudiante estudiante = new estudiante();
        profesor profesor = new profesor();
        personalServicio personalServicio = new personalServicio();
        persona persona = new persona();

        persona.crearListaPersonas_y_Modificar();
        persona.mostrarListaPersonas(estudiante, profesor, personalServicio);
        persona.hacerCambios();
        persona.mostrarListaPersonas(estudiante, profesor, personalServicio);

        System.out.println("Gracias por usar nuestro programa");
    }
}
