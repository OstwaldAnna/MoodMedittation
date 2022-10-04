package com.example.meditation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Main.class);
                startActivity(intent);
                finish();
            }
        });

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(false)                   //(et_email.getText().toString().equals(""))
                    Toast.makeText(Login.this, R.string.no_user_input,Toast.LENGTH_LONG).show();
                else{
                    Intent intent = new Intent(Login.this, Profile.class);
                    startActivity(intent);
                    finish();

                }
            }
        });
    }


}
