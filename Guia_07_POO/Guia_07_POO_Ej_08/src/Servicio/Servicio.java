package Servicio;

import Cadena.Cadena;

public class Servicio {

    public int mostrarVocales(Cadena c) {
        int cont = 0;
        for (int i = 0; i < c.getLargoCadena(); i++) {
            if (c.getFrase().substring(i, i + 1).toUpperCase().equals("A") || c.getFrase().substring(i, i + 1).toUpperCase().equals("E") || c.getFrase().substring(i, i + 1).toUpperCase().equals("I") || c.getFrase().substring(i, i + 1).toUpperCase().equals("O") || c.getFrase().substring(i, i + 1).toUpperCase().equals("U")) {
                cont++;
            }
        }
        return cont;
    }

    public String invertirFrase(Cadena c) {
        String aux = " ";

        for (int i = c.getLargoCadena(); i > 0; i--) {

            if (c.getLargoCadena() == i) {
                aux += c.getFrase().substring(i - 1);
            } else {
                aux += c.getFrase().substring(i - 1, i);
            }
        }

        return aux;
    }

    public int vecesRepetido(Cadena c, String b) {
        int cont = 0;
        for (int i = 0; i < c.getLargoCadena(); i++) {
            if (c.getFrase().substring(i, i + 1).equals(b)) {
                cont++;
            }
        }
        return cont;
    }

    public int compararLongitud(int l, String f) {
        int largo = f.length(), dif;
        dif = l - largo;
        if (dif < 0) {
            return dif * -1;
        }
        return dif;
    }

    public String unirFrases(String f, Cadena c) {

        return c.getFrase() + " " + f;
    }

    public String reemplazar(Cadena c, String l) {
        String f = "";
        for (int i = 0; i < c.getLargoCadena(); i++) {
            if (c.getFrase().substring(i, i + 1).toLowerCase().equals("a")) {
                f += l;
            } else {
                f += c.getFrase().substring(i, i + 1);
            }
        }
        return f;
    }

    public boolean contiene(Cadena c, String l) {

        for (int i = 0; i < c.getLargoCadena(); i++) {
            if (c.getFrase().substring(i, i + 1).toLowerCase().equals(l)) {
                return true;
            }
        }
        return false;
    }
}
