package principal;

import java.util.ArrayList;

public class BaseDatos {
    
    static public ArrayList <String> IDAviones;
    static public ArrayList <Avion> aterrizando;
    //los que ya aterrizaron, y estaran esperando asignacion de compuerta salida
    static public ArrayList <Avion> avionesTaxi;
    
    //copia para no eliminar de IDAviones original cuando mandemos a ventana
    static public ArrayList <String> copia_ID_aterrizando;
    
    public BaseDatos() {
        IDAviones = new ArrayList<>();
        //IDAvionesControl = new ArrayList<>();
        aterrizando = new ArrayList<>();
        copia_ID_aterrizando = new ArrayList<>();
        avionesTaxi= new ArrayList<>();
    }
    
    
}
