package java. com.platzi;

import com.google.gson.Gson;
import com.platzi.Gatos;
import com.squareup.okhttp.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

public class GatosService {
    public static void verGatos() throws IOException {
        //1 traemos los datos de la API
        OkHttpClient client = new OkHttpClient();
        /*MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");*/
        Request request = new Request.Builder().url("https://api.thecatapi.com/v1/images/search").method("GET", null).build();
        Response response = client.newCall(request).execute();

        //elJSON ES LA VARIABLE QUE NOS DA LA RESPUESTA donde guardamos la respuesta(response)
        String elJson = response.body().string();

        //CORTAR LOS CORCHETES INICIAL Y FINAL, del formato que viene de postman.
        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        //Creamos un objeto de la clase Gson
        Gson gson = new Gson();
        //convertir esa respuesta de la api a un objeto de tipo gatos, Gatos.class es la clase con la que parceamos, y es nuestra clase compilada
//NOS PERMITE MANIPULAR los parametros que vienen desde la api, con los que tenemos en la clase GATOS(id, url, apikey,image)
        Gatos gatos = gson.fromJson(elJson,Gatos.class);

        //redimensionando la imagen en caso de ser muy grandes.Estandarizamos el tamaño.
        Image image = null; //objeto de tipo Image
        try {
            URL url = new URL(gatos.getUrl()); //obtenemos el tipo de URL y le pasamos la url del gato con el get
            //convierte la url que traemos de la api y la convierte en una imagen.
            //image = ImageIO.read(url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.addRequestProperty("User-Agent", "");
            BufferedImage bufferedImage = ImageIO.read(http.getInputStream());
            //la clase JOPTIONPANE recibe un parametro imagen de tipo icon y esterecibe como parametro image.
            ImageIcon fondoGato = new ImageIcon(bufferedImage);
            //validacion dela imagen que recibe.
            if(fondoGato.getIconWidth()>800){
                //redimensionar la image
                Image fondo = fondoGato.getImage();
                //tipo de redimencionado a usar es Image.SCALE_SMOOTH
                Image modificada = fondo.getScaledInstance(800,600, Image.SCALE_SMOOTH);
                //le pasamos a imageIcon la imagen modifica y con esto la imagen queda con las medidas asignadas.
                fondoGato = new ImageIcon(modificada);
            }

            //Creando el menu
            String menu = "Opciones: \n"
                    +"1. Ver Otra imagen \n"
                    +"2. favorito \n"
                    +"3. volver \n";

            //creamos un array de tipo string
            String [] botones = {"ver otra imagen","favorito","volver"};
            //guardamos el id del gato en un string, donde estamos convirtiendo el id del gato a un String
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null,menu,id_gato,JOptionPane.INFORMATION_MESSAGE,fondoGato,botones,botones[0]);

            int seleccion = -1;
            //validamos que opcion selecciona el usuario
            for (int i = 0; i < botones.length; i++) {
                if (opcion.equals(botones[i])){
                    seleccion = i;
                }
            }

            switch (seleccion){
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                    break;
                default:
                    break;
            }

        }catch (IOException e){
            System.out.println(e);
        }

    }
    //creamos el metodo favorito Gato: este metodo recibe los datos que el usuario vio y lo marca como favorito en la api de catapi

    public static void favoritoGato(Gatos gato){
        try {
            OkHttpClient client = new OkHttpClient().build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n    \"image_id\":\""+gato.getId()+"\"\n}");
            Request request = new Request.Builder()
                    .url("https://api.thecatapi.com/v1/favourites")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("x-api-key", gato.getApikey())
                    .build();
            Response response = client.newCall(request).execute();

        }catch (IOException e){
            System.out.println(e);
        }
    }
}
