package com.optic.challengemeli.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.mancj.materialsearchbar.adapter.SuggestionsAdapter;
import com.optic.challengemeli.R;
import com.optic.challengemeli.view.ProductsListActivity;

public class CustomSuggestionsAdapter extends SuggestionsAdapter<String, CustomSuggestionsAdapter.SuggestionHolder> {

    private Context context;

    public CustomSuggestionsAdapter(LayoutInflater inflater, Context context) {
        super(inflater);
        this.context = context;
    }

    @Override
    public int getSingleViewHeight() {
        return 80;
    }

    @Override
    public SuggestionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.item_suggestion, parent, false);
        return new SuggestionHolder(view);
    }

    @Override
    public void onBindSuggestionHolder(String suggestion, SuggestionHolder holder, int position) {
        holder.title.setText(suggestion);
        holder.itemView.setOnClickListener(view -> {
            goToProductsList(suggestion);
        });
    }

    private void goToProductsList(String searchText) {
        Intent i = new Intent(context, ProductsListActivity.class);
        i.putExtra("search", searchText);
        context.startActivity(i);
    }

    static class SuggestionHolder extends RecyclerView.ViewHolder{
        protected TextView title;
        public SuggestionHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

}

