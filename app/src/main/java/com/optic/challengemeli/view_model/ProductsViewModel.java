package com.optic.challengemeli.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.optic.challengemeli.data.model.Product;
import com.optic.challengemeli.data.model.ProductResult;
import com.optic.challengemeli.data.model.SearchResult;
import com.optic.challengemeli.data.repository.ProductsRepository;

public class ProductsViewModel extends ViewModel {

    private ProductsRepository productsRepository;
    private LiveData<SearchResult> searchResultLiveData;
    private LiveData<Product> productLiveData;

    public ProductsViewModel() {
        productsRepository = new ProductsRepository();
    }

    /*
     * ESTABLESCO LA INFORMACIONDE LA BUSQUEDA EN EL OBSERVABLE LIVE DATA
     */
    public void setProductsBySearchLiveData(String searchText) {
        searchResultLiveData = productsRepository.getProductsBySearch(searchText);
    }

    /*
     * ESTABLESCO LA INFORMACION DEL DETALLE DE UN PRODUCTO EN EL OBSERVABLE LIVE DATA
     */
    public void setProductByIdLiveData(String idProduct) {
        productLiveData = productsRepository.getProductById(idProduct);
    }

    /*
     * RETORNO EL OBSERVABLE CON LA INFORMACION DE LA BUSQUEDA
     */
    public LiveData<SearchResult> getProductsBySearchLiveData() {
        return searchResultLiveData;
    }

    /*
     * RETORNO EL OBSERVABLE CON LA INFORMACION DEL PRODUCTO
     */
    public LiveData<Product> getProductByIdLiveData() {
        return productLiveData;
    }

}
