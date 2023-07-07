package com.example.exercicioGazeta.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GazetaDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "gazeta.db";
    public static final int DB_VERSION =1;

    Cursor cursor;
    SQLiteDatabase db;

    public GazetaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaCombustivel
                = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeCombustivel TEXT, " +
                "precoCombustivel REAL, " +
                "resultado TEXT)" ;

        db.execSQL(sqlTabelaCombustivel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //TODO: criar métodos para implementar um CRUD

}
