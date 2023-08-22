package excepcionesej3.entidades;

public class DivisionNumero {

    private String num1;
    private String num2;

    public DivisionNumero() {
    }

    public DivisionNumero(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "numero 1 = " + num1 + " / numero 2 = " + num2;
    }

}
