package com.platzi.model;

public class Gatos {
    String id;
    String url;
    String apikey = "live_OFqRpUKxbKW41RqavnLLeLLscJpEUzfnmvwOuCZ8M7UwlTyADhNNEwk9Xx9iwq1q";
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
