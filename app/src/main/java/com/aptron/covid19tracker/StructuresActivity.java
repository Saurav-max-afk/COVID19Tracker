package com.aptron.covid19tracker;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StructuresActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_structures);

        textView = findViewById(R.id.text1);

        String params = "Coronavirus genome structure and life cycle\n" +
                "\n" +
                "COVID-19 is a spherical or pleomorphic enveloped particles containing single-stranded (positive-sense) RNA associated with a nucleoprotein within a capsid comprised of matrix protein. " +
                "\n" +
                "The envelope bears club-shaped glycoprotein projections. Some coronaviruses also contain a hem agglutinin-esterase protein (HE)4";
        textView.setText(params);
        textView.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Structures");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
