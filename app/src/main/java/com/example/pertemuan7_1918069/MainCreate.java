package com.example.pertemuan7_1918069;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emerk, Eproduksi, Eharga;
    private String Smerk, Sproduksi, Sharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Eproduksi = (EditText) findViewById(R.id.create_produksi);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Sproduksi = String.valueOf(Eproduksi.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sproduksi.equals("")) {
                    Eproduksi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi produksi",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Harga",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Emerk.setText("");
                    Eproduksi.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateRokok(new Rokok(null, Smerk, Sproduksi, Sharga));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
