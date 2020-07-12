package com.example.a91773.myapplication2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ParentActivity4 extends AppCompatActivity {

    SharedPreferences sp6,sp5;
    TextView textView;
    String name, roll;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent4);
        textView = findViewById(R.id.textView);
        sp5=getSharedPreferences("f1",MODE_PRIVATE);
        name=sp5.getString("name","");
        sp6=getSharedPreferences("f4",MODE_PRIVATE);
        roll=sp6.getString("roll","");
        Toast.makeText(this, "  "+name+"   "+roll, Toast.LENGTH_SHORT).show();
        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ParentActivity4.this,ParentActivity2.class);
                startActivity(i);
                finish();
            }
        });

    }
    public void ReadTextFile(View view) throws IOException {
        //Name: amy, Roll No:06
        String s="Name: "+name+", "+"Roll No:"+roll;
        String string = "",x="";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.sample);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int a=0;
        while (true) {
            try {
                if ((string = reader.readLine()).equals(s)) {a=1;break;}
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }


        }
        if(a==1){
        stringBuilder.append(string).append("\n");
        x = reader.readLine();
        stringBuilder.append(x).append("\n");
        textView.setText(stringBuilder);}
        else{
    textView.setText("No result found");
        }

        //x=reader.readLine();
        //stringBuilder.append(x).append("\n");
        ((InputStream) is).close();
        Toast.makeText(getBaseContext(), stringBuilder.toString(),
                Toast.LENGTH_LONG).show();
    }

}