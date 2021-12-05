package com.example.pertemuan7_1918069;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Rokok> listRokok = new
            ArrayList<Rokok>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listRokok
        );
        mListView = (ListView) findViewById(R.id.list_rokok);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listRokok.clear();
        List<Rokok> rokok = db.ReadRokok();
        for (Rokok rkok : rokok) {
            Rokok daftar = new Rokok();
            daftar.set_id(rkok.get_id());
            daftar.set_merk(rkok.get_merk());
            daftar.set_produksi(rkok.get_produksi());
            daftar.set_harga(rkok.get_harga());
            listRokok.add(daftar);
            if ((listRokok.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Rokok detailrkok = (Rokok)o;
        String Sid = detailrkok.get_id();
        String Smerk = detailrkok.get_merk();
        String Sproduksi = detailrkok.get_produksi();
        String Sharga = detailrkok.get_harga();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Imerk", Smerk);
        goUpdel.putExtra("Iproduksi", Sproduksi);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listRokok.clear();
        mListView.setAdapter(adapter_off);
        List<Rokok> rokok = db.ReadRokok();
        for (Rokok rkok : rokok) {
            Rokok daftar = new Rokok();
            daftar.set_id(rkok.get_id());
            daftar.set_merk(rkok.get_merk());
            daftar.set_produksi(rkok.get_produksi());
            daftar.set_harga(rkok.get_harga());
            listRokok.add(daftar);
            if ((listRokok.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
