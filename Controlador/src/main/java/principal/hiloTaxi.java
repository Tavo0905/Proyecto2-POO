

package principal;

//se encarga de revisar aviones en arrayList avionesTaxi, irles disminuyendo
//el contador, y si alguno llega a 0, mandar esa info a ventanaCont para 
//sacarlo de labels de compuerta!

public class hiloTaxi extends Thread{
    
        BaseDatos datos;
        
        //2226 
        ClienteVControl3 socketClient;
    
        hiloTaxi(BaseDatos pDatos){
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
                if(datos.avionesTaxi!=null)
                {
                    //sleep 1 segundo (tick tiempo)
                    try
                    {
                    Thread.sleep(1000); // cada segundo de la máquina 
                    }catch (InterruptedException ie)
                        {
                            System.out.println("error!");
                        }
                
                    for (Avion avion : datos.avionesTaxi)
                    {
                    //si ya tiene compuerta asignada:
                    if(avion.compuerta!="")
                        {
                        
                        //si es 0 quedese ahi -.-
                        if(avion.contadorTaxi!=0){
                            System.out.println("\n"+avion.ID_Tipo+"  tiempo:  "+String.valueOf(avion.contadorTaxi));
                            avion.contadorTaxi--;
                        }
                            
                        
                        else if(avion.contadorTaxi==0)
                            {
                            //ID_Tipo en este momento = 8703_carga_r
                                
                            //cliente y enviarlo a ventana control 
                            socketClient = new ClienteVControl3(avion.ID_Tipo);
                            //sacarlo, ir limpiando...
                            
                            //modificarlo o sacarlo del list me tiraba..
                            // ... concurrent modification exception
                            
                            //avion.enPuerta = true;
                            
                            
                            
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