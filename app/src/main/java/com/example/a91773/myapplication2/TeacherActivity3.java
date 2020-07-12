package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TeacherActivity3 extends AppCompatActivity {
    SharedPreferences sp1,sp2,sp3;
EditText etNote;
Button btnSubmit,btnBack;
    Spinner spSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher3);
        btnBack=findViewById(R.id.btnBack);
        spSubject=findViewById(R.id.spSubject);
        etNote=findViewById(R.id.etNote);
        btnSubmit=findViewById(R.id.btnSubmit);
        sp1=getSharedPreferences("f1",MODE_PRIVATE);
        sp2=getSharedPreferences("f2",MODE_PRIVATE);
        final ArrayList<String> s=new ArrayList<>();
        s.add("DBMS");
        s.add("OS");
        s.add("Maths");
        s.add("COA");
        s.add("AOA");
        s.add("CN");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,s);
        spSubject.setAdapter(arrayAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id1 =spSubject.getSelectedItemPosition();
                final String sub=s.get(id1);
                final Editable con=etNote.getText();
                SharedPreferences.Editor editor=sp1.edit();
                editor.putString("sub",sub);
                editor.commit();
                SharedPreferences.Editor editor1=sp2.edit();
                editor1.putString("con", String.valueOf(con));
                editor1.commit();
                Toast.makeText(TeacherActivity3.this, "Assignment Submitted", Toast.LENGTH_SHORT).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   Intent i=new Intent(TeacherActivity3.this,TeacherActivity2.class);
                   startActivity(i);
                   finish();
                }
            });

    }
}