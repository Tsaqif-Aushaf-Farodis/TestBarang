package com.example.testbarang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterLihatBarang extends RecyclerView.Adapter<AdapterLihatBarang.ViewHolder> {

    private ArrayList<Barang> daftarBarang;
    private Context context;

    public AdapterLihatBarang(ArrayList<Barang> barangs, Context c){
        //Inisiasi data dan variabel yang akan digunakan
        daftarBarang = barangs;
        context = c;
    }

    @NonNull
    @Override
    public AdapterLihatBarang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inisiasi ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        // Mengeset ukuran view, margin, padding dan parameter layout lainnya
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLihatBarang.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        /*Inisiasi View
        * Disini kita hanya menggunakan data string untuk tiap item
        * dan juga viewnya hanyalah satu TextView*/
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_namabarang);
        }
    }
}
