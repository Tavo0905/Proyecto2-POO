package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor implements Runnable {
    
    
    public Servidor() {
        Thread hilo = new Thread(this);
        hilo.start();
    }
    /*
    public void setearID(String ID){
            if("".equals(gui_ventanaControlador.id_label.getText())){
                gui_ventanaControlador.id_label.setText(ID);
            }
            else if("".equals(gui_ventanaControlador.id_label1.getText())){
                gui_ventanaControlador.id_label1.setText(ID);
            }
            else if("".equals(gui_ventanaControlador.id_label2.getText())){
                gui_ventanaControlador.id_label2.setText(ID);
            }
            else if("".equals(gui_ventanaControlador.id_label3.getText())){
                gui_ventanaControlador.id_label3.setText(ID);
            }
            else if("".equals(gui_ventanaControlador.id_label4.getText())){
                gui_ventanaControlador.id_label4.setText(ID);
            }
            else if("".equals(gui_ventanaControlador.id_label5.getText())){
                gui_ventanaControlador.id_label5.setText(ID);
            }
            
        }
    */
    @Override
    public void run() {
        try {
            gui_ventanaControlador ventana = new gui_ventanaControlador();
            ServerSocket servidor = new ServerSocket(8888);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                System.out.println(mensaje+" llego a servidor");
                
                // asignar a los labels de GUI cada mensaje ingresado
                
                //por estas 3 lineas se esta yendo a la excepcion... wtf?
                String variable = ventana.id_label.getText();
                System.out.println(variable);
                //System.out.println(gui_ventanaControlador.id_label1.getText());
                //System.out.println(gui_ventanaControlador.id_label2.getText());
                
                System.out.println("\nagregue "+mensaje+ " a ventana...\n");
            }
            
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
}
