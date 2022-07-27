package com.optic.challengemeli.data.retrofit_api;

import com.optic.challengemeli.data.model.Product;
import com.optic.challengemeli.data.model.SearchResult;
import com.optic.challengemeli.data.model.SuggestionQuery;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*
 * CONTIENE LAS LLAMADAS A LAS RUTAS DONDE SE VAN A ENVIAR LAS PETICIONES
 */
public interface ApiRequest {

    /*
     * OBTENER LISTA DE PRODUCTOS POR TEXTO DE BUSQUEDA
     */
    @GET("sites/MCO/search")
    Call<SearchResult> getProductsBySearch(@Query("q") String searchText);

    /*
     * OBTENER DETALLE DE UN PRODUCTO POR ID
     */
    @GET("items/{id}")
    Call<Product> getProductById(@Path("id") String id);

    /*
     * OBTENER SUGERENCIAS DE BUSQUEDA
     */
    @GET("autosuggest?showFilters=true&limit=6&api_version=2")
    Call<SuggestionQuery> getSearchSuggestions(@Query("q") String searchText);

}
