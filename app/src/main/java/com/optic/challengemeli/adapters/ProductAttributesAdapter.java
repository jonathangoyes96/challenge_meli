package com.optic.challengemeli.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.optic.challengemeli.R;
import com.optic.challengemeli.view.ProductDetailActivity;
import com.optic.challengemeli.data.model.Attribute;

import java.util.ArrayList;

public class ProductAttributesAdapter extends RecyclerView.Adapter<ProductAttributesAdapter.Holder> {

    private Context context;
    private ArrayList<Attribute> attributes;

    public ProductAttributesAdapter(Context context, ArrayList<Attribute> attributes) {
        this.context = context;
        this.attributes = attributes;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_attribute, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Attribute attribute = attributes.get(position);
        holder.textViewAttributeTitle.setText(attribute.getName());
        holder.textViewAttributeContent.setText(attribute.getValue_name());
    }

    /*
     * IR A LA PANTALLA DE DETALLE
     */
    private void goToDetailProduct(String idProduct) {

        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("idProduct", idProduct);
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }


    public class Holder extends RecyclerView.ViewHolder {

        private TextView textViewAttributeTitle;
        private TextView textViewAttributeContent;
        private View view;


        public Holder(View viewHolder) {
            super(viewHolder);
            view = viewHolder;
            textViewAttributeTitle = view.findViewById(R.id.textViewAttributeTitle);
            textViewAttributeContent = view.findViewById(R.id.textViewAttributeContent);
        }

    }
}

