/*
 * Clase Revolver de agua: esta clase posee los siguientes atributos: posición
 * actual (posición del tambor que se dispara, puede que esté el agua o no) y
 * posición agua (la posición del tambor donde se encuentra el agua). Estas dos
 * posiciones, se generarán aleatoriamente.
 */
package relacionesej2.Atributos;

public class Revolver {

    private int posicionActual; //posicion del tambor que se dispara, este el agua o no
    private int posisionAgua; //donde esta el agua.

    public Revolver() {
    }

    public Revolver(int posicionActual, int posisionAgua) {
        this.posicionActual = posicionActual;
        this.posisionAgua = posisionAgua;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosisionAgua() {
        return posisionAgua;
    }

    public void setPosisionAgua(int posisionAgua) {
        this.posisionAgua = posisionAgua;
    }

    @Override
    //• toString(): muestra información del revolver (posición actual y donde está el agua)
    public String toString() {
        return "\nPosicion Actual: " + posicionActual + "\nPosision del agua: " + posisionAgua;
    }

    public void llenarRevolver() {
    posicionActual = (int) (Math.random() * 6 + 1);
    posisionAgua = (int) (Math.random() * 6 + 1);
        System.out.println("Estos son los valores iniciales");
        System.out.println("posision de la vala");
        System.out.println("[" + getPosicionActual() + "]");
        System.out.println("Posision del chorro");
        System.out.println("[" + getPosisionAgua() + "]");
    }


    /*
    • mojar(): devuelve true si la posición del agua coincide con la posición actual
     */
    public boolean mojar() {

        if (getPosicionActual() == getPosisionAgua()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    • siguienteChorro(): cambia a la siguiente posición del tambor
     */
    public void siguienteChorro() {
        int revolverr = getPosicionActual();
        if (getPosicionActual() != getPosisionAgua()) {
            revolverr++;
        } else {
            System.out.println("Mojado");
        }
    }
/*
    Como se ve en el main
    */
    public void dibujoRevolver() {
        switch (getPosicionActual()) {
            case 1:
                System.out.println("  x");
                System.out.println("0  0");
                System.out.println("0   0");
                System.out.println("  0");
                break;
            case 2:
                System.out.println("  0");
                System.out.println("0  x");
                System.out.println("0   0");
                System.out.println("  0");
                break;
            case 3:
                System.out.println("  0");
                System.out.println("0  0");
                System.out.println("0   x");
                System.out.println("  0");
                break;
            case 4:
                System.out.println("  0");
                System.out.println("0  0");
                System.out.println("0   0");
                System.out.println("  x");
                break;
            case 5:
                System.out.println("  0");
                System.out.println("0  0");
                System.out.println("x   0");
                System.out.println("  0");
                break;
            case 6:
                System.out.println("  0");
                System.out.println("x  0");
                System.out.println("0   0");
                System.out.println("  0");
                break;
        }
    }

}
