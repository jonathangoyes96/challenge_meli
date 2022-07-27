package com.optic.challengemeli.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.optic.challengemeli.R;
import com.optic.challengemeli.adapters.ProductsFoundAdapter;
import com.optic.challengemeli.data.model.ProductResult;
import com.optic.challengemeli.data.model.SearchResult;
import com.optic.challengemeli.includes.MyToolbar;
import com.optic.challengemeli.network.Network;
import com.optic.challengemeli.view_model.ProductsViewModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsListActivity extends AppCompatActivity {

    private final String TAG = "ProductsListActivity";
    private String extraSearchText;
    private RecyclerView recyclerView;
    private TextView textViewResultQuantity;
    private LinearLayout linearLayoutNoResultFound;
    private LinearLayout noConnectionLayout;
    private Button btnRetryConnecting;
    private ProgressBar progressBar;
    private ProductsFoundAdapter adapter;
    private ProductsViewModel productsViewModel;
    private ArrayList<ProductResult> results = new ArrayList<>(); // arreglo para almacenar los productos encontrados en la peticion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        extraSearchText = getIntent().getStringExtra("search"); // Parametro con el texto de busqueda enviado desde SearchActivity
        initUI();
        getProductsBySearch();
    }

    private void initUI() {
        // Mostrando el toolbar
        MyToolbar.show(this, "Productos", true);

        // Instancia del View Model
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productsViewModel.setProductsBySearchLiveData(extraSearchText);

        // Instancia de las views
        textViewResultQuantity = findViewById(R.id.textViewResultQuantity);
        noConnectionLayout = findViewById(R.id.noConnectionLayout);
        btnRetryConnecting = findViewById(R.id.btnRetryConnecting);
        linearLayoutNoResultFound = findViewById(R.id.linearLayoutNoResultFound);
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerViewProducts);

        // Configurando RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductsFoundAdapter(ProductsListActivity.this, results);
        recyclerView.setAdapter(adapter);

        // RECARGAR INFORMACION
        btnRetryConnecting.setOnClickListener(view -> {
            retryData();
        });
    }

    /**
     * OBTENER LOS PRODUCTOS ENCONTRADOS EN LA BUSQUEDA Y MOSTRARLOS EN EL RECYCLERVIEW
     */
    private void getProductsBySearch() {
        if (Network.checkNetwork(this)) {
            productsViewModel.getProductsBySearchLiveData().observe(this, searchResult -> {
                progressBar.setVisibility(View.GONE);
                if (searchResult != null) {
                    updateUI(searchResult);
                }
            });
        }
        else {
            showNoConnection();
        }
    }

    /*
     * ACTUALIZAR EL UI
     */
    private void updateUI(SearchResult searchResult) {
        textViewResultQuantity.setText(String.valueOf(searchResult.getPaging().total)); // Mostrando la cantidad de resultados obtenidos
        results.addAll(searchResult.results); // estableciendo productos encotrados
        if (results.size() > 0) {
            adapter.notifyDataSetChanged(); // Mostrando los datos
        }
        else {
            linearLayoutNoResultFound.setVisibility(View.VISIBLE); // No se encontraron resultados
        }
    }

    /*
     * MOSTRAR QUE NO HAY CONEXION A INTERNET
     */
    private void showNoConnection() {
        progressBar.setVisibility(View.GONE);
        noConnectionLayout.setVisibility(View.VISIBLE);
        Toast.makeText(this, getResources().getString(R.string.check_connection), Toast.LENGTH_LONG).show();
    }

    /*
     * RECARGAR DATOS EN CASO DE FALLO CON CONEXCION A INTERNET
     */
    private void retryData() {
        noConnectionLayout.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        productsViewModel.setProductsBySearchLiveData(extraSearchText);
        getProductsBySearch();
    }

}