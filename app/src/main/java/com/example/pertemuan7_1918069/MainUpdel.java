package com.example.pertemuan7_1918069;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smerk, Sproduksi, Sharga;
    private EditText Emerk, Eproduksi, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerk = i.getStringExtra("Imerk");
        Sproduksi = i.getStringExtra("Iproduksi");
        Sharga = i.getStringExtra("Iharga");
        Emerk = (EditText) findViewById(R.id.updel_merk);
        Eproduksi = (EditText) findViewById(R.id.updel_produksi);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Emerk.setText(Smerk);
        Eproduksi.setText(Sproduksi);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Sproduksi = String.valueOf(Eproduksi.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi merk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sproduksi.equals("")){
                    Eproduksi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi produksi",
                            Toast.LENGTH_SHORT).show();
                }else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateRokok(new Rokok(Sid, Smerk,Sproduksi,Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteRokok(new Rokok(Sid, Smerk, Sproduksi,Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}