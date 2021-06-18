package principal;

import java.io.IOException;

public class Main {
    //esta es la clase principal de aplicacion ventana Controlador
    
    //server = servidor 1 se encarga de recibir aviones y meterlos a labels ID
    
    
    public static void main(String[] args) throws IOException{
        
        //instancia de ventana para pasarle a servidores/clientes 
        gui_ventanaControlador ventana = new gui_ventanaControlador();
        ventana.setVisible(true);
        
        //socket 8888  = Controlador -> ventanaCont (aviones recien llegados)
        Servidor server = new Servidor(ventana);
        
        //socket 4300  = Controlador -> ventanaCont (aviones que ya aterrizaron)
        ServidorControl2 server2 = new ServidorControl2(ventana);
        
        //socket 9999  = ventanaCont -> controlador
        Thread hilo = new hilo_id_pista(ventana);
        
        hilo.start();
    }
    
}
