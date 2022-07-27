package com.optic.challengemeli.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.optic.challengemeli.R;
import com.optic.challengemeli.adapters.CustomSuggestionsAdapter;
import com.optic.challengemeli.data.model.Suggestion;
import com.optic.challengemeli.view_model.SuggestionsViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/*
 * ACTIVITY DE BUSQUEDA DE PRODUCTO
 */
public class SearchActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener {

    private final String TAG = "SearchActivity";
    private MaterialSearchBar searchBar;
    private CustomSuggestionsAdapter customSuggestionsAdapter;
    private List<String> suggestionsString = new ArrayList<>();
    private SuggestionsViewModel suggestionsViewModel;

    private Timer timer = new Timer();
    private final long DELAY = 1000; // in ms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initUI();
    }

    private void initUI() {
        // Instancia de searchBar y Event Listener de la accion buscar
        searchBar = findViewById(R.id.searchBar);
        searchBar.setOnSearchActionListener(this);

        // Instancia del ViewModel
        suggestionsViewModel = new ViewModelProvider(this).get(SuggestionsViewModel.class);

        // Instancia del adapter que mostrara las sugerencias de busqueda
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        customSuggestionsAdapter = new CustomSuggestionsAdapter(inflater, this);

        // Escuchando los eventos de escritura en el SearchBar
        searchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                timer.cancel(); //Termina el temporizador Terminates this timer,discarding any currently scheduled tasks.
                timer.purge(); // Eliminado todas las tareas que se esten ejecutando para evitar gastos en memoria
            }

            @Override
            public void afterTextChanged(Editable editable) {
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!editable.toString().isEmpty()) {
                            getSuggestions(editable.toString());
                        }
                    }

                }, DELAY);

            }
        });
    }

    /*
     * OBTENER LAS SUGERENCIAS Y MOSTRARLAS EN "SearchBar"
     */
    private void getSuggestions(String searchText) {
        // Como estoy dentro de un temporizador que corre en el hilo principal debo utlizar este metodo para mostrar informacion
        runOnUiThread(() -> {
            suggestionsViewModel.setSuggestionsLiveData(searchText);
            suggestionsViewModel.getSuggestionsLiveData().observe(this, suggestionQuery -> {
                if (suggestionQuery != null) {
                    // Establesco la informacion de las sugerencias encontradas
                    ArrayList<Suggestion> suggestions = suggestionQuery.suggested_queries;
                    if (suggestions.size() > 0) {
                        // Limpiar lista de sugerencias para mostrar la nueva informacion
                        suggestionsString.clear();

                        // LLenando la lista de sugerencias
                        for (Suggestion s: suggestions) {
                            suggestionsString.add(s.getName());
                        }

                        // Mostrando las sugerencias
                        customSuggestionsAdapter.setSuggestions(suggestionsString);
                        searchBar.setCustomSuggestionAdapter(customSuggestionsAdapter);
                        searchBar.showSuggestionsList();
                    }
                    else {
                        // Limpio las sugerencias mostradas
                        searchBar.clearSuggestions();
                    }
                }
                else {
                    // Limpio las sugerencias mostradas
                    searchBar.clearSuggestions();
                }
            });
        });
    }

    /*
     * IR A LA ProductsListActivity
     * @param searchText -> Texto de busqueda enviado como parametro
     */
    private void goToProductsList(String searchText) {
        Intent i = new Intent(this, ProductsListActivity.class);
        i.putExtra("search", searchText);
        startActivity(i);
    }

    /*
     * BARRA DE BUSQUEDA -> EVENTO
     */
    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    /*
     * BARRA DE BUSQUEDA -> EVENTO CUANDO EL USUARIO PRECIONE CLICK SOBRE EL ICONO DE BUSQUEDA
     */
    @Override
    public void onSearchConfirmed(CharSequence text) {
        goToProductsList(text.toString());
    }

    /*
     * BARRA DE BUSQUEDA -> EVENTO SE DISPARA CUANDO UN ACCION ES EFECTUADA - CERRAR - IR HACIA ATRAS
     */
    @Override
    public void onButtonClicked(int buttonCode) {
        Log.d("TEXTO", "EVENTO BUTTON CLICKED: " + buttonCode);
    }


}