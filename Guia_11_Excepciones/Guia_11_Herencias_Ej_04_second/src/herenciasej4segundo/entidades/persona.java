package HerenciasEj4Segundo.entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class persona {

    ArrayList<estudiante> listaEstudiantes = new ArrayList();
    ArrayList<profesor> listaProfesores = new ArrayList();
    ArrayList<personalServicio> listaPersonal = new ArrayList();

    protected String nombreCompleto;
    protected int dni;
    protected String estadoCivil;
    int respuesta;

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public persona() {
    }

    public persona(String nombreCompleto, int dni, String estadoCivil) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.estadoCivil = estadoCivil;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "\nNombre Completo: " + nombreCompleto + "\nDNI: " + dni + "\nEstado Civil: " + estadoCivil;
    }

    //**************************************************************
    public void crearPersona() {

        System.out.print("Ingrese nombre completo: ");
        nombreCompleto = leer.next();

        System.out.print("Ingrese DNI: ");
        dni = leer.nextInt();

        System.out.print("Ingrese estado civil: ");
        estadoCivil = leer.next();
    }

    //**************************************************************
    public String cambiarEstadoCivil() {

        System.out.print("Ingrese el nuevo estado civil: ");
        return estadoCivil = leer.next();
    }

    //**************************************************************
    public void crearListaPersonas_y_Modificar() {

        do {
            System.out.print("\nQue clase de persona desea crear?"
                    + "\n1. Estudiantes"
                    + "\n2. Profesores"
                    + "\n3. Personal de servicio"
                    + "\n4. Salir"
                    + "\n>");
            respuesta = leer.nextInt();

            switch (respuesta) {
                case 1:
                    do {

                        estudiante estudiante = new estudiante();
                        estudiante.estudianteCreado();
                        listaEstudiantes.add(estudiante);

                        System.out.println("¿Desea agregar otro estudiante?"
                                + "\n1. Si"
                                + "\n2. No");
                        respuesta = leer.nextInt();

                    } while (respuesta == 1);

                    break;
                case 2:
                    do {
                        profesor profesor = new profesor();
                        profesor.profesorCreado();
                        listaProfesores.add(profesor);

                        System.out.println("¿Desea agregar otro profesor?"
                                + "\n1. Si"
                                + "\n2. No");
                        respuesta = leer.nextInt();

                    } while (respuesta == 1);

                    break;

                case 3:

                    do {
                        personalServicio personalServicio = new personalServicio();
                        personalServicio.personalCreado();
                        listaPersonal.add(personalServicio);

                        System.out.println("\n¿Desea agregar otro personal de servicio?"
                                + "\n1. Si"
                                + "\n2. No");
                        respuesta = leer.nextInt();

                    } while (respuesta == 1);

                    break;
            }

        } while (respuesta != 4);
        System.out.println("\nLos datos fueron agregados");
    }

    public void hacerCambios() {

        System.out.println("\nDesea hacer algun cambio?"
                + "\n1. Si"
                + "\n2. No");
        respuesta = leer.nextInt();

        if (respuesta == 1) {

            do {
                System.out.print("\n¿En que lista de personas desea hacer cambios?"
                        + "\n1. Estudiantes"
                        + "\n2. Profesores"
                        + "\n3. Personal de servicio"
                        + "\n4. Salir"
                        + "\n>");

                respuesta = leer.nextInt();

                switch (respuesta) {
                    case 1:
                        do {
                            System.out.print("\nIngrese el nombre del estudiante que quiere modificar: ");

                            String nombreBuscar = leer.next();

                            Iterator<estudiante> it = listaEstudiantes.iterator();

                            while (it.hasNext()) {

                                estudiante aux = it.next();

                                if (nombreBuscar.equals(aux.getNombreCompleto())) {

                                    aux.cambiarDatosEstudiante();

                                } else if (!nombreBuscar.equals(aux.getNombreCompleto())) {

                                    System.out.println("\nEste nombre no esta en la lista");

                                }
                            }

                            System.out.println("\n¿Desea modificar otro estudiante?"
                                    + "\n1. Si"
                                    + "\n2. No");

                            respuesta = leer.nextInt();

                        } while (respuesta == 1);

                        break;

                    case 2:

                        do {
                            System.out.print("\nIngrese el nombre del profesor que quiere modificar: ");

                            String nombreBuscar = leer.next();

                            Iterator<profesor> it1 = listaProfesores.iterator();

                            while (it1.hasNext()) {

                                profesor aux = it1.next();

                                if (nombreBuscar.equals(aux.getNombreCompleto())) {

                                    aux.cambiarDatosProfesor();
                                } else if (!nombreBuscar.equals(aux.getNombreCompleto())) {

                                    System.out.println("\nEste nombre no esta en la lista");

                                }
                            }
                            System.out.println("\n¿Desea modificar otro profesor?");

                            respuesta = leer.nextInt();

                        } while (respuesta == 1);

                        break;

                    case 3:

                        do {
                            System.out.print("\nIngrese el nombre del estudiante que quiere modificar: ");

                            String nombreBuscar = leer.next();

                            Iterator<personalServicio> it2 = listaPersonal.iterator();

                            while (it2.hasNext()) {

                                personalServicio aux = it2.next();

                                if (nombreBuscar.equals(aux.getNombreCompleto())) {

                                    aux.cambiarDatosPersonal();

                                } else if (!nombreBuscar.equals(aux.getNombreCompleto())) {

                                    System.out.println("\nEste nombre no esta en la lista");

                                }
                            }
                            System.out.println("\n¿Desea modificar otra persona?");

                            respuesta = leer.nextInt();

                        } while (respuesta == 1);

                        break;
                }
                System.out.println("\nLos datos se cargaron correctamente");

                System.out.println("\n¿Desea modificar alguna persona mas de las listas?"
                        + "\n1. Si"
                        + "\n2. No");

                respuesta = leer.nextInt();
            } while (respuesta == 1);

        }
    }

    public void mostrarListaPersonas(estudiante estudiante, profesor profesor, personalServicio personalServicio) {

        System.out.println("\n¿Desea ver alguna lista?"
                + "\n1. Si"
                + "\n2. No");

        respuesta = leer.nextInt();

        if (respuesta == 1) {

            do {
                System.out.print("\n¿Que lista de personas desea ver?"
                        + "\n1. Estudiantes"
                        + "\n2. Profesores"
                        + "\n3. Personal de servicio"
                        + "\n4. Salir"
                        + "\n>");

                respuesta = leer.nextInt();
                switch (respuesta) {
                    case 1:
                        listaEstudiantes.forEach((listaEstudiante) -> {
                            System.out.println(listaEstudiante);
                        });
                        break;
                    case 2:
                        listaProfesores.forEach((listaProfesor) -> {
                            System.out.println(listaProfesor);
                        });
                        break;
                    case 3:
                        listaPersonal.forEach((listaPersonal1) -> {
                            System.out.println(listaPersonal1);
                        });
                        break;
                }
                System.out.println("\n¿Desea ver alguna lista mas?"
                        + "\n1. Si"
                        + "\n2. No");

                respuesta = leer.nextInt();
            } while (respuesta == 1);

        } else {
        }
    }
}
