package com.example.testbarang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahData extends AppCompatActivity {
    private DatabaseReference database;
    private Button btnSubmit;
    private EditText etKode, etNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        etKode = findViewById(R.id.editNo);
        etNama = findViewById(R.id.editNama);
        btnSubmit = findViewById(R.id.btnOK);

        //mengambil referensi ke firebase database
        database = FirebaseDatabase.getInstance().getReference();
    }
}
