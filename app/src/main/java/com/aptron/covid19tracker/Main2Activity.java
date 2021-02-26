package com.aptron.covid19tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private   RecyclerView recyclerView;
    private    List<States> statesList;
    private static String JSON_URL = "http://covid19-india-adhikansh.herokuapp.com/states";
    private Adapter adapter;
    private RequestQueue requestQueue;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setTitle("Affected States");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = findViewById(R.id.covidlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        statesList = new ArrayList<>();
b=findViewById(R.id.btnTrack3);
        requestQueue=Volley.newRequestQueue(this);


        parseJSON();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));

            }
        });
    }

    private void parseJSON() {
        String url="https://api.covid19india.org/data.json";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("statewise");

                   for (int i=0; i<jsonArray.length();i++)
                    {
                        JSONObject hit= jsonArray.getJSONObject(i);
                        String name=hit.getString("state");
                        String confirmed=hit.getString("confirmed");
                        String cured=hit.getString("recovered");
                        String death=hit.getString("deaths");
                        String active=hit.getString("active");

                        statesList.add(new States(name,confirmed,cured,death,active));
                    }
                    adapter=new Adapter(Main2Activity.this,statesList);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }


}