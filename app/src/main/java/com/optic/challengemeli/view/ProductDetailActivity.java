package com.optic.challengemeli.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.optic.challengemeli.R;
import com.optic.challengemeli.adapters.ProductAttributesAdapter;
import com.optic.challengemeli.data.model.Attribute;
import com.optic.challengemeli.data.model.Picture;
import com.optic.challengemeli.data.model.Product;
import com.optic.challengemeli.includes.MyToolbar;
import com.optic.challengemeli.network.Network;
import com.optic.challengemeli.view_model.ProductsViewModel;
import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {

    private final String TAG = "ProductDetailActivity";
    private TextView textViewName;
    private TextView textViewPrice;
    private TextView textViewCondition;
    private TextView textViewWarranty;
    private NestedScrollView scrollView;
    private ProgressBar progressBar;
    private RecyclerView recyclerViewAttributes;
    private LinearLayout noConnectionLayout;
    private Button btnRetryConnecting;
    private String extraIdProduct;
    private ImageSlider imageSlider;
    private ProductsViewModel productsViewModel;
    private ProductAttributesAdapter adapter;
    private ArrayList<Attribute> attributes = new ArrayList<>(); // arreglo para almacenar las caracteristicas de un producto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        extraIdProduct = getIntent().getStringExtra("idProduct"); // Obtener el id del producto enviado desde la clase ProductsFoundAdapter
        initUI();
        getProductDetail();
    }

    private void initUI() {
        // Mostrando el toolbar
        MyToolbar.show(this, "Detalle del producto", true);

        // Instancia de las vistas
        imageSlider = findViewById(R.id.imageSlider);
        textViewName = findViewById(R.id.textViewName);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewCondition = findViewById(R.id.textViewCondition);
        textViewWarranty = findViewById(R.id.textViewWarranty);
        scrollView = findViewById(R.id.scrollViewInfo);
        progressBar = findViewById(R.id.progressBar);
        noConnectionLayout = findViewById(R.id.noConnectionLayout);
        btnRetryConnecting = findViewById(R.id.btnRetryConnecting);
        recyclerViewAttributes = findViewById(R.id.recyclerViewAttributes);

        // Instancia del ViewModel
        productsViewModel = new ViewModelProvider(this).get(ProductsViewModel.class);
        productsViewModel.setProductByIdLiveData(extraIdProduct);

        // instancia de RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewAttributes.setLayoutManager(layoutManager);
        adapter = new ProductAttributesAdapter(ProductDetailActivity.this, attributes);
        recyclerViewAttributes.setAdapter(adapter);

        // RECARGAR INFORMACION
        btnRetryConnecting.setOnClickListener(view -> {
            retryData();
        });
    }

    /**
     * OBTENER EL DETALLE DE UN PRODUCTO
     */
    private void getProductDetail() {
        if (Network.checkNetwork(this)) {
            productsViewModel.getProductByIdLiveData().observe(this, product -> {
                progressBar.setVisibility(View.GONE); // ocultando el progress bar
                if (product != null) {
                    updateUI(product);
                }
                else {
                    Toast.makeText(ProductDetailActivity.this, getResources().getString(R.string.product_not_found), Toast.LENGTH_LONG).show();
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
    private void updateUI(Product product) {
        scrollView.setVisibility(View.VISIBLE); // Mostrando la informacion de la pantalla
        setImagesIntoSlider(product.pictures); // Mostrar las imagenes
        textViewName.setText(product.title); // Mostrar titulo
        textViewPrice.setText("$ " + product.price); // Mostrar precio
        textViewWarranty.setText(product.warranty != null ? product.warranty : "No aplica"); // Mostrar precio

        if (product.condition.equals("new")) {
            textViewCondition.setText(getResources().getString(R.string.condition_state_new)); // Mostrar Condicion nuevo
        }
        else if ((product.condition.equals("used"))){
            textViewCondition.setText(getResources().getString(R.string.condition_state_used)); // Mostrar Condicion usado
        }

        attributes.addAll(product.attributes); // estableciendo productos encotrados
        adapter.notifyDataSetChanged(); // Mostrando los datos
    }

    /*
     * PERMITE MOSTRAR TODAS LAS IMAGENES DE UN PRODUCTO EN UN CARRUSEL
     */
    private void setImagesIntoSlider(ArrayList<Picture> pictures) {
        ArrayList<SlideModel> imageList = new ArrayList<>();
        for (Picture p: pictures) {
            if (p.secure_url != null) {
                if (!p.secure_url.isEmpty()) {
                    imageList.add(new SlideModel(p.secure_url, ScaleTypes.CENTER_INSIDE));
                }
            }
        }
        imageSlider.setImageList(imageList);
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
        productsViewModel.setProductByIdLiveData(extraIdProduct);
        getProductDetail();
    }

    /*
     * OBTENGO EL BOTON DE IR HACIA ATRAS DEL TOOLBAR Y LE MODIFICO SU ACCION PARA NO ELIMINAR LAS BUSQUEDAS DE LA ANTERIOR ACTIVITY
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}