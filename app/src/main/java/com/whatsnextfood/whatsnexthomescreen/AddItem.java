package com.whatsnextfood.whatsnexthomescreen;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddItem extends AppCompatActivity {

    //references of layout
    Button btn_add, btn_viewAll;
    EditText et_naam, et_aantal;
    Switch sw_verpakt;
    ListView lv_productList;
    ArrayAdapter productArrayAdapter;

    DataBaseHelper dataBaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_second);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        et_aantal = findViewById(R.id.et_aantal);
        et_naam = findViewById(R.id.et_naam);
        sw_verpakt = findViewById(R.id.sw_verpakt);
        lv_productList =findViewById((R.id.lv_productList));


        ShowProductOnListView(dataBaseHelper);

        dataBaseHelper = new DataBaseHelper(AddItem.this);

        //button listeners
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductModel productModel;

                try {
                    productModel = new ProductModel(-1, et_naam.getText().toString(), Integer.parseInt(et_aantal.getText().toString()), sw_verpakt.isChecked());
                    Toast.makeText(AddItem.this, productModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(AddItem.this, "Error creating Product", Toast.LENGTH_SHORT).show();
                    productModel = new ProductModel(-1, "error", 0, false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(AddItem.this);

                boolean success = dataBaseHelper.addOne(productModel);

                Toast.makeText(AddItem.this, "Success" + success, Toast.LENGTH_SHORT).show();
                ShowProductOnListView(dataBaseHelper);
            }
        });

        btn_viewAll.setOnClickListener((v) ->{
            DataBaseHelper dataBaseHelper = new DataBaseHelper(AddItem.this);

            ShowProductOnListView(dataBaseHelper);

            //Toast.makeText(AddItem.this, all.toString(),Toast.LENGTH_SHORT).show();

        });
    }

    private void ShowProductOnListView(DataBaseHelper dataBaseHelper2) {
        productArrayAdapter = new ArrayAdapter<ProductModel>(AddItem.this, android.R.layout.simple_list_item_1, dataBaseHelper2.getAll());
        lv_productList.setAdapter(productArrayAdapter);
    }
}
