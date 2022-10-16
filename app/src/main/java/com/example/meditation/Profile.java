package com.example.meditation;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> dataSource;
    LinearLayoutManager linearLayoutManager;
    MyRvAdapter myRvAdapter;

    // URl from API
    private static final String testUrl = "http://mskko2021.mad.hakta.pro/api/quotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        getData(testUrl);

        rv = findViewById(R.id.horizontalRv);



        //Setting the data source
        dataSource = new ArrayList<>();
        dataSource.add("Hello");
        dataSource.add("World");
        dataSource.add("To");
        dataSource.add("The");
        dataSource.add("Code");
        dataSource.add("City");
        dataSource.add("******");

        linearLayoutManager = new LinearLayoutManager(Profile.this, LinearLayoutManager.HORIZONTAL, false);
        myRvAdapter = new Profile.MyRvAdapter(dataSource);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);
    }

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
    class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
        ArrayList<String> data;

        public MyRvAdapter(ArrayList<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(Profile.this).inflate(R.layout.rv_item, parent, false);
            return new Profile.MyRvAdapter.MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.tvTitle.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
            }
        }

    }
}