package com.optic.challengemeli.data.model;

import java.util.ArrayList;

/*
 * CLASE QUE CONTIENE LA INFORMACION DEL RESULTADO DE LA BUSQUEDA DE UN PRODUCTO
 */
public class SearchResult {
    public String site_id;
    public String country_default_time_zone;
    public String query;
    public Paging paging;
    public ArrayList<ProductResult> results; // LISTA DE LOS PRODUCTOS ENCONTRADOS

    public SearchResult() {
    }

    public SearchResult(String site_id, String country_default_time_zone, String query, Paging paging, ArrayList<ProductResult> results) {
        this.site_id = site_id;
        this.country_default_time_zone = country_default_time_zone;
        this.query = query;
        this.paging = paging;
        this.results = results;
    }

    public String getSite_id() {
        return site_id;
    }

    public void setSite_id(String site_id) {
        this.site_id = site_id;
    }

    public String getCountry_default_time_zone() {
        return country_default_time_zone;
    }

    public void setCountry_default_time_zone(String country_default_time_zone) {
        this.country_default_time_zone = country_default_time_zone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public ArrayList<ProductResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<ProductResult> results) {
        this.results = results;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "site_id='" + site_id + '\'' +
                ", country_default_time_zone='" + country_default_time_zone + '\'' +
                ", query='" + query + '\'' +
                ", paging=" + paging +
                ", results=" + results +
                '}';
    }
}