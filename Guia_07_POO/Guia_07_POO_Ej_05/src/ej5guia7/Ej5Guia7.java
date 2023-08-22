package ej5guia7;

import Cuenta.Bancaria;
import Servicio.Servicio;

public class Ej5Guia7 {

    public static void main(String[] args) {
        
        Bancaria b = new Bancaria();
        Servicio a = new Servicio();
        
        a.objetoCuenta(b);
        double datos = a.Ingresar(b);
        double dineroRetirar = a.Retiro(datos);
        double extraer = a.extraccionRapida(dineroRetirar);
        double consulta = a.consultarSaldo(extraer);
        a.consultarDatos(b);  
    }
}
