package principal;

import java.io.IOException;

public class MainControlador {
    
    public static void main(String[] args) throws IOException { 
        BaseDatos datos = new BaseDatos();
        
        //recibe los aviones recien creados en vuelos
        ServidorVuelos server = new ServidorVuelos(datos);
        
        //recibe desde ventana Control cuando se selecciona una pista
        ServidorVControl serverVentanaCont = new ServidorVControl(datos);
        
        //hilo que revisa aterrizando para ver si alguno ya aterrizó
        hiloAterrizando hilo4 = new hiloAterrizando(datos);
        hilo4.start();
    }
}
