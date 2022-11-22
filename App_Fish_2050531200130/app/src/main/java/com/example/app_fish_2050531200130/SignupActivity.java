package com.example.app_fish_2050531200130;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignup;
    private EditText txtEmail, txtPass;
    private TextView tvLogin;
    private FirebaseAuth mAuth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
        btnSignup = findViewById(R.id.btn_Signup);
        txtEmail = findViewById(R.id.txt_Email_su);
        txtPass = findViewById(R.id.txt_Email_su);
        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
            }
        });
    }

    private void Signup() {
        String email, pass;
        email = txtEmail.getText().toString();
        pass = txtPass.getText().toString();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập email!!", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Vui lòng nhập password!!", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Tạo tài khoản thành công!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Tạo tài khoản thất bại!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}