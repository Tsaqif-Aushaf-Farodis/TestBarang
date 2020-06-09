package com.example.testbarang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LihatBarang extends AppCompatActivity {
    //Mendefinisikan variabel yang akan dipakai
    private DatabaseReference database;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Barang> daftarBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_barang);

        //Inisialisasi RecyclerView & komponennya
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Inisialisasi dan mengambil firebase database reference
        database = FirebaseDatabase.getInstance().getReference();

        //Mengambil data barang dari firebase realtime DB
        database.child("Barang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Memasukkan data baru ke arrayList
                daftarBarang = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()){
                    /*Mapping data pada DataSnapshot ke dalam object barang
                    * dan juga menyimpan primary key pada object barang untuk
                    * keperluan edit dan delete data.*/
                    Barang barang = noteDataSnapshot.getValue(Barang.class);
                    barang.setKode(noteDataSnapshot.getKey());
                    /*Menambahkan objek barang yang sudah dimapping ke dalam arraylist*/
                    daftarBarang.add(barang);
                }
                /*Inisialisasi adapter dan data barang dalam bentuk arrayList
                * dan mengeset adapter ke dalam recyclerView*/
                adapter = new AdapterLihatBarang(daftarBarang, LihatBarang.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        })
    }
}