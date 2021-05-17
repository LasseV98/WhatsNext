package com.whatsnextfood.whatsnexthomescreen.dummy

import android.os.Bundle
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.whatsnextfood.whatsnexthomescreen.R

class login_page {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_pagina)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.nieuwegebruiker)
}