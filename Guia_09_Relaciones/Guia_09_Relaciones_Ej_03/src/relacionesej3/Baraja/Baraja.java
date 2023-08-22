/*
Realizar una baraja de cartas españolas orientada a objetos. Una carta tiene un número entre 1
y 12 (el 8 y el 9 no los incluimos) y un palo (espadas, bastos, oros y copas). Esta clase debe
contener un método toString() que retorne el número de carta y el palo. La baraja estará
compuesta por un conjunto de cartas, 40 exactamente.
 */
package relacionesej3.Baraja;

public class Baraja {

    private int[] numeroDeCarta = new int[12];
    private int[] baraja = new int[40];
    private String palo[] = {"oro", "copa", "basto", "espada"};

    
    public Baraja() {
    }

    public int[] getNumeroDeCarta() {
        return numeroDeCarta;
    }

    public void setNumeroDeCarta(int[] numeroDeCarta) {
        this.numeroDeCarta = numeroDeCarta;
    }

    public String[] getPalo() {
        return palo;
    }

    public void setPalo(String[] palo) {
        this.palo = palo;
    }

    public int[] getBaraja() {
        return baraja;
    }

    public void setBaraja(int[] baraja) {
        this.baraja = baraja;
    }

    @Override
    public String toString() {
        return "--------Carta---------\n" + "Numero de carta: " + " \nPalo: " + palo;
    }

}
