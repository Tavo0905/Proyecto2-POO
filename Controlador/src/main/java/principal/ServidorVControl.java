package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorVControl implements Runnable {
    
    BaseDatos datos;
    
    public ServidorVControl(BaseDatos pBase) {
        datos = pBase;
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(9999);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                System.out.println("\n===============================");
                System.out.println("\nllegando a cont desde ventana : ");
                System.out.println(mensaje);
                System.out.println("===============================\n");
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
