package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
    
    gui_ventanaControlador ventana;
    
    public Servidor(gui_ventanaControlador pVentana) {
        ventana = pVentana; // no se si asi esta  bien o si debe ser puntero
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    public void setearID(String ID){
            if("ID".equals(ventana.id_label.getText())){
                ventana.id_label.setText(ID);
            }
            else if("ID".equals(ventana.id_label1.getText())){
                ventana.id_label1.setText(ID);
            }
            else if("ID".equals(ventana.id_label2.getText())){
                ventana.id_label2.setText(ID);
            }
            else if("ID".equals(ventana.id_label3.getText())){
                ventana.id_label3.setText(ID);
            }
            else if("ID".equals(ventana.id_label4.getText())){
                ventana.id_label4.setText(ID);
            }
            else if("ID".equals(ventana.id_label5.getText())){
                ventana.id_label5.setText(ID);
            }
            
        }
    
    @Override
    public void run() {
        try {
            //gui_ventanaControlador ventana = new gui_ventanaControlador();
            //ventana.setVisible(true);
            
            ServerSocket servidor = new ServerSocket(8888);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                
                // asignar a los labels de GUI cada mensaje ingresado
                setearID(mensaje);
                System.out.println("\nagregue "+mensaje+ " a ventana...\n");
            }
            
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
