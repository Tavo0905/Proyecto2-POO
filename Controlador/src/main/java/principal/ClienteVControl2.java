
package principal;

import java.io.DataOutputStream;
import java.net.Socket;




public class ClienteVControl2 {
    
    public ClienteVControl2(String mensaje) {
        try {
            Socket socket = new Socket("127.0.0.1", 4300);
            DataOutputStream enviarMensaje = new DataOutputStream(socket.getOutputStream());
            
            enviarMensaje.writeUTF(mensaje);
            
            socket.close();      
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
