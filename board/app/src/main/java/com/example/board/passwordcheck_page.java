package com.example.board;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class passwordcheck_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordcheck_page);



        Button passwordcheck_button = (Button) findViewById(R.id.passwordcheck_button);
            passwordcheck_button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void  onClick(View view) {
                    EditText passwordcheck_edit = (EditText) findViewById(R.id.passwordcheck_edit);
                    String check_edit = passwordcheck_edit.getText().toString();
                    System.out.println("first_page"+first_page.json2);
                    System.out.println("check_edit"+check_edit);
                    if (first_page.json2.equals(check_edit)) {

                        Intent registerintent = new Intent(passwordcheck_page.this, fixcontent_page.class);
                        passwordcheck_page.this.startActivity(registerintent);
                    }
                    else{
                        AlertDialog.Builder builder = new AlertDialog.Builder(passwordcheck_page.this);
                        builder.setTitle("비밀번호가 일치하지 않습니다");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }

                }
            });





    }



}