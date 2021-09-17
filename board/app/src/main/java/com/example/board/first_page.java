package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button registerbutton=(Button)findViewById(R.id.register_btn);
        registerbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(first_page.this, register_page.class);
                first_page.this.startActivity(registerintent);
            }
        });






        Button loginbutton=(Button)findViewById(R.id.btn_login);
        loginbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(first_page.this,homepage.class);
                first_page.this.startActivity(registerintent);
            }
        });




        Button find_password=(Button)findViewById(R.id.find_password);
        find_password.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(first_page.this, find_page_pwd.class);
                first_page.this.startActivity(registerintent);
            }
        });

        Button find_id=(Button)findViewById(R.id.find_id);
        find_id.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(first_page.this, find_page_id.class);
                first_page.this.startActivity(registerintent);
            }
        });

    }
}