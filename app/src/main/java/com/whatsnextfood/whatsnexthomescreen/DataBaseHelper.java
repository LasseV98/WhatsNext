package com.whatsnextfood.whatsnexthomescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String PRODUCT_TABLE = "PRODUCT_TABLE";
    public static final String COLUMN_PRODUCT_NAAM = "PRODUCT_NAAM";
    public static final String COLUMN_PRODUCT_AANTAL = "PRODUCT_AANTAL";
    public static final String COLUMN_VERPAKT_PRODUCT = "VERPAKT_PRODUCT";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "Products.db", null, 1);
    }

    // this is calls the first time a db is accessed. Code to create a db
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + PRODUCT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCT_NAAM + " TEXT, " + COLUMN_PRODUCT_AANTAL + " INT, " + COLUMN_VERPAKT_PRODUCT + " BOOL)";

        db.execSQL(createTableStatement);
    }

    // this is called if the version number changes. It prevents perv users apps from breaking when changing the db design.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne (productModel productModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT_NAAM, productModel.getNaam());
        cv.put(COLUMN_PRODUCT_AANTAL, productModel.getAantal());
        cv.put(COLUMN_VERPAKT_PRODUCT, productModel.isActive());

        long insert = db.insert(PRODUCT_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;

        return true;
    }

}
