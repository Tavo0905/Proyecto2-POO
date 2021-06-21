/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.io.DataOutputStream;
import java.net.Socket;


public class Cliente2 {
    
    public Cliente2(String mensaje) {
        try {
            Socket socket = new Socket("127.0.0.1", 2114);
            DataOutputStream enviarMensaje = new DataOutputStream(socket.getOutputStream());
            
            enviarMensaje.writeUTF(mensaje);
            
            socket.close();      
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

