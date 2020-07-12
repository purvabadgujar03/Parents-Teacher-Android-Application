package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StudentActivity2 extends AppCompatActivity {

    SharedPreferences sp,sp4;
    TextView tvName;
    Button btnAnnouncement,btnAssignment,btnResult,btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student2);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp.getString("name","");

        tvName=findViewById(R.id.tvName);
        btnAnnouncement=findViewById(R.id.btnAnnouncement);
        btnAssignment=findViewById(R.id.btnAssignment);
        btnLogout=findViewById(R.id.btnLogout);
        btnResult=findViewById(R.id.btnResult);
        tvName.setText("Welcome "+name);
btnAnnouncement.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i= new Intent(StudentActivity2.this,StudentActivity3.class);
        startActivity(i);
        finish();

    }
});

        btnAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(StudentActivity2.this,StudentActivity4.class);
                startActivity(i);
                finish();

            }
        });

    btnLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i= new Intent(StudentActivity2.this,MainActivity.class);
            startActivity(i);
            finish();

        }
    });


    btnResult.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i=new Intent(StudentActivity2.this,StudentActivity5.class);
            startActivity(i);
            finish();
        }
    });


    }
}
















