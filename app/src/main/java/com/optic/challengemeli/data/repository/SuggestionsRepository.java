package com.optic.challengemeli.data.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.optic.challengemeli.data.model.Product;
import com.optic.challengemeli.data.model.SearchResult;
import com.optic.challengemeli.data.model.SuggestionQuery;
import com.optic.challengemeli.data.retrofit_api.ApiRequest;
import com.optic.challengemeli.data.retrofit_api.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * CLASE Repository UNO DE LOS COMPONENTES DE MVVM
 * SE COMUNICARA CON EL WEB SERVICE PARA OPERACIONES CRUD (GET)
 * OBTENER SUGERENCIAS DE UNS BUSQUEDA
 */
public class SuggestionsRepository {

    private final String TAG = SuggestionsRepository.class.getSimpleName();
    public final String SUGGESTIONS_URL = "https://http2.mlstatic.com/resources/sites/MCO/"; // BASE URL
    private ApiRequest apiRequest;

    public SuggestionsRepository() {
        apiRequest = RetrofitInstance.getClientObject(SUGGESTIONS_URL).create(ApiRequest.class);
    }

    /*
     * ENVIA LA PETICION PARA ENCONTRAR SUGERENCIAS DE UNA BUSQUEDA LA DATA OBTENIDA EN LA RESPUESTA
     * @param searchText -> Texto de busqueda
     */
    public LiveData<SuggestionQuery> getSearchSuggestions(String searchText) {
        final MutableLiveData<SuggestionQuery> data = new MutableLiveData<>();
        apiRequest.getSearchSuggestions(searchText).enqueue(new Callback<SuggestionQuery>() {
                @Override
                public void onResponse(Call<SuggestionQuery> call, Response<SuggestionQuery> response) {
                    Log.d(TAG, "Response:: " + response);
                    if (response.body() != null) {
                        Log.d(TAG, "RESPONSE BODY: " + response.body().toString());
                        data.setValue(response.body()); // Establecemos la informacion para retornarla
                    }
                }

                @Override
                public void onFailure(Call<SuggestionQuery> call, Throwable t) {
                    Log.d(TAG, "Error method getSearchSuggestions(): " + t.getMessage());
                    data.setValue(null); // Establesco Nulo en caso de que la peticion falle
                    call.cancel();
                }
            }
        );
        return data;
    }

}
