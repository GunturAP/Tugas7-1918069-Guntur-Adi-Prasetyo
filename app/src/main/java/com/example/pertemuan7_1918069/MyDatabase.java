package com.example.pertemuan7_1918069;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_guntur";
    private static final String tb_rokok = "tb_rokok";
    private static final String tb_rokok_id = "id";
    private static final String tb_rokok_merk = "merk";
    private static final String tb_rokok_produksi = "produksi";
    private static final String tb_rokok_harga = "harga";
    private static final String tb_rokok_img = "img_rokok";
    private static final String CREATE_TABLE_rokok = "CREATE TABLE " +
    tb_rokok +"("
            + tb_rokok_id + " INTEGER PRIMARY KEY ,"
            + tb_rokok_merk + " TEXT ,"
            + tb_rokok_produksi+ " TEXT ,"
            + tb_rokok_harga+ " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_rokok);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateRokok(Rokok data){


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_rokok_id, data.get_id());
        values.put(tb_rokok_merk, data.get_merk());
        values.put(tb_rokok_produksi, data.get_produksi());
        values.put(tb_rokok_harga, data.get_harga());
        db.insert(tb_rokok, null, values);
        db.close();
    }
    public List<Rokok> ReadRokok() {
        List<Rokok> ListRkok = new ArrayList<Rokok>();
        String selectQuery = "SELECT * FROM " + tb_rokok;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Rokok data = new Rokok();
                data.set_id(cursor.getString(0));
                data.set_merk(cursor.getString(1));
                data.set_produksi(cursor.getString(2));
                data.set_harga(cursor.getString(3));
                ListRkok.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return ListRkok;
    }
    public int UpdateRokok (Rokok data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_rokok_merk, data.get_merk());
        values.put(tb_rokok_produksi, data.get_produksi());
        values.put(tb_rokok_harga, data.get_harga());
        return db.update(tb_rokok, values, tb_rokok_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteRokok(Rokok data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_rokok,tb_rokok_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
