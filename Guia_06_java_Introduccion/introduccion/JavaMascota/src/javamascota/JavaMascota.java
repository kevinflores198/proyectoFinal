package javamascota;

import javamascota.servicios.ServicioMascota;

public class JavaMascota {

    public static void main(String[] args) {

        
        
        ServicioMascota ser = new ServicioMascota();

        ser.fabricaMascota(2);
        
        ser.mostrarMascotas();
        
        ser.actualizarMascota(1);
        
        ser.mostrarMascotas();
        
        ser.eliminarMascota(0);
        
        ser.mostrarMascotas();
        
    }
}
