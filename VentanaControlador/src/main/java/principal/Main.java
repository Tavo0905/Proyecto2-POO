package principal;

import java.io.IOException;

public class Main {
    //esta es la clase principal de aplicacion ventana Controlador
    
    //server = servidor 1 se encarga de recibir aviones y meterlos a labels ID
    
    
    public static void main(String[] args) throws IOException{
        
        //instancia de ventana para pasarle a servidores/clientes 
        gui_ventanaControlador ventana = new gui_ventanaControlador();
        ventana.setVisible(true);
        
        Servidor server = new Servidor(ventana);
        
        //socket 9999  = ventanaCont -> controlador
        Thread hilo = new hilo_id_pista(ventana);
        hilo.start();
    }
    
}
