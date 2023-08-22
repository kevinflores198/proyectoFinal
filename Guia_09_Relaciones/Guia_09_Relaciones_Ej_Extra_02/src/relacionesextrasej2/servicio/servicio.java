package relacionesextrasej2.servicio;

import relacionesextrasej2.Cine.Cine;
import relacionesextrasej2.Pelicula.Pelicula;
import relacionesextrasej2.persona.Persona;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class servicio {

    public static Cine crearCine() {
        return new Cine(crearPelicula(), crearSala(), 150, crearPersonas());
    }

    public static void mostrarSala(Cine c) {
        c.mostrarSala();
    }

    public static String[][] crearSala() {
        String sala[][] = new String[8][6];
        String letra = null;
        int numero = 8;
        for (int i = 0; i < 8; i++) {
            String num2 = String.valueOf(numero);
            for (int j = 0; j < 6; j++) {

                switch (j) {
                    case 0:
                        letra = "A";
                        break;

                    case 1:
                        letra = "B";
                        break;

                    case 2:
                        letra = "C";
                        break;

                    case 3:
                        letra = "D";
                        break;

                    case 4:
                        letra = "E";
                        break;

                    case 5:
                        letra = "F";
                        break;

                }
                sala[i][j] = letra + num2 + " " + "";
            }

            numero--;
        }
        return sala;
    }

    public static Pelicula crearPelicula() {
        return new Pelicula("Scarface", 18, 2, "Brian de Palma");
    }

    public static ArrayList arrayNombres() {
        ArrayList<String> listaNombres = new ArrayList(Arrays.asList(
                "Matias",
                "Javier",
                "Martin",
                "Lucia",
                "Sandra",
                "Alejandro",
                "Abril",
                "Ambar",
                "Belen",
                "Gonzalo",
                "Jose",
                "Aisha",
                "Alberto",
                "Lidia"
        ));
        Collections.shuffle(listaNombres);

        return listaNombres;
    }

    public static ArrayList arrayEdad() {
        ArrayList<Integer> listaEdad = new ArrayList(Arrays.asList(
                22,
                45,
                68,
                47,
                14,
                30,
                55,
                36,
                20,
                32,
                70,
                80,
                38,
                25
        ));
        Collections.shuffle(listaEdad);

        return listaEdad;
    }

    public static ArrayList arrayDinero() {
        ArrayList<Integer> listaDinero = new ArrayList(Arrays.asList(
                660,
                300,
                400,
                300,
                700,
                309,
                450,
                360,
                200,
                150,
                800,
                900,
                500,
                440
        ));
        Collections.shuffle(listaDinero);
        return listaDinero;
    }

    public static ArrayList crearPersonas() {
        ArrayList<Persona> personas = new ArrayList();
        ArrayList<String> listaNombres = arrayNombres();
        ArrayList<Integer> listaEdad = arrayEdad();
        ArrayList<Integer> listaDinero = arrayDinero();

        for (int i = 0; i < listaNombres.size(); i++) {
            personas.add(new Persona(listaNombres.get(i), listaEdad.get(i), listaDinero.get(i), false));
        }
        return personas;
    }

    public static void comprarEntradas(Cine c) {
        Iterator<Persona> it = c.getPersonas().iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.getDinero() >= c.getPrecio() && p.getEdad() >= c.getPelicula().getEdadMinima()) {
                p.setEntrada(true);
            }
        }
    }

    public static void acomodarPersonas(Cine c) {
        Iterator<Persona> it = c.getPersonas().iterator();
        while (it.hasNext()) {
            Persona p = it.next();
            if (p.isEntrada() == true) {
                while (estaOcupado(c)) {
                    System.out.println("El ASIENTO ESTA OCUPADO");
                }
                System.out.println("El cliente " + p.getNombre() + " esta sentado");
            }
        }
    }

    public static boolean estaOcupado(Cine c) {
        String[][] sala = c.getSala();
        boolean ocupado = true;
        int randomI = (int) (Math.random() * 8);
        int randomJ = (int) (Math.random() * 6);
        if (" ".equals(sala[randomI][randomJ].substring(2, 3))) {
            ocupado = false;
            sala[randomI][randomJ] = sala[randomI][randomJ].replace(" ", "X");
        }
        c.setSala(sala);
        return ocupado;
    }

}
