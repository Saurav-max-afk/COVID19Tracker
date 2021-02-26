package com.aptron.covid19tracker;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailActivity1 extends AppCompatActivity {
    private RecyclerView recyclerView;
  //  private List<State1> statesList;
    private Adapter3 adapter;
    private int positionCountry;
    private ArrayList<DistrictModel1> districtList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        recyclerView = findViewById(R.id.covidlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // statesList = new ArrayList<>();


        getSupportActionBar().setTitle("Affected District");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        districtList=new ArrayList<DistrictModel1>();

        districtList=(ArrayList<DistrictModel1>) getIntent().getSerializableExtra("District");
        Log.e("District List ",districtList.toString());

       /* Intent intent = getIntent();
        String district= intent.getStringExtra(District);
        String active = intent.getStringExtra(Active);
        String confirmed = intent.getStringExtra(Confirmed);
        String deceased=intent.getStringExtra(Deceased);
        String recovered = intent.getStringExtra(Recovered);*/

        // State1 state1=new State1(district,active,confirmed,deceased,recovered);
        // statesList.add(state1);


        adapter=new Adapter3(DetailActivity1.this,districtList);
        recyclerView.setAdapter(adapter);
    }

}
