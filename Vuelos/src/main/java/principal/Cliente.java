package principal;

import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    
    public Cliente(String mensaje) {
        try {
            Socket socket = new Socket("127.0.0.1", 4444);
            DataOutputStream enviarMensaje = new DataOutputStream(socket.getOutputStream());
            
            enviarMensaje.writeUTF(mensaje);
            
            socket.close();      
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
