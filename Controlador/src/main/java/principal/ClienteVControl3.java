
package principal;

import java.io.DataOutputStream;
import java.net.Socket;

//envía ID_Avion + compuerta a ventanaControlador, para limpiar labels compuerta
public class ClienteVControl3 {
    
    public ClienteVControl3(String mensaje) {
        try {
            Socket socket = new Socket("127.0.0.1", 2226);
            DataOutputStream enviarMensaje = new DataOutputStream(socket.getOutputStream());
            
            enviarMensaje.writeUTF(mensaje);
            
            socket.close();      
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
