

package principal;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//este servidor recibe los aviones que ya aterrizaron ,para quitar label de ...
// ... los comboBox de pistas, y ponerlos en los comboBox de Compuertas

public class ServidorControl2 implements Runnable{
    
    gui_ventanaControlador ventana;
    
    public ServidorControl2(gui_ventanaControlador pVentana) {
        ventana = pVentana; // no se si asi esta  bien o si debe ser puntero
        Thread hilo = new Thread(this);
        hilo.start();
    }
    
    public void quitarIDPista(String ID){
            if(ID.equals(ventana.id_label.getText())){
                ventana.id_label.setText("ID");
            }
            else if(ID.equals(ventana.id_label1.getText())){
                ventana.id_label1.setText("ID");
            }
            else if(ID.equals(ventana.id_label2.getText())){
                ventana.id_label2.setText("ID");
            }
            else if(ID.equals(ventana.id_label3.getText())){
                ventana.id_label3.setText("ID");
            }
            else if(ID.equals(ventana.id_label4.getText())){
                ventana.id_label4.setText("ID");
            }
            else if(ID.equals(ventana.id_label5.getText())){
                ventana.id_label5.setText("ID");
            }
            else if(ID.equals(ventana.id_label6.getText())){
                ventana.id_label6.setText("ID");
            }
            else if(ID.equals(ventana.id_label7.getText())){
                ventana.id_label7.setText("ID");
            }
            else if(ID.equals(ventana.id_label8.getText())){
                ventana.id_label8.setText("ID");
            }
            
        }
    
    public void setID(String ID){
            if("ID".equals(ventana.id_compuerta_1.getText())){
                ventana.id_compuerta_1.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_2.getText())){
                ventana.id_compuerta_2.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_3.getText())){
                ventana.id_compuerta_3.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_4.getText())){
                ventana.id_compuerta_4.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_5.getText())){
                ventana.id_compuerta_5.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_6.getText())){
                ventana.id_compuerta_6.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_7.getText())){
                ventana.id_compuerta_7.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_8.getText())){
                ventana.id_compuerta_8.setText(ID);
            }
            else if("ID".equals(ventana.id_compuerta_9.getText())){
                ventana.id_compuerta_9.setText(ID);
            }
            
            
            
        }
    
    @Override
    public void run() {
        try {
            
            
            ServerSocket servidor = new ServerSocket(4300);
            while (true) {
                Socket cliente = servidor.accept();
                DataInputStream recibirMensaje = new DataInputStream(cliente.getInputStream());
                String mensaje = recibirMensaje.readUTF();
                //mensaje ejemplo = 8703_carga_r
                
                
                // quitar de labels GUI cada avion/mensaje ingresado
                quitarIDPista(mensaje);
                
                
                //hace falta que string que se mande contenga atributo pista...
                //quitar pista de pistasEnUso
                //String[] datos = mensaje.split("_");
                //ventana.pistasEnUso.remove("")
                
                //agregar a labels compuerta GUI avion ya aterrizado
                // solo una vez!
                setID(mensaje);
                
                System.out.println("\nelimine "+mensaje+ " de ventana...\n");
            }
            
        }
        catch (Exception e) {
            System.out.println("Fallo la conexion del servidor.");
        }
    }
    
}
