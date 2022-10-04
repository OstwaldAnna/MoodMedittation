package com.example.meditation;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Profile extends AppCompatActivity {

    // URl from API
    private static final String testUrl = "http://mskko2021.mad.hakta.pro/api/quotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getData(testUrl);
    }

    private void getData(String url) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(Profile.this); // очередь запросов
         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject weather = response.getJSONObject("data");
                    System.out.print(response.getString("success"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {System.out.print(error);
            }
        });

        mRequestQueue.add(request);
    }
}