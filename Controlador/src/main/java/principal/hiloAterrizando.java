
package principal;


import java.util.concurrent.Semaphore;

//se encarga de revisar aviones en arrayList Aterrizando, irles disminuyendo
//el contador, y si alguno llega a 0, mandar esa info a ventanaCont para 
//sacarlo de labels de pista , y meterlo en labels de Compuerta salida!

public class hiloAterrizando extends Thread{
    
        BaseDatos datos;
        
        //4300 
        ClienteVControl2 socketClient;
        
        Semaphore mutex;
    
        hiloAterrizando(BaseDatos pDatos,Semaphore pMutex){
            datos = pDatos;
            mutex=pMutex;
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
                
                    try{
                        mutex.acquire();
                        try{
                            for (Avion avion : datos.aterrizando)
                    {
                    //si ya tiene pista asignada:
                    if(avion.pista!="")
                        {
                        
                        //si es 0 quedese ahi -.-
                        if(avion.contadorAterrizaje!=0){
                            System.out.println("\n"+avion.ID_Tipo+"  tiempo:  "+String.valueOf(avion.contadorAterrizaje));
                            avion.contadorAterrizaje--;
                        }
                            
                        
                        else if(avion.contadorAterrizaje==0)
                            {
                            //ID_Tipo en este momento = 8703_carga_r
                                
                            //para que solo se agregue una vez cada avion
                            if(!datos.avionesTaxi.contains(avion)){
                                //meter avion a arraylist avionesTaxi (solo 1 vez)
                                datos.avionesTaxi.add(avion);
                                
                                //cliente y enviarlo a ventana control 
                                socketClient = new ClienteVControl2(avion.ID_Tipo);
                            }
                            
                            }
                        
                        }
                    } 
                        }finally{
                            mutex.release();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
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
