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
                for (int i = 0; i < base.aviones.size(); i++) {
                    Avion elemento = base.aviones.get(i);
                    System.out.println(elemento.IDAvion + ", " + elemento.estado + ", " + elemento.contadorInformacion + ", " + elemento.contadorCompuerta);
                    if (elemento.estado.equals("Aterrizando")) {
                        if (elemento.contadorInformacion == 1000){
                            elemento.contadorInformacion = 15;
                            aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                        }
                        else {
                            if (elemento.contadorInformacion > 0) {
                                elemento.contadorInformacion--;
                                aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                            }
                            else if (elemento.contadorInformacion == 0) {
                                elemento.estado = "Taxi";
                                aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                            }
                        }
                    }
                    else if (elemento.estado.equals("Puerta")) {
                        if (elemento.contadorCompuerta == 1000) {
                            elemento.estado = "Puerta";
                            elemento.contadorCompuerta = 20;
                            aux += elemento.IDAvion + "    |    " + elemento.estado + " " + elemento.compuerta + "\n";
                        }
                        else {
                            if (elemento.contadorCompuerta > 0) {
                                elemento.contadorCompuerta--;
                                aux += elemento.IDAvion + "    |    " + elemento.estado + " " + elemento.compuerta + "\n";
                            }
                            else if (elemento.contadorCompuerta == 0) {
                                elemento.estado = "Vuelo terminado";
                                aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                            }
                        
                        }
                    }
                    else
                        aux += elemento.IDAvion + "    |    " + elemento.estado + "\n";
                }
                ventana.jTextArea1.setText("");
                ventana.jTextArea1.append(aux);
                System.out.println("=========================================");
                Thread.sleep(1000);
            }
        }
        catch (Exception e) {
            System.out.println("ERROR EN LA INFORMACION");
        }
    }
    
}
