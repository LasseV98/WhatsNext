package com.whatsnextfood.whatsnexthomescreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DeKast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_de_kast)


        val button: Button = findViewById(R.id.btn_kastBackHome2)
        button.setOnClickListener {
            startActivity(Intent(this@DeKast, MainActivity::class.java))
        }
    }
}