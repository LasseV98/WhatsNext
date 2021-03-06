package com.whatsnextfood.whatsnexthomescreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class AddItems : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_toevoegen)

        var btn_add: Button? = null
        var btn_viewAll: Button? = null
        var et_name: EditText? = null
        var et_number:EditText? = null
        var sw_Active: Switch? = null
        var lv_productList: ListView? = null
        var ProductArrayAdapter: Adapter? = null
        var dataBaseHelper: DataBaseHelper? = null

        dataBaseHelper = DataBaseHelper(this@AddItems)


        ProductArrayAdapter = ArrayAdapter(this@AddItems, android.R.layout.simple_list_item_1, dataBaseHelper.getAll())

        if (lv_productList != null) {
            lv_productList.setAdapter(ProductArrayAdapter)
        }



        btn_add = findViewById<Button>(R.id.btn_add)
        btn_viewAll = findViewById<Button>(R.id.btn_viewAll)
        et_number = findViewById<EditText>(R.id.et_number)
        et_name = findViewById<EditText>(R.id.et_name)
        sw_Active = findViewById<Switch>(R.id.sw_Sealed)
        lv_productList = findViewById<ListView>(R.id.lv_productList)


        //button listeners
        btn_add.setOnClickListener(View.OnClickListener {
            var productModel: ProductModel
            try {
                productModel = ProductModel(
                    -1,
                    et_name.getText().toString(),
                    et_number.getText().toString().toInt(),
                    sw_Active.isChecked()
                )
                Toast.makeText(this@AddItems, productModel.toString(), Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this@AddItems, "Error creating Product", Toast.LENGTH_SHORT).show()
                productModel = ProductModel(-1, "error", 0, false)
            }
            val dataBaseHelper = DataBaseHelper(this@AddItems)
            val success: Boolean? = dataBaseHelper.addOne(productModel)
            Toast.makeText(this@AddItems, "Success$success", Toast.LENGTH_SHORT).show()
        })

        btn_viewAll.setOnClickListener(View.OnClickListener {
            val dataBaseHelper = DataBaseHelper(this@AddItems)
            val all = dataBaseHelper.all
            val ProductArrayAdapter = ArrayAdapter(this@AddItems, android.R.layout.simple_list_item_1, all)
                lv_productList.adapter = ProductArrayAdapter
            //Toast.makeText(this@AddItems, all.toString(), Toast.LENGTH_SHORT).show()
        })

        val button: Button = findViewById(R.id.btn_secondBackHome)
        button.setOnClickListener {
            startActivity(Intent(this@AddItems, MainActivity::class.java))
        }

    }


}