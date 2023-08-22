package herenciasej2.Electrodomestico;

import java.util.Scanner;

public abstract class Electrodomestico {

    protected double precio;
    protected String color;
    protected String consumo;
    protected double peso;

    Scanner leer = new Scanner(System.in);

    public Electrodomestico() {
    }

    public Electrodomestico(double precio, String color, String consumo, double peso) {
        this.precio = precio;
        this.color = color;
        this.consumo = consumo;
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }

    public String comprobarConsumoEnergetico() {

        if (!"A".equals(consumo)
                && !"B".equals(consumo)
                && !"C".equals(consumo)
                && !"D".equals(consumo)
                && !"E".equals(consumo)) {
            return "F";
        }
        return consumo;
    }

    public String comprobarColor() {

        if (color.equals("blanco")
                && color.equals("rojo")
                && color.equals("azul")
                && color.equals("gris")
                && color.equals("negro")) {
            return "blanco".toLowerCase();
        }
        return color;
    }

    public void crearElectrodomestico() {
        System.out.println("Ingrese el color: "
                + "blanco"
                + "/ rojo"
                + "/ azul"
                + "/ gris"
                + "/ negro");

        color = leer.next();

        color = comprobarColor();

        System.out.println("Ingrese el consumo energetico: "
                + "\nsegún el consumo energético, aumentará el valor del precio: "
                + "\nA +$1000"
                + "\nB +$800"
                + "\nC +$600"
                + "\nD +$00"
                + "\nE +$300"
                + "\nF +$100");

        consumo = leer.next().toUpperCase();

        consumo = comprobarConsumoEnergetico();

        System.out.println("Ingrese el peso: "
                + "\nsegún el peso, aumentará el valor del precio: "
                + "\n+19 kg +$100"
                + "\nentre 20 y 49 kg +$500"
                + "\nentre 50 y 79 kg +$800"
                + "\nmas que 80 kg +$1000");

        peso = leer.nextDouble();

        precio = 1000d;

    }

    public Double precioFinal() {
        
        switch (consumo) {
            case "A":
                precio += 1000d;
                break;
            case "B":
                precio += 800d;
                break;
            case "C":
                precio += 600d;
                break;
            case "D":
                precio += 500d;
                break;
            case "E":
                precio += 300d;
                break;
            case "F":
                precio += 100d;
                break;
        }

        if (peso <= 19) {
            precio += 100d;
        } else if (peso > 19 && peso <= 49) {
            precio += 500d;
        } else if (peso > 49 && peso <= 79) {
            precio += 800d;
        } else if (peso > 79) {
            precio += 1000d;
        }

        return precio;
    }

}
