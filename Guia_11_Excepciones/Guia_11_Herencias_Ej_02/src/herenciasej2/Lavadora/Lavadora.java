package herenciasej2.Lavadora;

import herenciasej2.Electrodomestico.Electrodomestico;
import java.util.Scanner;

public class Lavadora extends Electrodomestico {

    Scanner leer = new Scanner(System.in);

    private Double carga = 0d;

    public Lavadora() {
    }

    public Lavadora(Double carga) {
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Lavadora(double precio, String color, String consumo, double peso) {
        super(precio, color, consumo, peso);
    }

    public void crearLavadora() {

        System.out.println("Lavadora");
        
        super.crearElectrodomestico();

        System.out.println("Ingrese la carga de la lavadora:");

        carga = leer.nextDouble();
    }

    @Override
    public Double precioFinal() {
        
        precio = super.precioFinal();
        if (carga > 30) {
            precio += 500d;
        }
        return precio;
    }

}
