package principal;

import java.util.Random;

public class Avion {
    String ID_Tipo;
    public static int id = 0;

    int tiempoLlegada;

    Avion(){

        ID_Tipo = "33"+String.valueOf(id);
        //tiempos de llegada podran estar en cierto rango, escogimos [1-35]seg. 
        Random rand = new Random();
                      //rand.nextInt((max - min) + 1) + min;
        tiempoLlegada = rand.nextInt((35 - 1) + 1) + 1;
        id++;
    }

    int getTiempo(){
        return this.tiempoLlegada;
    }
}