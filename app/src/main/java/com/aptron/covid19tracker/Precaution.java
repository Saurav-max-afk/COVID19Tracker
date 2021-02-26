package com.aptron.covid19tracker;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Precaution extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution);
       textView= findViewById(R.id.text1);

       String params = "To prevent the spread of COVID-19:\n" +
               "\n" +
               "Clean your hands often. Use soap and water, or an alcohol-based hand rub.\n" +
               "Maintain a safe distance from anyone who is coughing or sneezing.\n" +
               "Don’t touch your eyes, nose or mouth.\n" +
               "Cover your nose and mouth with your bent elbow or a tissue when you cough or sneeze.\n" +
               "Stay home if you feel unwell.\n" +
               "If you have a fever, cough and difficulty breathing, seek medical attention. Call in advance.\n" +
               "Follow the directions of your local health authority.";

        textView.setText(params);
        textView.setMovementMethod(new ScrollingMovementMethod());

        getSupportActionBar().setTitle("Precautions");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
