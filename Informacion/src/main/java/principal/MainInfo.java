package principal;

import java.io.IOException;

public class MainInfo {
    
    public static void main(String[] args) throws IOException{
        BaseDatos datos = new BaseDatos();
        
        ventanaInfo ventana = new ventanaInfo();
        ventana.setVisible(true);
        
        ServidorInfo server = new ServidorInfo(ventana, datos);
        
        Thread hiloInfoVentana = new hiloInfoVentana(ventana, datos);
        hiloInfoVentana.start();
    }
    
}