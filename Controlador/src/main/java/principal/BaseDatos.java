package principal;

import java.util.ArrayList;

public class BaseDatos {
    
    static public ArrayList <String> IDAviones;
    //static public ArrayList <String> IDAvionesControl;
    static public ArrayList <Avion> aterrizando;
    
    //copia para no eliminar de IDAviones original cuando mandemos a ventana
    static public ArrayList <String> copia_ID_aterrizando;
    
    public BaseDatos() {
        IDAviones = new ArrayList<>();
        //IDAvionesControl = new ArrayList<>();
        aterrizando = new ArrayList<>();
        copia_ID_aterrizando = new ArrayList<>();
    }
    
    
}
