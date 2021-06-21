

package principal;



//envia avion con compuerta seleccionada a controlador
public class hilo_id_compuerta extends Thread {

        Cliente2 socketClient;
        
        gui_ventanaControlador ventana;
        
        public hilo_id_compuerta(gui_ventanaControlador pVentana){
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
        
        
        
        while(!ventana.puertas_ID.isEmpty())
            {   
                //enviar la info , socket = 2114 envía a controlador
                socketClient = new Cliente2(ventana.puertas_ID.get(0));
                //sacar info recien enviada de la lista para ir despejando
                ventana.puertas_ID.remove(0);
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