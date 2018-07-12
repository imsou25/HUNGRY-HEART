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

public class AdapterIndian extends RecyclerView.Adapter<AdapterIndian.ViewHolder> {

    Context context;
    ArrayList<Dishes> iList=new ArrayList<>();

    public AdapterIndian(Context context, ArrayList<Dishes> list) {
        this.context = context;
        this.iList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_indian_adapter, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dishes dishes = iList.get(position);
        holder.indianNameTextView.setText(dishes.getfName());
        holder.indianImageView.setImageResource(dishes.getfImage());
        // Price is in int convert into string to show in text view
        holder.indianPriceTextView.setText("Rs." + String.valueOf(dishes.getfPrice()));

    }

    @Override
    public int getItemCount() {
        return iList.size();
    }

    public void setData(ArrayList<Dishes> filterList) {
        iList = filterList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView indianImageView;
        TextView indianNameTextView, indianPriceTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            indianImageView = itemView.findViewById(R.id.image_product);
            indianNameTextView = itemView.findViewById(R.id.text_view_product_name);
            indianPriceTextView = itemView.findViewById(R.id.text_view_product_price);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Dishes dishes = iList.get(getAdapterPosition());
            Intent intent = new Intent(context, OrderActivity.class);
            intent.putExtra("DISH", dishes);
            context.startActivity(intent);
        }
    }
}