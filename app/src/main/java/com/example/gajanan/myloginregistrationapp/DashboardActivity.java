package com.example.gajanan.myloginregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    String emailHolder;
    TextView txtEmail;
    Button btnSignOut,btnShowListOfUsers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtEmail = (TextView)findViewById(R.id.txt_signInText);
        btnSignOut = (Button)findViewById(R.id.btn_signOut);


        Intent intent = getIntent();

        // Receiving User txtEmail Send By MainActivity.
        emailHolder = intent.getStringExtra("EMAIL");

        if (emailHolder.equals("admin@gmail.com")){
            btnShowListOfUsers = (Button)findViewById(R.id.btn_showListOfUsers);
            btnShowListOfUsers.setVisibility(View.VISIBLE);

            btnShowListOfUsers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //String email=emailHolder;
                    Intent myIntent=new Intent(DashboardActivity.this,UsersListActivity.class);
                    myIntent.putExtra("email",emailHolder);
                    startActivity(myIntent);
                }
            });

        }
        else {
            btnShowListOfUsers = (Button)findViewById(R.id.btn_showListOfUsers);
            btnShowListOfUsers.setVisibility(View.INVISIBLE);
        }

        // Setting up received email to TextView.
        txtEmail.setText(txtEmail.getText().toString() + emailHolder);

        // Adding click listener to Log Out button.
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Toast.makeText(DashboardActivity.this, "Sign Out Successfull", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DashboardActivity.this, SignInActivity.class);
                startActivity(i);


            }
        });

    }
}