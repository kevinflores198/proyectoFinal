    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Andrés
 */
public class ObjArreglo {
    private double arreglo1[]= new double[50];
    private double arreglo2[]= new double [20];

    public ObjArreglo() {
    }

    public ObjArreglo(double[] arreglo1, double[] arreglo2) {
        this.arreglo1 = arreglo1;
        this.arreglo2 = arreglo2;
    }

    public double[] getArreglo1() {
        return arreglo1;
    }

    public void setArreglo1(double[] arreglo1) {
        this.arreglo1 = arreglo1;
    }

    public double[] getArreglo2() {
        return arreglo2;
    }

    public void setArreglo2(double[] arreglo2) {
        this.arreglo2 = arreglo2;
    }

    @Override
    public String toString() {
        return "ObjArreglo{" + "arreglo1=" + arreglo1 + ", arreglo2=" + arreglo2 + '}';
    }
    
}
