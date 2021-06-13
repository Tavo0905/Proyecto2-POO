package principal;

import java.io.IOException;

public class MainControlador {
    
    public static void main(String[] args) throws IOException { 
        BaseDatos datos = new BaseDatos();
        ServidorVuelos server = new ServidorVuelos(datos);
        
        //recibe desde ventana Control cuando se selecciona una pista
        ServidorVControl serverVentanaCont = new ServidorVControl(datos);
    }
}
