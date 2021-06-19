package principal;

import java.util.ArrayList;

public class hiloInfoVentana extends Thread {
    
    ventanaInfo ventana;
    BaseDatos base;
    
    hiloInfoVentana(ventanaInfo pantalla, BaseDatos baseAux) {
        ventana = pantalla;
        base = baseAux;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String aux = "";
                ArrayList<Avion> copia = (ArrayList<Avion>) base.aviones.clone();
                for (Avion elemento: copia) {
                    System.out.println(elemento.IDAvion + ", " + elemento.estado);
                    if (elemento.estado.equals("Aterrizando"))
                        elemento.contadorInformacion = 15;
                    if (elemento.contadorInformacion > 0)
                        elemento.contadorInformacion--;
                    else if ((elemento.contadorInformacion == 0) && (elemento.estado.equals("Aterrizando"))) {
                        elemento.estado = "Taxi";
                    }
                    aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                }
                ventana.jTextArea1.selectAll();
                System.out.println("Prueba 1");
                ventana.jTextArea1.replaceSelection("");
                System.out.println("Prueba 2");
                ventana.jTextArea1.append(aux);
                System.out.println("Prueba 3");
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR EN LA INFORMACION");
        }
    }
    
}
