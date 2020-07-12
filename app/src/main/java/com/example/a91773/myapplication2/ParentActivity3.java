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

public class ParentActivity3 extends AppCompatActivity {

    TextView tvCon;
    SharedPreferences sp7;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent3);
        tvCon=findViewById(R.id.tvCon);
        btnBack=findViewById(R.id.btnBack);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);
        sp7=getSharedPreferences("f4",MODE_PRIVATE);
        String name=sp7.getString("n1","");
        tvCon.setText(name);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ParentActivity3.this,ParentActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
}