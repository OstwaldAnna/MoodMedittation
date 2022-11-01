package com.example.meditation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    // URl from API
    private static final String testUrl = "http://mskko2021.mad.hakta.pro/api/quotes";

    public static ArrayList<Feeling> dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//        dataSource = new ArrayList<>();
//        responseData(dataSource);
//        getData(testUrl);
    }

//    private void responseData(ArrayList<Feeling> dataSource){
//        System.out.print("Start func!");
//        String url = "http://mskko2021.mad.hakta.pro/api/feelings";
//        RequestQueue mRequestQueue = Volley.newRequestQueue(this); // очередь запросов
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
//            try {
//                JSONArray res = response.getJSONArray("data");
//                for (int i = 0; i < res.length(); i++){
//                    System.out.print(res.getJSONObject(i).getString("title"));
//                    dataSource.add(new Feeling(res.getJSONObject(i).getString("image"),
//                            res.getJSONObject(i).getString("title")));
//                }
//            } catch (Exception e) {
//                System.out.print(e.getMessage());
//            }
//        }, error -> {
//        });
//        mRequestQueue.add(request);
//    }

//    private void getData(String url) {
//        RequestQueue mRequestQueue = Volley.newRequestQueue(Profile.this); // очередь запросов
//         JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    JSONObject weather = response.getJSONObject("data");
//                    System.out.print(response.getString("success"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {System.out.print(error);
//            }
//        });
//
//        mRequestQueue.add(request);
//    }
}