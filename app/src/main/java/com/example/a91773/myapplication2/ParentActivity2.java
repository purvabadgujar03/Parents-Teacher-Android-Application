package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ParentActivity2 extends AppCompatActivity {

    TextView tvName;
    Button btnResult,btnMeeting,btnLogout;
    SharedPreferences sp5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent2);

        tvName=findViewById(R.id.tvName);
        btnLogout=findViewById(R.id.btnLogout);
        btnMeeting=findViewById(R.id.btnMeeting);
        btnResult=findViewById(R.id.btnResult);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp5=getSharedPreferences("f1",MODE_PRIVATE);
        String name=sp5.getString("name","");
        tvName.setText("Welcome "+name+"'s Parent");

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentActivity2.this,ParentActivity4.class);
                startActivity(i);
                finish();
            }
        });

        btnMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentActivity2.this,ParentActivity3.class);
                startActivity(i);
                finish();
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentActivity2.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}































