package com.example.pertemuan7_1918069;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Rokok> Rokok;
    public CustomListAdapter(Activity activity, List<Rokok>
            Rokok) {
        this.activity = activity;
        this.Rokok = Rokok;
    }
    @Override
    public int getCount() {
        return Rokok.size();
    }
    @Override
    public Object getItem(int location) {
        return Rokok.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView merk = (TextView)
                convertView.findViewById(R.id.text_merk);
        TextView produksi = (TextView)
                convertView.findViewById(R.id.text_produksi);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.gambar);
        Rokok m = Rokok.get(position);
        merk.setText(""+ m.get_merk());
        produksi.setText("Di Produksi "+ m.get_produksi());
        harga.setText("Rp . "+ m.get_harga());
        return convertView;
    }
}