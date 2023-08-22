
package excepcionesej1.entidades;

import java.util.Arrays;

/*
Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
*/

public class array {

    private int [] array;

    public array() {
        this.array = new int[]{1, 2, 3, 4, 5};
    }

    public array(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "array{" + "array=" + Arrays.toString(array) + '}';
    }
    
}
