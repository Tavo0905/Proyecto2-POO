package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorInfo implements Runnable {
    
    ventanaInfo ventana;
    ArrayList<Avion> aviones = new ArrayList<>();
    
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
                insercionLabel(mensaje);
                Thread.sleep(500); // Evita un ciclo infinito continuo
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
    
    public void insercionLabel(String mod) {
        if (mod.contains("pista")) {
            mod = mod.replace(mod.substring(0, mod.indexOf("_") + 3), "");
            for (Avion elemento: aviones) {
                if (mod.equalsIgnoreCase(elemento.IDAvion)) {
                    String temp = ventana.jTextArea1.getText();
                    temp = temp.replace(elemento.IDAvion + "    |    " + elemento.estado, elemento.IDAvion + "    |    " + "Aterrizando");
                    ventana.jTextArea1.removeAll();
                    ventana.jTextArea1.append(temp);
                }
            }
        }
        else {
            Avion avionLlegada = new Avion(mod);
            aviones.add(avionLlegada);
            ventana.jTextArea1.append(avionLlegada.IDAvion + "    |    " + avionLlegada.estado + "\n");
        }
    }
}
