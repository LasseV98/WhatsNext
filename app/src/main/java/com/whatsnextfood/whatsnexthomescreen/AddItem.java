package com.whatsnextfood.whatsnexthomescreen;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("UseSwitchCompatOrMaterialCode")
public class AddItem extends AppCompatActivity {

    //references of layout
    Button btn_add, btn_viewAll;
    EditText et_naam, et_aantal;
    Switch sw_verpakt;
    ListView lv_productList;

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_toevoegen);

        btn_add = findViewById(R.id.btn_add);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        et_aantal = findViewById(R.id.et_number);
        et_naam = findViewById(R.id.et_name);
        sw_verpakt = findViewById(R.id.sw_sealed);
        lv_productList = findViewById(R.id.lv_productList);

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
            }
        });

        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItem.this, "View button", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
