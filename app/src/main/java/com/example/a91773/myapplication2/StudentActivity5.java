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

    public class StudentActivity5 extends AppCompatActivity {

    TextView textView;
    SharedPreferences sp,sp4;
    String name, roll;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student5);
        textView = findViewById(R.id.textView);
        sp=getSharedPreferences("f1",MODE_PRIVATE);
        name=sp.getString("name","");
        sp4=getSharedPreferences("f4",MODE_PRIVATE);
        roll=sp4.getString("name","");

        btnBack=findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StudentActivity5.this,StudentActivity2.class);
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
            while (true) {
                try {
                    if ((string = reader.readLine()).equals(s)) break;
                    if ((string = reader.readLine()) == null) break;
                }
                catch (IOException e) {
                    e.printStackTrace();
                }


            }
            stringBuilder.append(string).append("\n");
            x = reader.readLine();
            stringBuilder.append(x).append("\n");
            textView.setText(stringBuilder);

            //x=reader.readLine();
            //stringBuilder.append(x).append("\n");
            ((InputStream) is).close();
            Toast.makeText(getBaseContext(), stringBuilder.toString(),
                    Toast.LENGTH_LONG).show();
        }

}