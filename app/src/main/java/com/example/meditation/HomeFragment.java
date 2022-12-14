package com.example.meditation;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        responseData();
        rv = (RecyclerView) getView().findViewById(R.id.horizontalFragmentHome);
        //dataSource = Profile.dataSource;
        dataSource = new ArrayList<>();

        myRvAdapter = new HomeFragment.MyAdapter(dataSource);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(myRvAdapter);
    }

    RecyclerView rv;
    ArrayList<Feeling> dataSource;
    LinearLayoutManager linearLayoutManager;
    HomeFragment.MyAdapter myRvAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

        ArrayList<Feeling> data;
        public MyAdapter(ArrayList<Feeling> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.rv_item, parent, false);
            return new HomeFragment.MyAdapter.MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {
            holder.tvTitle.setText(data.get(position).getTitle());
            Picasso.get().load(data.get(position).getImg()).resize(125,125)
                    .into(holder.imageView);
//            try {
//                URL url = new  URL(data.get(position).getImg());
//                Bitmap img = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                holder.imageView.setImageBitmap(img);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {
            TextView tvTitle;
            ImageView imageView;

            public MyHolder(@NonNull View itemView) {
                super(itemView);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                imageView = itemView.findViewById(R.id.imageView2);
            }
        }
    }

    private void responseData() {
        String url = "http://mskko2021.mad.hakta.pro/api/feelings";
        RequestQueue mRequestQueue = Volley.newRequestQueue(getContext()); // ?????????????? ????????????????
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                JSONArray res = response.getJSONArray("data");
                for (int i = 0; i < res.length(); i++){
                    System.out.println(res.getJSONObject(i).getString("title"));
                    dataSource.add(new Feeling(res.getJSONObject(i).getString("image"),
                            res.getJSONObject(i).getString("title")));
                }
                myRvAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }, error -> {
        });
        mRequestQueue.add(request);
    }
}





