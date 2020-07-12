package com.example.a91773.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TeacherActivity1 extends AppCompatActivity {

    Button btnLogin, btnNot, btnRegister ,btnBack;
    EditText etPhone , etUsername, etPassword , etEmail;
    FirebaseDatabase database;
    DatabaseReference DbTeachers;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1);
        int o= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        btnLogin=findViewById(R.id.btnLogin);
        btnNot=findViewById(R.id.btnNot);
        btnBack=findViewById(R.id.btnBack);
        etPhone=findViewById(R.id.etPhone);
        btnRegister=findViewById(R.id.btnRegister);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        etEmail=findViewById(R.id.etEmail);
        database=FirebaseDatabase.getInstance();
        DbTeachers= database.getReference("teachers");
        sp=getSharedPreferences("f1",MODE_PRIVATE);

        btnNot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                etPhone.setVisibility(0);
                btnLogin.setVisibility(-1);
                btnRegister.setVisibility(0);
                btnNot.setVisibility(-1);
                etEmail.setVisibility(0);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TeacherActivity1.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = etEmail.getText().toString();
                String pw = etPassword.getText().toString();
                String un = etUsername.getText().toString();
                String pn = etPhone.getText().toString();
                if (un.length()<2){
                    etUsername.setError("Please enter correct username");
                    etUsername.setText("");
                    etUsername.requestFocus();
                }
                else if (!em.contains("@ves.ac.in")){
                    etEmail.setError("Please use college email Id");
                    etEmail.setText("");
                    etEmail.requestFocus();
                }
                else if (pw.length()<3){
                    etPassword.setError("please enter atleast 3 characters");
                    etPassword.setText("");
                    etPassword.requestFocus();
                }
                else if (pn.length()!=10){
                    etPhone.setError("please enter valid phone  number");
                    etPhone.setText("");
                    etPhone.requestFocus();
                }
                else{
                    Teachers s = new Teachers( un, pw, em, pn);
                    DbTeachers.child(un).setValue(s);
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("name",un);
                    editor.commit();
                    Intent i= new Intent(TeacherActivity1.this,TeacherActivity2.class);
                    startActivity(i);
                    finish();
                }


                /*if (!TextUtils.isEmpty(un) && !TextUtils.isEmpty(pw) && !TextUtils.isEmpty(em) && pn.length()==10 ) {
                    //String id = DbStudents.push().getKey();
                    //Toast.makeText(StudentActivity1.this, "added", Toast.LENGTH_SHORT).show();
                    }
                else {
                    Toast.makeText(StudentActivity1.this, "error", Toast.LENGTH_SHORT).show();
                }*/

            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pw = etPassword.getText().toString();
                String un = etUsername.getText().toString();
                signIn(un,pw);
            }
        });

    }
    private void signIn(final String username, final String password){


        DbTeachers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //s.clear();
                int a=0;
                for(DataSnapshot d:dataSnapshot.getChildren()){
                    Students data=d.getValue(Students.class);
                    if(data.getStPassword().equals(password) && data.getStUsername().equals(username)){
                        a=1;
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("name",username);
                        editor.commit();
                        Intent i= new Intent(TeacherActivity1.this,TeacherActivity2.class);
                        startActivity(i);
                        finish();
                        break;
                    }
                    //  s.add(data);

                }
                if(a==0){
                    Toast.makeText(TeacherActivity1.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }



}






















