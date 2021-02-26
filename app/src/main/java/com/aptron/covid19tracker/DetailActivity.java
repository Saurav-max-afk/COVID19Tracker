package com.aptron.covid19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;

    TextView tvCountry, tvCases, tvRecovered, tvCritical, tvActive, tvTodayCases,tvTodayDeaths, tvDeaths, tvCasesPerOneMillion, tvDeathsPerOneMillion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position", 0);

        getSupportActionBar().setTitle("Details of " + AffectedCountries.countryModelslist.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
         tvDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvCasesPerOneMillion = findViewById(R.id.tvCasesPerOneMillion);
        tvDeathsPerOneMillion = findViewById(R.id.tvDeathsPerOneMillion);


        tvCountry.setText(AffectedCountries.countryModelslist.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelslist.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelslist.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelslist.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelslist.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelslist.get(positionCountry).getTodayCases());
       tvDeaths.setText(AffectedCountries.countryModelslist.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelslist.get(positionCountry).getTodayDeaths());
        tvCasesPerOneMillion.setText(AffectedCountries.countryModelslist.get(positionCountry).getCasesPerOneMillion());
        tvDeathsPerOneMillion.setText(AffectedCountries.countryModelslist.get(positionCountry).getDeathsPerOneMillion());




    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}
