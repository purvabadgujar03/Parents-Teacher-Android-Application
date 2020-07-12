package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TeacherActivity2 extends AppCompatActivity {
    SharedPreferences sp;
    TextView tvName;
    Button btnAnnouncement,btnParent,btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher2);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp.getString("name","");
        tvName=findViewById(R.id.tvName);
        btnAnnouncement=findViewById(R.id.btnAnnouncement);
        btnLogout=findViewById(R.id.btnLogout);
        btnParent=findViewById(R.id.btnParent);
        tvName.setText("Welcome "+name);
        btnAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherActivity2.this,TeacherActivity3.class);
                startActivity(i);
                finish();

            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherActivity2.this,MainActivity.class);
                startActivity(i);
                finish();

            }
        });
        btnParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(TeacherActivity2.this,TeacherActivity4.class);
                startActivity(i);
                finish();

            }
        });


    }
}