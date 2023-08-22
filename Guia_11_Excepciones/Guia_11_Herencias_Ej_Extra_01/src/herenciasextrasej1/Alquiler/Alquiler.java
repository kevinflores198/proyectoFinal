package herenciasextrasej1.Alquiler;

import herenciasextrasej1.Barco.Barco;
import java.time.Duration;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Alquiler {

    protected String nombre;
    protected int documentoDelCliente;
    protected LocalDate fechaDeAlquiler;
    protected LocalDate fechaDeDevolucion;
    protected String posicionDeAmarre;
    protected Barco barco;

    public Alquiler() {
    }

    public Alquiler(String nombre, int documentoDelCliente, LocalDate fechaDeAlquiler, LocalDate fechaDeDevolucion, String posicionDeAmarre, Barco barco) {
        this.nombre = nombre;
        this.documentoDelCliente = documentoDelCliente;
        this.fechaDeAlquiler = fechaDeAlquiler;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.posicionDeAmarre = posicionDeAmarre;
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumentoDelCliente() {
        return documentoDelCliente;
    }

    public void setDocumentoDelCliente(int documentoDelCliente) {
        this.documentoDelCliente = documentoDelCliente;
    }

    public LocalDate getFechaDeAlquiler() {
        return fechaDeAlquiler;
    }

    public void setFechaDeAlquiler(LocalDate fechaDeAlquiler) {
        this.fechaDeAlquiler = fechaDeAlquiler;
    }

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(LocalDate fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public String getPosicionDeAmarre() {
        return posicionDeAmarre;
    }

    public void setPosicionDeAmarre(String posicionDeAmarre) {
        this.posicionDeAmarre = posicionDeAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    /*
Un alquiler se calcula multiplicando el número de días de ocupación (calculado con la fecha de
alquiler y devolución), por un valor módulo de cada barco (obtenido simplemente
multiplicando por 10 los metros de eslora).
En los barcos de tipo especial el módulo de cada barco se calcula sacando el módulo normal y
sumándole el atributo particular de cada barco. En los veleros se suma el número de mástiles,
en los barcos a motor se le suma la potencia en CV y en los yates se suma la potencia en CV y
el número de camarotes.
Utilizando la herencia de forma apropiada, deberemos programar en Java, las clases y los
métodos necesarios que permitan al usuario elegir el barco que quiera alquilar y mostrarle el
precio final de su alquiler.
     */
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void calcularDiasAlquiler() {

        LocalDate fechaInicial = LocalDate.now();//dia de hoy

        System.out.println("Fecha de alquiler: " + fechaInicial);

        fechaInicial = fechaDeAlquiler;

        System.out.println("\nIngrese fecha de devolucion: \n");

        System.out.println("año");
        int year = leer.nextInt() - 1900;

        System.out.println("mes");
        int mes = leer.nextInt() - 1;

        System.out.println("dia");
        int dia = leer.nextInt();

        LocalDate fechaFinal = LocalDate();

        Duration resultadoDias = Duration.between(fechaInicial, fechaFinal);
        System.out.println("Los dias de alquiler son: " + resultadoDias.toDays());

        Period resultDias = Period.between(fechaDeAlquiler, fechaDeDevolucion);
        System.out.println("Los dias de alquiler son: " + resultDias);

        /*
        System.out.println("Cuantos metros de eslora necesita?");

        barco.setEsloraEnMetros(leer.nextInt());

        System.out.println("El precio es: " + resultado * barco.getEsloraEnMetros());

        

        static void calculatePeriod(LocalDate startDate,
        LocalDate endDate)
    {
        Period period = Period.between(startDate, endDate);
        System.out.println("Period between start and end "
        + "date is : " + period);
    }
         */
    }

}
