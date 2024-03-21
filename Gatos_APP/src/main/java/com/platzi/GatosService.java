package com.platzi;

import com.google.gson.Gson;
import com.squareup.okhttp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;

public class GatosService {
    public static void verGatos() throws IOException {
        //1 traemos los datos de la API
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder().url("api.thecatapi.com/v1/images/search").method("GET", null).build();
        Response response = client.newCall(request).execute();

        //elJSON ES LA VARIABLE QUE NOS DA LA RESPUESTA.
        String elJson = response.body().string();

        //CORTAR LOS CORCHETES INICIAL Y FINAL
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        //Creamos un objeto de la clase Gson
        Gson gson = new Gson();
        //convertir esa respuesta de la api a un objeto de tipo gatos, Gatos.class es la clase con la que parceamos, y es nuestra clase compilada
//NOS PERMITE MANIPULAR los parametros que vienen desde la api, con los que tenemos en la clase GATOS(id, url, apikey,image)
        Gatos gatos = gson.fromJson(elJson,Gatos.class);

        //redimensionando la imagen en caso de ser muy grandes.Estandarizamos el tamaño.
        Image image = null;
        try {
            URL url = new URL(gatos.getUrl());
            //convierte la url que traemos de la api y la convierte en una imagen.
            image = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(image);

            if(fondoGato.getIconWidth()>800){
                Image fondo = fondoGato.getImage();
                Image modificada = fondo.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                //con esto la imagen queda modificada.
                fondoGato = new ImageIcon(modificada);
            }

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
