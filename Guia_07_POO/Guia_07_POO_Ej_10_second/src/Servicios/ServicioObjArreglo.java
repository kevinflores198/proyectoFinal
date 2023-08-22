/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.ObjArreglo;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Andrés
 */
public class ServicioObjArreglo {
    ObjArreglo Arr = new ObjArreglo();
    Scanner leer = new Scanner (System.in);
    double array1 []=new double[50];
    double array2 []= new double[20];
    double x = 0.5;
    
    public ObjArreglo llenarArreglos(){
        for (int i = 0; i < 50; i++) {
            array1[i]= Math.random()*10;
            
        }
        Arr.setArreglo1(array1);
        System.out.println("Arreglo A original");
        System.out.println(Arrays.toString(Arr.getArreglo1()));
        Arrays.sort(array1);
        
        Arr.setArreglo1(array1);
        System.out.println("Arreglo A ordenado");
        System.out.println(Arrays.toString(Arr.getArreglo1()));
        
        
        Arrays.fill(array2, x);
        for (int i = 0; i < 10; i++) {
            array2[i]=array1[i];
            
        }
        System.out.println("|");
        
        Arr.setArreglo2(array2);
        System.out.println("LOS ARREGLOS");
        System.out.println(Arrays.toString(Arr.getArreglo1()));
        System.out.println(Arrays.toString(Arr.getArreglo2()));
        
        
        
        return Arr;
    }
    
    
}
