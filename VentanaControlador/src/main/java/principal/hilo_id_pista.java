
package principal;


public class hilo_id_pista extends Thread {

        Cliente socketClient;
        
        gui_ventanaControlador ventana;
        
        public hilo_id_pista(gui_ventanaControlador pVentana){
            ventana = pVentana; // no se si asi esta  bien o si debe ser puntero
        }
       
        
        public void detener(){
            this.suspend();
        }
        
        public void continuar(){
            this.resume();
        }
        
        @Override
        public void run()
        {
            
            
        while(!Thread.currentThread().isInterrupted())
    {
        
        
        
        while(!ventana.pistas_ID.isEmpty())
            {   
                //enviar la info
                socketClient = new Cliente(ventana.pistas_ID.get(0));
                //sacar info recien enviada de la lista para ir despejando
                ventana.pistas_ID.remove(0);
            }
            try{
              Thread.sleep(500); // cada segundo de la máquina 
            }catch (InterruptedException ie)
                {
                    System.out.println("error!");
                }
            //System.out.println("me detuvieron...");
    }
        
        
}

}