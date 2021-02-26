package com.aptron.covid19tracker;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CausesActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_causes);

        textView = findViewById(R.id.text1);
        String params = "Infection with the new coronavirus (severe acute respiratory syndrome coronavirus 2, or SARS-CoV-2) causes coronavirus disease 2019 (COVID-19).\n" +
                "\n" +
                "The virus appears to spread easily among people, and more continues to be discovered over time about how it spreads. Data has shown that it spreads from person to person among those in close contact (within about 6 feet, or 2 meters). The virus spreads by respiratory droplets released when someone with the virus coughs, sneezes or talks. These droplets can be inhaled or land in the mouth or nose of a person nearby.\n" +
                "\n" +
                "It can also spread if a person touches a surface with the virus on it and then touches his or her mouth, nose or eyes, although this isn't considered to be a main way it spreads.";

        textView.setText(params);
        textView.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Causes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
