package com.android.deliveryguevara.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BD_SQLITEDELIVERY extends SQLiteOpenHelper {
    public static final String dbname = "Bd_delivery";
    public static final int v = 2;
    static final String sqlBd_delivery = "CREATE TABLE delivery(iddelivery integer primary key autoincrement, restaurante text, descripcion text, presentacion text, precio text, delivery text)";
    public BD_SQLITEDELIVERY(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, v);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {sqLiteDatabase.execSQL(sqlBd_delivery) ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public String administrar_delivery(String id, String res, String des, String pre, String prec, String accion) {
        try {
            SQLiteDatabase db = getWritableDatabase();
            if (accion.equals("nuevo1")) {
                db.execSQL("INSERT INTO delivery(restaurante,descripcion,presentacion,precio) VALUES('" + res + "','" + des + "','" + pre + "','" + pre + "','" + prec + "')");

            } else if (accion.equals("modificar2")) {
                db.execSQL("UPDATE delivery SET restaurante='" + res + "', descripcion='" + des + "', presentacion='" + pre + "',precio='" + prec + "' WHERE idescritorio='" + id + "'");

            } else if (accion.equals("eliminar3")) {
                db.execSQL("DELETE FROM delivery WHERE iddelivery='" + id + "'");

            }
            return "ok";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

    }
    public Cursor consultar_escritorio(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM delivery ORDER BY restaurante";
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
}
