package com.example.connect_firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    private EditText edmasv, edname, edtuoi, edlop;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initui();

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int masv = Integer.parseInt(edmasv.getText().toString().trim());
                int tuoi = Integer.parseInt(edtuoi.getText().toString().trim());
                String name = edname.getText().toString().trim();
                String lop = edlop.getText().toString().trim();
                sinhvien sv = new sinhvien(masv, tuoi, name, lop);

                onClickAddSV(sv);
            }
        });
    }

    private void initui(){
        edmasv = findViewById(R.id.home_addmasv);
        edname = findViewById(R.id.home_addname);
        edtuoi = findViewById(R.id.home_addtuoi);
        edlop = findViewById(R.id.home_addlop);
        btnadd = findViewById(R.id.btn_homeadd);
    }

    private void onClickAddSV(sinhvien sv){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sinhvien");



        String pathObject = String.valueOf(sv.getMasv());
        myRef.child(pathObject).setValue(sv, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Toast.makeText(HomeActivity.this, "Thêm sinh viên thành công!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}