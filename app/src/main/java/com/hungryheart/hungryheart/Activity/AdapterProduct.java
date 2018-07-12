package com.hungryheart.hungryheart.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hungryheart.hungryheart.R;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    Context context;
    ArrayList<Product> mList;

    public AdapterProduct(Context context, ArrayList<Product> list) {
        this.context = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_product_adapterlist, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = mList.get(position);
        holder.productNameTextView.setText(product.getfName());
        holder.productImageView.setImageResource(product.getfImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView productImageView;
        TextView productNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.image_product);
            productNameTextView = itemView.findViewById(R.id.text_view_product_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Product product = mList.get(getAdapterPosition());
            Intent intent = new Intent(context, IndianMenuActivity.class);
            intent.putExtra("CAT_ID", product.getCatId());
            intent.putExtra("CAT_NAME", product.getfName());

            context.startActivity(intent);




        }
    }
}