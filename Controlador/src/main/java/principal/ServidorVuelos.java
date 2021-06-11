package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorVuelos implements Runnable {
    
    BaseDatos datos;
    
    public ServidorVuelos(BaseDatos pBase) {
        //datos = new BaseDatos();
        datos = pBase;
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket servidor = new ServerSocket(4444);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                //System.out.println(mensaje);
                
                datos.IDAviones.add(mensaje);
                System.out.println(datos.IDAviones);
                
                //crear objeto avion con ese ID, meterlos a "aterrizando"
                Avion nuevo = new Avion(mensaje);
                datos.aterrizando.add(nuevo);
                System.out.println(datos.aterrizando);
                
                
                
                //para mandarlos a ventana control y a ventana informacion
                /*
                if (!datos.IDAviones.isEmpty()){
                    ClienteInfo informacion = new ClienteInfo(datos.IDAviones.get(0));
                    ClienteVControl VentanaC =  new ClienteVControl(datos.IDAviones.remove(0));
                }
                */
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
