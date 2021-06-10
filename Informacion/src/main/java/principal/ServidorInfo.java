package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorInfo implements Runnable {
    
    public ServidorInfo() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(6666);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                System.out.println(mensaje);
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
