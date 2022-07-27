package com.optic.challengemeli.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.optic.challengemeli.R;
import com.optic.challengemeli.view.ProductDetailActivity;
import com.optic.challengemeli.data.model.ProductResult;
import java.util.ArrayList;

/*
 * PERMITE MOSTRAR EN UN RECYCLER VIEW LA LISTA DE LOS PRODUCTOS ENCONTRADOS EN LA BUSQUEDA
 */
public class ProductsFoundAdapter extends RecyclerView.Adapter<ProductsFoundAdapter.ProductsViewHolder> {

    private Context context;
    private ArrayList<ProductResult> products;

    /*
     * CONSTRUCTOR DE LA CLASE
     * @param context -> Contexto donde se mostrara el adapter
     * @param products -> Lista de productos que se van a mostrar
     */
    public ProductsFoundAdapter(Context context, ArrayList<ProductResult> products) {
        this.context = context;
        this.products = products;
    }

    /*
     * INSTANCIAMOS EL LAYOUT QUE VAMOS A OCUPAR "cardview_product"
     */
    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductsViewHolder(view);
    }

    /*
     * ESTABLECEMOS LOS VALORES A LAS VISTAS
     */
    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

        ProductResult product = products.get(position);
        if (product != null) {

            holder.textViewName.setText(product.getTitle());
            holder.textViewPrice.setText("$ " + product.getPrice());

            if (product.address != null) {
                holder.textViewLocation.setText(product.address.state_name);
            }

            if (product.getThumbnail() != null) {
                if (!product.getThumbnail().isEmpty()) {
                    Glide.with(context).load(product.getThumbnail()).into(holder.imageViewProduct);
                }
            }

            if (product.installments != null) {
                holder.textViewInstallments.setVisibility(View.VISIBLE);
                holder.textViewInstallments.setText("En " + product.installments.quantity + "x $ " + product.installments.amount);
            }

            if (product.shipping != null) {
                if (product.shipping.free_shipping) {
                    holder.textViewFreeShipping.setVisibility(View.VISIBLE);
                }
                else {
                    holder.textViewFreeShipping.setVisibility(View.GONE);
                }
            }

            holder.view.setOnClickListener(view -> {
                goToDetailProduct(product.id);
            });
        }

    }

    /*
     * IR A LA PANTALLA DE DETALLE
     * @param idProduct -> id del producto seleccionado
     */
    private void goToDetailProduct(String idProduct) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("idProduct", idProduct);
        context.startActivity(intent);
    }

    /*
     * RETORNAR EL TAMAñO DE LA LISTA DE PRODUCTOS
     */
    @Override
    public int getItemCount() {
        return products.size();
    }

    /*
     * CLASE ViewHolder PERMITE INSTANCIAR LAS VISTAS
     */
    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewPrice;
        private TextView textViewInstallments;
        private TextView textViewFreeShipping;
        private TextView textViewLocation;
        private ImageView imageViewProduct;
        private View view;


        public ProductsViewHolder(View viewHolder) {
            super(viewHolder);
            view = viewHolder;
            textViewName = view.findViewById(R.id.textViewName);
            textViewPrice = view.findViewById(R.id.textViewPrice);
            textViewInstallments = view.findViewById(R.id.textViewInstallments);
            textViewFreeShipping = view.findViewById(R.id.textViewFreeShipping);
            textViewLocation = view.findViewById(R.id.textViewLocation);
            imageViewProduct = view.findViewById(R.id.imageViewProduct);
        }

    }
}

