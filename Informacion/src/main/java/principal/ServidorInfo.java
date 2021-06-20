package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorInfo implements Runnable {
    
    ventanaInfo ventana;
    BaseDatos base;
    
    public ServidorInfo(ventanaInfo ventanaApp, BaseDatos nuevaBase) {
        ventana = ventanaApp;
        base = nuevaBase;
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
                String[] datos = mensaje.split("_");
                if (!datos[0].equalsIgnoreCase("pista") && !datos[0].equalsIgnoreCase("Seleccionar"))
                    base.aviones.add(new Avion(mensaje));
                else if (datos[0].equalsIgnoreCase("pista")){
                    for (Avion elemento: base.aviones) {
                        if (datos[2].equalsIgnoreCase(elemento.IDAvion)) {
                            elemento.pista = datos[1];
                            elemento.estado = "Aterrizando";
                        }
                    }
                }
                System.out.println(base.aviones.size());
                Thread.sleep(500); // Evita un ciclo infinito continuo
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
