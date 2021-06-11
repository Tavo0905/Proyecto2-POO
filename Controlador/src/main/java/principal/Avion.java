
package principal;

import java.util.Random;

public class Avion {
    String ID_Tipo;
    
    // ya no ocupa tiempo de llegada ni id al estar en controlador
    //public static int id = 0;
    //int tiempoLlegada; 

    int contadorAterrizaje;
    
    Avion(String ID){

        ID_Tipo = ID; // lo recibe por parametro
        
        //tiempos de llegada podran estar en cierto rango, escogimos [1-35]seg. 
        Random rand = new Random();
                      //rand.nextInt((max - min) + 1) + min;
        contadorAterrizaje = rand.nextInt((35 - 1) + 1) + 1;
        //lo empezaremos a decrementar cuando se le seleccione una pista
    }

    int getTiempo(){
        return this.contadorAterrizaje;
    }
}
