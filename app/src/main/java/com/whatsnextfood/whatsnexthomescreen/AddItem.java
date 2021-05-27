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
        sw_verpakt = findViewById(R.id.sw_Sealed);
        lv_productList = findViewById(R.id.lv_productList);

        // btn listners

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItem.this,"Add button",Toast.LENGTH_SHORT).show();


            }
        });
        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddItem.this,"view All button",Toast.LENGTH_SHORT).show();


            }
        });


    }
}
