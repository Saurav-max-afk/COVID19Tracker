package com.aptron.covid19tracker;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WhatActivity extends AppCompatActivity {
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what);

        textView2= findViewById(R.id.what);

        String params1 = "Coronavirus disease (COVID-19) is an infectious disease caused by a newly discovered coronavirus.\n" +
                         "\n" +
                         "The COVID-19 virus spreads primarily through droplets of saliva or discharge from the nose when an infected person coughs or sneezes, so it’s important that you also practice respiratory etiquette (for example, by coughing into a flexed elbow).";

        textView2.setText(params1);
        textView2.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Covid19");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}
