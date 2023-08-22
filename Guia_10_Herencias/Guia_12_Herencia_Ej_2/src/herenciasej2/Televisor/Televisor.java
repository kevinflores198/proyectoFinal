package herenciasej2.Televisor;

import herenciasej2.Electrodomestico.Electrodomestico;
import java.util.Scanner;

public class Televisor extends Electrodomestico {

    Scanner leer = new Scanner(System.in);
    private int pulgadas;
    private boolean sintonizador;

    public Televisor() {
    }

    public Televisor(Integer pulgadas, boolean sintonizador) {
        this.pulgadas = pulgadas;
        this.sintonizador = sintonizador;
    }

    public Televisor(Integer pulgadas, boolean sintonizador, double precio, String color, String consumo, double peso) {
        super(precio, color, consumo, peso);
        this.pulgadas = pulgadas;
        this.sintonizador = sintonizador;
    }

    public Integer getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Integer pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isSintonizador() {
        return sintonizador;
    }

    public void setSintonizador(boolean sintonizador) {
        this.sintonizador = sintonizador;
    }

    public void crearTelevisor() {

        System.out.println("\nTelevisor");
        super.crearElectrodomestico();

        System.out.println("Ingrese las pulgadas de la tv");
        int pulgadas = leer.nextInt();
        System.out.println("Tiene sintonizador? true/false");
        sintonizador = leer.nextBoolean();
    }

    @Override
    public Double precioFinal() {

        precio = super.precioFinal();
        
        if (pulgadas > 40) {
            precio *= 1.3;
        }
        if ((sintonizador)) {
            precio += 500d;
        }
        return precio;
    }
}
