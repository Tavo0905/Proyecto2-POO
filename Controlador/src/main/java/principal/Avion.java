
package principal;

import java.util.Random;

public class Avion {
    String ID_Tipo;
    
    // ya no ocupa tiempo de llegada ni id al estar en controlador
    //public static int id = 0;
    //int tiempoLlegada; 

    int contadorAterrizaje;
    int contadorTaxi;
    
    String pista;
    String compuerta;
    
    //representa si ya envié su info de que llegó a compuerta a ventanaControl 
    //boolean enPuerta;
    
    Avion(String ID){

        ID_Tipo = ID; // lo recibe por parametro
        
        //tiempos de llegada podran estar en cierto rango, escogimos [1-35]seg. 
        Random rand = new Random();
                      //rand.nextInt((max - min) + 1) + min;
                      
        //contadorAterrizaje = rand.nextInt((35 - 1) + 1) + 1;
        //lo empezaremos a decrementar cuando se le seleccione una pista
        contadorAterrizaje = 7;
        
        
        //lo empezaremos a decrementar cuando se le seleccione una compuerta
        //(sera el tiempo de traslado desde que aterriza hasta la compuerta)
        contadorTaxi = 9;
        
        
        //se la asignamos cuando venga pista seleccionada desde ventanaCont 
        pista = "";
        
        //se la asignamos cuando venga compuerta seleccionada desde ventanaCont
        compuerta = "";
        
        //enPuerta = false;
    }

    int getTiempo(){
        return this.contadorAterrizaje;
    }
}
