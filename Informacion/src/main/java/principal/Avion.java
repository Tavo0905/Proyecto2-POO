package principal;

import java.util.Random;

public class Avion {
    String IDAvion, estado, pista, compuerta;
    int contadorAterrizaje;
    
    // ya no ocupa tiempo de llegada ni id al estar en controlador
    //public static int id = 0;
    //int tiempoLlegada; 

    int contadorInformacion;
    
    Avion(String ID){
        IDAvion = ID.substring(0, ID.indexOf("_")); // lo recibe por parametro
        ID = ID.replace(ID.substring(0, ID.indexOf("_") + 1), "");
        ID = ID.replace(ID.substring(0, ID.indexOf("_") + 1), "");
        estado = obtenerEstado(ID);
        pista = "";
        compuerta = "";
        contadorAterrizaje = -1;
    }
    
    String obtenerEstado(String id) {
        if (id.equalsIgnoreCase("r"))
            return "Retrasado";
        else if (id.equalsIgnoreCase("t"))
            return "A Tiempo";
        return "";
    }

    int getTiempo(){
        return this.contadorInformacion;
    }
    
    public void actualizarPista(String id, String nuevaPista) {
        if (IDAvion.equals(id))
            pista = nuevaPista;
    }
}
