package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherActivity4 extends AppCompatActivity {

    EditText etDate, etTime, etVenue;
    Button btnSubmit, btnBack;
    SharedPreferences sp7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher4);

        etDate = findViewById(R.id.etDate);
        etTime = findViewById(R.id.etTime);
        etVenue = findViewById(R.id.etVenue);
        btnBack = findViewById(R.id.btnBack);
        btnSubmit = findViewById(R.id.btnSubmit);
        sp7 = getSharedPreferences("f4", MODE_PRIVATE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable s1 = etDate.getText();
                Editable s2 = etTime.getText();
                Editable s3 = etVenue.getText();
                String s = "Meeting will be taken on " + s1 + ", " + s2 + " in classroom " + s3;
                SharedPreferences.Editor editor = sp7.edit();
                editor.putString("n1", s);
                editor.commit();
                Toast.makeText(TeacherActivity4.this, "Submitted", Toast.LENGTH_SHORT).show();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeacherActivity4.this, TeacherActivity2.class);
                startActivity(i);
                finish();

            }
        });
    }
}
