package com.whatsnextfood.whatsnexthomescreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView

class DeKast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_de_kast)


        val button: Button = findViewById(R.id.btn_kastBackHome2)
        button.setOnClickListener {
            startActivity(Intent(this@DeKast, MainActivity::class.java))

            val ListView = findViewById<ListView>(R.id.de_kast_listview)

            ListView.adapter = MyCustomAdapter(this) // this needs to be my custum adapter telling my list what to render


    }
}
    private class MyCustomAdapter(context: Context): BaseAdapter(){

        private val mContext: Context

        init {
                mContext = context
        }

        //verantwoordelijk hoeveel rijen in list
        override fun getCount(): Int {
            return 5
        }

        // kunt het nu negeren
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        // kunt het nu negeren
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        //verantwoordelijk voor elke rij te renderen
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(mContext)
            textView.text="Here is my Row for my LISTVIEW"
            return textView

        }

    }
}

