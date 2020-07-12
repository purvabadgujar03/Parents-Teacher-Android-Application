package com.example.a91773.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton ibStudent, ibParent, ibTeacher;
    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ibStudent = findViewById(R.id.ibStudent);
        ibParent=findViewById(R.id.ibParent);
        ibTeacher=findViewById(R.id.ibTeacher);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        ibStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(MainActivity.this,StudentActivity1.class);
                startActivity(i);
            finish();
            }
        });
     ibTeacher.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent i= new Intent(MainActivity.this,TeacherActivity1.class);
             startActivity(i);
             finish();
         }
     });

        ibParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,ParentActivity1.class);
                startActivity(i);
                finish();

            }
        });

    }
}
