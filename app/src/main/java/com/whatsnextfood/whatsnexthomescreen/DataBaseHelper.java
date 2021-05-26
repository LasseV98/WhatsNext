package com.whatsnextfood.whatsnexthomescreen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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

    public boolean addOne (ProductModel productModel) {
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
    }

    public List <ProductModel> getAll(){
        List<ProductModel>returnList = new ArrayList<>();

        //data uit de database
        String queryString = "SELECT * FROM" + PRODUCT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        // 1 u 2 en 23 herbekijken er is een fout hieronder
       Cursor cursor =  db.rawQuery(queryString, null);

       if (cursor.moveToFirst()){
           //lopen door de curser ( resultaat set) en crate new product opbject , we zetten het  in een lijst
           do {
               int productID= cursor.getInt(0);
               String productNaam = cursor.getString(1);
               int productAantal = cursor.getInt(2);

                //Tiernary operator if statment in compacte vorm

               // if (Expresion){
               // variable=  expression2 }

               // else{
               // variable = Expression3;}
               boolean productVerpakt = cursor.getInt(3) == 1? true: false;

               ProductModel newProduct = new ProductModel(productID, productNaam,productAantal, productVerpakt);
               returnList.add(newProduct);


           }while (cursor.moveToNext());
       }

       else {
           //geen reslutaten database. Niks toevoegen list

       }
       //curusor en db sluiten op einde
        cursor.close();
        db.close();
        return returnList;
    }

}
