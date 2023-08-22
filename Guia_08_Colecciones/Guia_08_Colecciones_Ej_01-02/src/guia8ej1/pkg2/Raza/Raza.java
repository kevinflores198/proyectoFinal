
package guia8ej1.pkg2.Raza;

public class Raza {
    
        private String raza;

    public Raza(String raza) {
        this.raza = raza;
    }

    public Raza() {
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Raza = " + raza;
    }
}
