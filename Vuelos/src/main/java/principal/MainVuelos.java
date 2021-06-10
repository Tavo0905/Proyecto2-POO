package principal;

import java.io.IOException;

public class MainVuelos {
    
    public static void main(String[] args) throws IOException{
        /*Cliente cliente = new Cliente();
        
        System.out.println("Iniciando servidor...");
        cliente.iniciarCliente("1235_carga_r");*/
        
        Thread hilo = new hiloAviones();
        hilo.start();
        
    }
    
}
