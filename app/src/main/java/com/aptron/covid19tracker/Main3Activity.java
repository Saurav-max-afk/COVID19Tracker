package com.aptron.covid19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    public static final String District= "district";
    public static final String Active= "active";
    public static final String Confirmed= "confirmed";
    public static final String Deceased= "deceased";
    public static final String Recovered= "recovered";


    EditText edtSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    public static List<CountryModel2>countryModelslist3 = new ArrayList<>();
    CountryModel2 countryModel2;
    MyCustomAdapter1 myCustomAdapter1;
 //  ArrayList<DistrictModel1> districtList1=new ArrayList<DistrictModel1>();

   // public String state, recovered,active,district,deceased,confirmed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtSearch = findViewById(R.id.edtSearch);
        listView = findViewById(R.id.listView);
        simpleArcLoader = findViewById(R.id.loader);

        getSupportActionBar().setTitle("Affected District");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        fetchData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Main3Activity.this,DetailActivity1.class);
                CountryModel2 countryModel2 = countryModelslist3.get(position);
                //   intent.putExtra("country",countryModel);

                //DistrictModel districtModel=districtList.get(position);
                intent.putExtra("District", countryModel2.getDistrict());
                /*DistrictModel districtModel=clickedItem.getDistrict().get(0);
intent.putExtra("District",districtModel.getDistrict());
                intent.putExtra("Active",districtModel.getActive());
                intent.putExtra("Confirmed",districtModel.getConfirmed());
                intent.putExtra("Deceased",districtModel.getDeceased());
                intent.putExtra("Recovered",districtModel.getRecovered());*/

                startActivity(intent);


            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                myCustomAdapter1.getFilter().filter(s);
                myCustomAdapter1.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

    private void fetchData() {


        String url= "https://api.covid19india.org/v2/state_district_wise.json";
        simpleArcLoader.start();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
countryModelslist3.clear();
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    Log.e("error",jsonArray.toString());
                    for (int i=0;i<jsonArray.length();i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                     String   state = jsonObject.getString("state");

                        JSONArray jsonArray1 = jsonObject.getJSONArray("districtData");

                        ArrayList<DistrictModel1> districtList1=new ArrayList<DistrictModel1>();
                        for (int j = 0; j < jsonArray1.length(); j++) {
                            JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                         String   district = jsonObject1.getString("district");
                          String  active = jsonObject1.getString("active");
                          String  confirmed = jsonObject1.getString("confirmed");
                          String  deceased = jsonObject1.getString("deceased");
                          String  recovered = jsonObject1.getString("recovered");
                            DistrictModel1 districtModel=new DistrictModel1(district,active,confirmed,deceased,recovered);
                            districtList1.add(districtModel);

                            //    countryModel = new CountryModel(state, district, active, confirmed, deceased, recovered);
                            //   countryModelslist.add(countryModel);
                        }
                        countryModel2 = new CountryModel2(state, districtList1);
                        countryModelslist3.add(countryModel2);

                    }



                    myCustomAdapter1=new MyCustomAdapter1(getApplicationContext(),countryModelslist3);
                    listView.setAdapter(myCustomAdapter1);
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);





                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);


                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);



                Toast.makeText(Main3Activity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);

    }

}

