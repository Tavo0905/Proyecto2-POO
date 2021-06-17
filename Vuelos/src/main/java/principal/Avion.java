package principal;

import java.util.Random;

public class Avion {
    String ID_Tipo;
    public static int id = 0;

    int tiempoLlegada;
    

    Avion(){
        String[] tipoAvion = {"carga", "pasajeros", "privados"};
        String[] estadoAvion = {"r", "t"};
        Random rand = new Random();
        ID_Tipo = String.valueOf(rand.nextInt(9999)) + "_" + tipoAvion[rand.nextInt(3)] + "_" + estadoAvion[rand.nextInt(2)];
        //tiempos de llegada podran estar en cierto rango, escogimos [1-35]seg. 
                      //rand.nextInt((max - min) + 1) + min;
        tiempoLlegada = rand.nextInt((35 - 1) + 1) + 1;
        
        
        
        id++;
    }

    int getTiempo(){
        return this.tiempoLlegada;
    }
}