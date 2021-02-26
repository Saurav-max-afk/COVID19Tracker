package com.aptron.covid19tracker;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SymptomsActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        textView=findViewById(R.id.text1);

        String params = "Most common symptoms:\n" +
                "> fever\n" +
                "> dry cough\n" +
                "> tiredness\n" +
               "\n" +
                "Less common symptoms:\n" +
                "> aches and pains\n" +
                "> sore throat\n" +
                "> diarrhoea\n" +
                "> conjunctivitis\n" +
                "> headache\n" +
                "> loss of taste or smell\n" +
                "> a rash on skin, or discolouration of fingers or toes\n" +
                "\n" +
                "Serious symptoms:\n" +
                "> difficulty breathing or shortness of breath\n" +
                "> chest pain or pressure\n" +
                "> loss of speech or movement";

        textView.setText(params);
        textView.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Symptoms");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
