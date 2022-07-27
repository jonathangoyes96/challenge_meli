package com.optic.challengemeli.data.retrofit_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * CLASE QUE PERMITE CREAR EL CLIENTE RETROFIT QUE PERMITIRA REALIZAR LAS PETICIONES HTTP AL API
 */
public class RetrofitInstance {

    public static Retrofit getClientObject(String baseURL) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return  retrofit;
    }
}
