package com.whatsnextfood.whatsnexthomescreen.dummy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.whatsnextfood.whatsnexthomescreen.R



class loginPagina : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.login_pagina, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //dit zoekt de button(id) en de action in nav_graph.xml
        //bij findNavController zoek je expliciet welke actie je wilt doen
        view.findViewById<Button>(R.id.nieuwegebruiker).setOnClickListener {
            findNavController().navigate(R.id.pagina_nieuwegebruiker)
        }
    }
}