package com.optic.challengemeli.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
/*
 * RESULTADO DE UNA SUGERENCIA DE BUSQUEDA
 */
public class SuggestionQuery{

    @SerializedName("q")
    public String searchText; // Texto de busqueda
    public ArrayList<Suggestion> suggested_queries; // Lista de sugerencias obtenidas

    public SuggestionQuery() {
    }

    public SuggestionQuery(String searchText, ArrayList<Suggestion> suggested_queries) {
        this.searchText = searchText;
        this.suggested_queries = suggested_queries;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public ArrayList<Suggestion> getSuggested_queries() {
        return suggested_queries;
    }

    public void setSuggested_queries(ArrayList<Suggestion> suggested_queries) {
        this.suggested_queries = suggested_queries;
    }
}

