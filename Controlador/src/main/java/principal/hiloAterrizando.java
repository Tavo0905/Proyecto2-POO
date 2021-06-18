
package principal;




//se encarga de revisar aviones en arrayList Aterrizando, irles disminuyendo
//el contador, y si alguno llega a 0, mandar esa info a ventanaCont para 
//sacarlo de labels de pista , y meterlo en labels de Compuerta salida!

public class hiloAterrizando extends Thread{
    
        BaseDatos datos;
        
        //4300 
        ClienteVControl2 socketClient;
    
        hiloAterrizando(BaseDatos pDatos){
            datos = pDatos;
            //acordarme de darle .start() en Main, para no ponerlo acá
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
                if(datos.aterrizando!=null)
                {
                    //sleep 1 segundo (tick tiempo)
                    try
                    {
                    Thread.sleep(1000); // cada segundo de la máquina 
                    }catch (InterruptedException ie)
                        {
                            System.out.println("error!");
                        }
                
                    for (Avion avion : datos.aterrizando)
                    {
                    //si ya tiene pista asignada:
                    if(avion.pista!="")
                        {
                        System.out.println("\n"+avion.ID_Tipo+"  tiempo:  "+String.valueOf(avion.contadorAterrizaje));
                        //si es 0 quedese ahi -.-
                        if(avion.contadorAterrizaje!=0)
                           avion.contadorAterrizaje--; 
                        
                        else if(avion.contadorAterrizaje==0)
                            {
                            //ID_Tipo en este momento = 8703_carga_r
                                
                            //cliente y enviarlo a ventana control 
                            socketClient = new ClienteVControl2(avion.ID_Tipo);
                            }
                        
                        }
                    } 
                }
                //sleep 1 segundo (tick tiempo) aun si aterrizando == null
                //(para que no se coma los recursos el loop infinito)
                try
                {
                   Thread.sleep(1000); // cada segundo de la máquina 
                }catch (InterruptedException ie)
                    {
                    System.out.println("error!");
                    }
                
                
            }
                System.out.println("me detuvieron...");
        }//end run()
    
    
}
