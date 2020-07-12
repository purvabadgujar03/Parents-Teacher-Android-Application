package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;

public class StudentActivity4 extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 234;

    Button btnSubmit,btnSelect,btnBack;
    ImageView ivFile;
    Spinner spSubject;
    Uri filePath;
    SharedPreferences sp,sp4;
    String m= "",name,roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student4);
        btnSelect=findViewById(R.id.btnSelect);
        btnSubmit=findViewById(R.id.btnSubmit);
        ivFile=findViewById(R.id.ivFile);
        btnBack=findViewById(R.id.btnBack);
        spSubject=findViewById(R.id.spSubject);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
         name=sp.getString("name","");
        sp4=getSharedPreferences("f4",MODE_PRIVATE);
         roll=sp4.getString("name","");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(StudentActivity4.this,StudentActivity2.class);
                startActivity(i);
                finish();
            }
        });


        final ArrayList<String> s=new ArrayList<>();
        s.add("DBMS");
        s.add("OS");
        s.add("Maths");
        s.add("COA");
        s.add("AOA");
        s.add("CN");
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,s);
        spSubject.setAdapter(arrayAdapter);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id1 =spSubject.getSelectedItemPosition();
                final String sub=s.get(id1);
                m=m+"Name of Student :"+name+"\nRoll Number :"+roll+"\nSubject  :"+sub;
                Intent s=new Intent(Intent.ACTION_SEND);
                s.setType("text/plain");
                s.putExtra(Intent.EXTRA_TEXT,m);
                startActivity(s);
            }
        });


    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                ivFile.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}




















