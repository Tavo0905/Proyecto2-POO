package principal;

import java.util.ArrayList;

public class BaseDatos {
    
    static public ArrayList <String> IDAviones;
    static public ArrayList <String> IDAvionesControl;
    static public ArrayList <Avion> aterrizando;
    
    public BaseDatos() {
        IDAviones = new ArrayList<>();
        IDAvionesControl = new ArrayList<>();
        aterrizando = new ArrayList<>();
    }
    
    
}
