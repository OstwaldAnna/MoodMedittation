package com.example.meditation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HorizontalRecycleView extends AppCompatActivity {

        RecyclerView rv;
        ArrayList<String> dataSource;
        LinearLayoutManager linearLayoutManager;
        MyRvAdapter myRvAdapter;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home);
            rv = findViewById(R.id.rv_horizontal);

            //Setting the data source
            dataSource = new ArrayList<>();
            dataSource.add("Hello");
            dataSource.add("World");
            dataSource.add("To");
            dataSource.add("The");
            dataSource.add("Code");
            dataSource.add("City");
            dataSource.add("******");

            linearLayoutManager = new LinearLayoutManager(HorizontalRecycleView.this, LinearLayoutManager.HORIZONTAL, false);
            myRvAdapter = new MyRvAdapter(dataSource);
            rv.setLayoutManager(linearLayoutManager);
            rv.setAdapter(myRvAdapter);
        }
            class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyHolder> {
                ArrayList<String> data;

                    public MyRvAdapter(ArrayList<String> data) {
                        this.data = data;
        }

        @NonNull
        @Override
            public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(HorizontalRecycleView.this).inflate(R.layout.rv_item, parent, false);
                return new MyHolder(view);
        }

        @Override
            public void onBindViewHolder(@NonNull MyHolder holder, int position) {
                holder.tv_title.setText(data.get(position));
        }

                @Override
            public int getItemCount() {
                return data.size();
        }

            class MyHolder extends RecyclerView.ViewHolder {
                TextView tv_title;

                public MyHolder(@NonNull View itemView) {
                    super(itemView);
                    tv_title = itemView.findViewById(R.id.tv_title);
            }
        }

    }
}

