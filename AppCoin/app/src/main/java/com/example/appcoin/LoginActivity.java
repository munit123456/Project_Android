package com.example.appcoin;

import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView username = (TextView) findViewById(R.id.editText_email);
        TextView password = (TextView) findViewById(R.id.editText_password);

        Button btn_login = (Button) findViewById(R.id.button_Login);
        Button btn_back = (Button) findViewById(R.id.button_back);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")){
                    Intent intent = new Intent(LoginActivity.this, AppActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
