package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorInfo implements Runnable {
    
    ventanaInfo ventana;
    
    public ServidorInfo(ventanaInfo ventanaApp) {
        ventana = ventanaApp;
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
                ventana.jTextArea1.append(mensaje + "\n");
                Thread.sleep(500); // Evita un ciclo infinito continuo
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
