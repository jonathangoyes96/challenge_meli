package com.optic.challengemeli.data.model;

import com.google.gson.annotations.SerializedName;

/*
 * INFORMACION DE UNA SUGERENCIA DE BUSQUEDA ENCONTRADA
 */
public class Suggestion {

    @SerializedName("q")
    String name; // Nombre de la sugerencia de busqueda

    public Suggestion() {
    }

    public Suggestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
