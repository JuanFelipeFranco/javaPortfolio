package com.platzi.model;

public class GatosFav {
    //parametros para parcear la respuesta
    String id;
    String image_id;
    String apikey = "live_OFqRpUKxbKW41RqavnLLeLLscJpEUzfnmvwOuCZ8M7UwlTyADhNNEwk9Xx9iwq1q";
    public Imagex image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public Imagex getImage() {
        return image;
    }

    public void setImage(Imagex image) {
        this.image = image;
    }
}
