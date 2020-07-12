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

public class ParentActivity1 extends AppCompatActivity {

    Button btnLogin, btnNot, btnRegister, btnBack;
    EditText etPhone, etUsername, etPassword, etEmail, etRoll, etSt;
    FirebaseDatabase database;
    DatabaseReference DbParents, DbStudents;
    SharedPreferences sp5, sp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent1);

        int o = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        setRequestedOrientation(o);

        etRoll = findViewById(R.id.etRoll);
        btnBack = findViewById(R.id.btnBack);
        btnLogin = findViewById(R.id.btnLogin);
        etSt = findViewById(R.id.etSt);
        btnNot = findViewById(R.id.btnNot);
        etPhone = findViewById(R.id.etPhone);
        btnRegister = findViewById(R.id.btnRegister);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        database = FirebaseDatabase.getInstance();
        DbParents = database.getReference("parents");
        sp5 = getSharedPreferences("f1", MODE_PRIVATE);
        DbStudents = database.getReference("students");
        sp6 = getSharedPreferences("f4", MODE_PRIVATE);

        btnNot.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                etPhone.setVisibility(0);
                btnLogin.setVisibility(-1);
                btnRegister.setVisibility(0);
                btnNot.setVisibility(-1);
                etEmail.setVisibility(0);
                etRoll.setVisibility(0);
                etSt.setVisibility(0);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ParentActivity1.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String em = etEmail.getText().toString();
                final String pw = etPassword.getText().toString();
                final String un = etUsername.getText().toString();
                final String pn = etPhone.getText().toString();
                final String username = etSt.getText().toString();
                final String rn = etRoll.getText().toString();


                if (un.length() < 2) {
                    etUsername.setError("Please enter correct username");
                    etUsername.setText("");
                    etUsername.requestFocus();
                } else if (!em.contains("@gmail.com")) {
                    etEmail.setError("Please enter correct email id");
                    etEmail.setText("");
                    etEmail.requestFocus();
                } else if (pw.length() < 3) {
                    etPassword.setError("please enter atleast 3 characters");
                    etPassword.setText("");
                    etPassword.requestFocus();
                } else if (pn.length() != 10) {
                    etPhone.setError("please enter valid phone  number");
                    etPhone.setText("");
                    etPhone.requestFocus();
                } else {

                    DbStudents.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            //s.clear();
                            int a = 0;
                            for (DataSnapshot d : dataSnapshot.getChildren()) {
                                Students data = d.getValue(Students.class);
                                if (data.getStRoll().equals(rn) && data.getStUsername().equals(username)) {
                                    a = 1;
                                    break;
                                }
                                //  s.add(data);
                            }
                            if (a == 0) {
                                Toast.makeText(ParentActivity1.this, "Please enter correct username and roll number of student", Toast.LENGTH_SHORT).show();
                            } else {
                                Parents s = new Parents( pw, em, pn,un,username, rn);
                                DbParents.child(un).setValue(s);
                                SharedPreferences.Editor editor = sp5.edit();
                                editor.putString("name", username);
                                editor.commit();
                                SharedPreferences.Editor editor1 = sp6.edit();
                                editor1.putString("roll", rn);
                                editor1.commit();

                                Intent i = new Intent(ParentActivity1.this, ParentActivity2.class);
                                startActivity(i);
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                        }


                    });


                }
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = etPassword.getText().toString();
                final String username = etUsername.getText().toString();

                DbParents.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //s.clear();
                        int a = 0;
                        for (DataSnapshot d1 : dataSnapshot.getChildren()) {
                            Parents data = d1.getValue(Parents.class);
                            Toast.makeText(ParentActivity1.this, "cc"+data.getStUsername(), Toast.LENGTH_SHORT).show();
                            String rn=data.getStRoll();
                            String un=data.getStUn();

                            if (data.getStPassword().equals(password) && data.getStUsername().equals(username)) {
                                a = 1;
                                //SharedPreferences.Editor editor=sp.edit();
                                //editor.putString("name",username);
                                //editor.commit();
                                SharedPreferences.Editor editor = sp5.edit();
                                editor.putString("name", un);
                                editor.commit();
                                SharedPreferences.Editor editor1 = sp6.edit();
                                editor1.putString("roll", rn);
                                editor1.commit();

                                Intent i = new Intent(ParentActivity1.this, ParentActivity2.class);
                                startActivity(i);
                                finish();
                                break;
                            }
                            //  s.add(data);

                        }
                        if (a == 0) {
                            Toast.makeText(ParentActivity1.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

            ;
        });
    }
}















