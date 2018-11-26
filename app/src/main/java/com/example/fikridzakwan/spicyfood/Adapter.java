package com.example.fikridzakwan.spicyfood;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

     Context context;
     int[] gambarMakanan;
     String[] namaMaknan,detailMakanan;

    public Adapter(Context context, int[] gambarMakanan, String[] namaMaknan, String[] detailMakanan) {
        this.context = context;
        this.gambarMakanan = gambarMakanan;
        this.namaMaknan = namaMaknan;
        this.detailMakanan = detailMakanan;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_makanan, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNamaMakanan.setText(namaMaknan[i]);
        Glide.with(context).load(gambarMakanan[i]).into(viewHolder.imgLogoMakanan);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailSpicyFood.class);
                pindah.putExtra("NM", namaMaknan[i]);
                pindah.putExtra("DM", detailMakanan[i]);
                pindah.putExtra("GM", gambarMakanan[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {

        return gambarMakanan.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView  imgLogoMakanan;
        TextView txtNamaMakanan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogoMakanan = itemView.findViewById(R.id.imgLogoMakanan);
            txtNamaMakanan = itemView.findViewById(R.id.txtNamaMakanan);
        }
    }
}

