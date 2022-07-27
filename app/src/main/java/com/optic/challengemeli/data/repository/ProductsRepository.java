package com.optic.challengemeli.data.repository;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.optic.challengemeli.data.model.Product;
import com.optic.challengemeli.data.model.SearchResult;
import com.optic.challengemeli.data.retrofit_api.ApiRequest;
import com.optic.challengemeli.data.retrofit_api.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * CLASE Repository UNO DE LOS COMPONENTES DE MVVM
 * SE COMUNICARA CON EL WEB SERVICE PARA OPERACIONES CRUD (GET)
 * OBTENER LISTA DE PRODUCTOS Y SU DETALLE
 */
public class ProductsRepository {

    private final String TAG = ProductsRepository.class.getSimpleName();
    public final String MERCADO_LIBRE_URL = "https://api.mercadolibre.com/"; // BASE URL
    private ApiRequest apiRequest;

    public ProductsRepository() {
        apiRequest = RetrofitInstance.getClientObject(MERCADO_LIBRE_URL).create(ApiRequest.class);
    }

    /*
     * ENVIA LA PETICION PARA BUSCAR PRODUCTOS Y DEVUELVE LA DATA OBTENIDA EN LA RESPUESTA
     */
    public LiveData<SearchResult> getProductsBySearch(String searchText) {
        final MutableLiveData<SearchResult> data = new MutableLiveData<>();
        apiRequest.getProductsBySearch(searchText).enqueue(new Callback<SearchResult>() {
                @Override
                public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                    Log.d(TAG, "Response:: " + response);
                    if (response.body() != null) {
                        Log.d(TAG, "RESPONSE BODY: " + response.body().toString());
                        data.setValue(response.body()); // ESTABLECEMOS ENVIAMOS LA DATA OBTENIDA PARA RETORNARLA
                    }
                }

                @Override
                public void onFailure(Call<SearchResult> call, Throwable t) {
                    Log.d(TAG, "Error method getProductsBySearch(): " + t.getMessage());
                    data.setValue(null); // ENVIA NULO EN CASO DE QUE LA RESPUESTA FALLE
                    call.cancel();
                }
            }
        );
        return data;
    }

    /*
     * ENVIA LA PETICION PARA BUSCAR UN PRODUCTO POR SU ID Y DEVUELVE LA DATA OBTENIDA EN LA RESPUESTA
     */
    public LiveData<Product> getProductById(String idProduct) {
        final MutableLiveData<Product> data = new MutableLiveData<>();
        apiRequest.getProductById(idProduct).enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, Response<Product> response) {
                    Log.d(TAG, "Response:: " + response);
                    if (response.body() != null) {
                        Log.d(TAG, "RESPONSE BODY: " + response.body().toString());
                        data.setValue(response.body()); // ESTABLECEMOS ENVIAMOS LA DATA OBTENIDA PARA RETORNARLA
                    }
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                    Log.d(TAG, "Error method getProductById(): " + t.getMessage());
                    data.setValue(null); // ENVIA NULO EN CASO DE QUE LA RESPUESTA FALLE
                    call.cancel();
                }
            }
        );
        return data;
    }

}
