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
                ClienteInfo enviarInfo = new ClienteInfo(mensaje);
                String[] id = mensaje.split("_");
                String pista = id[0]+"_"+id[1];
                String numeroAvion = id[2];
                
                for (Avion avion : datos.aterrizando){
                    String[] datos = avion.ID_Tipo.split("_");
                    if(numeroAvion.equals(datos[0])){
                        System.out.println("\navion encontrado, agregando datos... ");
                        avion.pista = pista;
                        System.out.println("\npista agregada, iniciando aterrizaje");
                        
                        
                    }
                }
                
                //disminucion de contador aterrizaje se hará con
                //hiloAterrizando (Controlador)
                
                
                System.out.println("===============================\n");
            }
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
