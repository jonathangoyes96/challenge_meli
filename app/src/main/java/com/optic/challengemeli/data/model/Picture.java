package com.optic.challengemeli.data.model;

/*
 * Contiene los atributos pertenecientes a la imagen de un producto
 */
public class Picture{
    public String id;
    public String url;
    public String secure_url;
    public String size;
    public String max_size;
    public String quality;


    public Picture() {
    }

    public Picture(String id, String url, String secure_url, String size, String max_size, String quality) {
        this.id = id;
        this.url = url;
        this.secure_url = secure_url;
        this.size = size;
        this.max_size = max_size;
        this.quality = quality;
    }

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

    public String getSecure_url() {
        return secure_url;
    }

    public void setSecure_url(String secure_url) {
        this.secure_url = secure_url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMax_size() {
        return max_size;
    }

    public void setMax_size(String max_size) {
        this.max_size = max_size;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
