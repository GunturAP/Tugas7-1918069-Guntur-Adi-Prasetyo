package com.example.pertemuan7_1918069;
public class Rokok {
    private String _id, _merk, _produksi, _harga;
    public Rokok(String id, String merk, String produksi, String harga) {
        this._id = id;
        this._merk = merk;
        this._produksi = produksi;
        this._harga = harga;
    }
    public Rokok() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }
    public String get_produksi() {
        return _produksi;
    }
    public void set_produksi(String _produksi) {
        this._produksi = _produksi;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }

}

