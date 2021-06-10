package principal;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class hiloAviones extends Thread {

            Cliente socketClient;
    
     
       
        
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
        
        ArrayList<Avion> aviones = new ArrayList<>();
        //meter al arrayList una cantidad aleatoria entre 1-10 aviones
        Random rand = new Random();
                     //rand.nextInt((max - min) + 1) + min;
        int cantidad = rand.nextInt((10 - 1) + 1) + 1;        
        
        while (cantidad>0)
        {
            Avion aleatorio = new Avion();
            aviones.add(aleatorio);
            cantidad--;
        }
        
        System.out.println(aviones);
        
        while(!aviones.isEmpty())
            {   
            try{
              Thread.sleep(1000); // cada segundo de la máquina 
            }catch (InterruptedException ie)
                {
                    System.out.println("error!");
                }
            for(int i = 0;i<aviones.size();i++)
                    {
                    aviones.get(i).tiempoLlegada--;
                    if(aviones.get(i).tiempoLlegada == 0)
                        {
                            
                     
                        System.out.println("\n ---- salio: ");
                        System.out.println(aviones.get(i));
                        
                        // ENVIAR POR EL SOCKET
                        System.out.println(aviones.get(i).ID_Tipo);
                        socketClient = new Cliente(aviones.get(i).ID_Tipo);
                        
                        


                        //ID de avion seteado en espacio disp. ventana
                        //setearID(aviones.get(i).ID_Tipo);
                        

                        aviones.remove(i);
                        System.out.println("\nquedan: "+String.valueOf(aviones.size()));
                        
                        //si termino la lista de aviones, detener
                        if(aviones.size()==0){
                            this.stop();
                        }

                        
                        }
                    }

            }
        }
            try{
              Thread.sleep(500); // cada segundo de la máquina 
            }catch (InterruptedException ie)
                {
                    System.out.println("error!");
                }
            System.out.println("me detuvieron...");
    }
        
        
}