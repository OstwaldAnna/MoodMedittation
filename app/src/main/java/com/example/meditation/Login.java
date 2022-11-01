package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    private Button btn_signIn;
    private EditText et_email;
    private EditText et_password;

    private Button btn_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_signIn = findViewById(R.id.btn_signIn);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        btn_profile = findViewById(R.id.btn_profile);
        btn_profile.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Profile.class);
            startActivity(intent);
            finish();
        });
        btn_signIn.setOnClickListener(v -> startActivity(new Intent(this, Main.class)));

//        btn_signIn.setOnClickListener(view -> {
//            if(et_email.getText().toString().contains("@") && !et_password.getText().toString().equals("")) {
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("email",et_email.getText().toString());
//                    jsonObject.put("password",et_password.getText().toString());
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                String url = "http://mskko2021.mad.hakta.pro/api/user/login";
//                RequestQueue mRequestQueue = Volley.newRequestQueue(Login.this); // очередь запросов
//                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Intent intent = new Intent(Login.this, Main.class);
//                            startActivity(intent);
//                            finish();
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(Login.this,"Не правильно введены данные",Toast.LENGTH_LONG).show();
//                    }
//                });
//                mRequestQueue.add(request);
//
//            }
//            else{
//                Toast.makeText(Login.this, R.string.no_user_input,Toast.LENGTH_LONG).show();
//            }
//        });

    }


}
