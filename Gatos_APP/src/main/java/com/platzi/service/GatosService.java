package com.platzi.service;

import com.google.gson.Gson;

import com.platzi.model.Gatos;
import com.platzi.model.GatosFav;
import okhttp3.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class GatosService {
    private static String BASE_URL = "https://api.thecatapi.com/v1/";
    private static String SEARCH_ENDPOINT = BASE_URL + "images/search";
    private static String FAVORITE_ENDPOINT = BASE_URL + "favourites";
    private static String MenuFavorito = "Opciones: \n"
            + "1. Ver Otra imagen \n"
            + "2. Eliminar favorito \n"
            + "3. volver \n";
    private static String MenuGatosRandom = "Opciones: \n"
            + "1. Ver Otra imagen \n"
            + "2. favorito \n"
            + "3. volver \n";

    public static void verGatos() throws IOException {
        //1 traemos los datos de la API
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(SEARCH_ENDPOINT).get().build();
        Response response = client.newCall(request).execute();

        //elJSON ES LA VARIABLE QUE NOS DA LA RESPUESTA donde guardamos la respuesta(response)
        String DatoJson = response.body().string();
        System.out.println(DatoJson);

        //CORTAR LOS CORCHETES INICIAL Y FINAL, del formato que viene de postman.
        DatoJson = DatoJson.substring(1, DatoJson.length());
        DatoJson = DatoJson.substring(0, DatoJson.length() - 1);

        //Creamos un objeto de la clase Gson
        Gson gson = new Gson();
        //convertir esa respuesta de la api a un objeto de tipo gatos, Gatos.class es la clase con la que parceamos, y es nuestra clase compilada
//NOS PERMITE MANIPULAR los parametros que vienen desde la api, con los que tenemos en la clase GATOS(id, url, apikey,image)
        Gatos gato = gson.fromJson(DatoJson, Gatos.class);

        //redimensionando la imagen en caso de ser muy grandes.Estandarizamos el tamaño.
        Image image = null; //objeto de tipo Image
        try {
            URL url = new URL(gato.getUrl()); //obtenemos el tipo de URL y le pasamos la url del gato con el get
            //convierte la url que traemos de la api y la convierte en una imagen.
//            image = ImageIO.read(url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.addRequestProperty("User-Agent", "");
            BufferedImage bufferedImage = ImageIO.read(http.getInputStream());
            //la clase JOPTIONPANE recibe un parametro imagen de tipo icon y esterecibe como parametro image.
            ImageIcon fondoGato = new ImageIcon(bufferedImage);
            //validacion dela imagen que recibe.
            if (fondoGato.getIconWidth() > 800) {
                //redimensionar la image
                Image fondo = fondoGato.getImage();
                //tipo de redimencionado a usar es Image.SCALE_SMOOTH
                Image modificada = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                //le pasamos a imageIcon la imagen modifica y con esto la imagen queda con las medidas asignadas.
                fondoGato = new ImageIcon(modificada);
            }

            //creamos un array de tipo string
            String[] botones = {"ver otra imagen", "favorito", "volver"};
            //guardamos el id del gato en un string, donde estamos convirtiendo el id del gato a un String
            String id_gato = gato.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, MenuGatosRandom, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);

            int seleccion = -1;
            //validamos que opcion selecciona el usuario
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    seleccion = i;
                }
            }

            switch (seleccion) {
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gato);
                    break;
                default:
                    break;
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
    //creamos el metodo favorito Gato: este metodo recibe los datos que el usuario vio y lo marca como favorito en la api de catapi


    public static void favoritoGato(Gatos gato) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n    \"image_id\":\"" + gato.getId() + "\"\n}");
            Request request = new Request.Builder()
                    .url(FAVORITE_ENDPOINT)
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApikey())
                    .build();
            Response response = client.newCall(request).execute();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    //como parametro enviamos la apikey
    public static void verFavorito(String apikey) throws IOException {
        OkHttpClient client = new OkHttpClient();
        //*MediaType mediaType = MediaType.parse("application/json");
        //RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(FAVORITE_ENDPOINT)
                .get()
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", apikey)
                .build();
        Response response = client.newCall(request).execute();

        //capturamos la respuesta de la peticion a la API, GUARDAR el STRING CON LA RESPUESTA
        String DatoJson = response.body().string();
        System.out.println(DatoJson);


//        if (!response.isSuccessful()) {
//            response.body().close();
//        }

        //creamos el objeto gson
        Gson gson = new Gson();

        //creamos array de tipo gatosfav.
        GatosFav[] gatosArray = gson.fromJson(DatoJson, GatosFav[].class);

        //validamos si el valor del array es mayor a 0
        if (gatosArray.length > 0) {
            int min = 1;
            int max = gatosArray.length;

            //creamos el numero aleatorio
            int aleatorio = (int) (Math.random() * ((max - min) + 1)) + min;

            int indice = aleatorio - 1; //es por que el numero aleatorio debe restarse con 1 para obtener el indice del array donde vamos a sacar la imagen aleatoria del gato.

            //una vez sabiendo que gato vamos a obtener o que indece, creamos gatos fav; seleccionamos un gato al asar.
            GatosFav gatofav = gatosArray[indice];//tomamos un numero aleatorio de todos los indices que hay en el array de gatos, y vamos a meterlo en un objeto de tipo gatosarray y ese lo vamos a mostrar.

            //redimensionando la imagen en caso de ser muy grandes.Estandarizamos el tamaño.
            Image image = null; //objeto de tipo Image
            try {
                URL url = new URL(gatofav.image.getUrl()); //obtenemos el tipo de URL y le pasamos la url del gato con el get
                //convierte la url que traemos de la api y la convierte en una imagen.
                //            image = ImageIO.read(url);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                http.addRequestProperty("User-Agent", "");
                BufferedImage bufferedImage = ImageIO.read(http.getInputStream());
                //la clase JOPTIONPANE recibe un parametro imagen de tipo icon y esterecibe como parametro image.
                ImageIcon fondoGato = new ImageIcon(bufferedImage);
                //validacion dela imagen que recibe.
                if (fondoGato.getIconWidth() > 800) {
                    //redimensionar la image
                    Image fondo = fondoGato.getImage();
                    //tipo de redimencionado a usar es Image.SCALE_SMOOTH
                    Image modificada = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                    //le pasamos a imageIcon la imagen modifica y con esto la imagen queda con las medidas asignadas.
                    fondoGato = new ImageIcon(modificada);
                }

                //creamos un array de tipo string
                String[] botones = {"ver otra imagen", "eliminar favorito", "volver"};
                //guardamos el id del gato en un string, donde estamos convirtiendo el id del gato a un String
                String id_gato = gatofav.getId();
                String opcion = (String) JOptionPane.showInputDialog(null, MenuGatosRandom, id_gato, JOptionPane.INFORMATION_MESSAGE, fondoGato, botones, botones[0]);

                int seleccion = -1;
                //validamos que opcion selecciona el usuario
                for (int i = 0; i < botones.length; i++) {
                    if (opcion.equals(botones[i])) {
                        seleccion = i;
                    }
                }

                switch (seleccion) {
                    case 0:
                        verFavorito(apikey);
                        break;
                    case 1:
                        borrarFavorito(gatofav);
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }

        public static void borrarFavorito (GatosFav gatoFav){
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(FAVORITE_ENDPOINT + gatoFav.getId() + "")
                        .delete()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("x-api-key", gatoFav.getApikey())
                        .build();
                Response response = client.newCall(request).execute();

                if (!response.isSuccessful()) {
                    response.body().close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
}

