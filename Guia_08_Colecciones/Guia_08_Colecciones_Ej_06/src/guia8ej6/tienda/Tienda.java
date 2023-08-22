package guia8ej6.tienda;

import java.util.HashMap;
import java.util.Map;

public class Tienda {

    private Map<String, Float> p = new HashMap<>();

    public Tienda() {
    }

    public Map<String, Float> getP() {
        return p;
    }

    public void setP(HashMap<String, Float> p) {
        this.p = p;
    }

}
