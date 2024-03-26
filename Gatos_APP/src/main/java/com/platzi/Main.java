package com.platzi;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int opcion_menu = -1;
        String [] botones = {"1. ver gatos", "2. ver favoritos", "3. salir."};

        do {
            //Menu principal
            String opcion = (String) JOptionPane.showInputDialog(null,"Gatos Java","Menu Principal",JOptionPane.INFORMATION_MESSAGE,
                    null, botones,botones[0]);

            //Validamos que opcion seleciona el usuario.
            for (int i = 0; i < botones.length; i++) {
                //ciclo donde va a recorrer el array de botones ("1. ver gatos", "2. salir.");
                if (opcion.equals(botones[i])){
                    opcion_menu = i;
                }
            }
            switch (opcion_menu){
                case 0:
                    GatosService.verGatos();
                    break;
                case 1:
                    //para solicitarlo debemos tener la api key
                    Gatos gato = new Gatos();//instanciar clase gato
                    GatosService.verFavorito(gato.getApikey());
                default:
                    break;
            }

        }while(opcion_menu != 1);

    }
}