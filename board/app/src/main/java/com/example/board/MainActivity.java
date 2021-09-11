package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        TextView registerbutton=(TextView)findViewById(R.id.register_btn);


        registerbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(MainActivity.this,registerclass.class);
                MainActivity.this.startActivity(registerintent);
            }
        });



    }
}