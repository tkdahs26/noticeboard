package com.example.board;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerclass);



        TextView backbtn = (TextView) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(register_page.this, first_page.class);
                register_page.this.startActivity(registerintent);
            }
        });


        EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
        EditText password_edit = (EditText) findViewById(R.id.password_edit);
        EditText password2_edit = (EditText) findViewById(R.id.password2_edit);
        EditText email_edit = (EditText) findViewById(R.id.email_edit);

         String joinid_text = joinid_edit.getText().toString();
          String password_text = password_edit.getText().toString();
         String password_text2 = password2_edit.getText().toString();
          String name_text = email_edit.getText().toString();

        Button joinbtn = (Button) findViewById(R.id.join_btn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(joinid_edit.getText().toString().isEmpty()||password_edit.getText().toString().isEmpty()||email_edit.getText().toString().isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(register_page.this);
                    builder.setMessage("빈칸이 있습니다");
                    builder.create();
                    builder.show();
                }
                else if(!password_edit.getText().toString().equals(password2_edit.getText().toString())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(register_page.this);
                    builder.setMessage("비밀번호가 맞지않습니다");
                    builder.create();
                    builder.show();
                }
                else{send();
                }
            }
        });
        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }




    }


        public void send() {
            String url = "http://192.168.1.100/joinphp/register_php.php";
            EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
            EditText password_edit = (EditText) findViewById(R.id.password_edit);
            EditText password2_edit = (EditText) findViewById(R.id.password2_edit);
            EditText email_edit = (EditText) findViewById(R.id.email_edit);
            final String joinid_str = joinid_edit.getText().toString();
            final String password_str = password_edit.getText().toString();
            final String password2_str = password2_edit.getText().toString();
            final String email_str = email_edit.getText().toString();

            StringRequest request = new StringRequest(
                    Request.Method.POST,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register_page.this);
                            builder.setTitle("회원가입 성공");
                            builder.setPositiveButton("로그인하기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭");
                                    Intent registerintent = new Intent(register_page.this, first_page.class);
                                    register_page.this.startActivity(registerintent);
                                }
                            });
                            builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭");
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();


                            System.out.println(response + "성공");
                        }
                    }
                    ,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(register_page.this);
                            builder.setTitle("회원가입 실패");
                            builder.setPositiveButton("뒤로가기", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    System.out.println("버튼클릭");

                                    Intent registerintent = new Intent(register_page.this, first_page.class);
                                    register_page.this.startActivity(registerintent);
                                }
                            });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                            System.out.println(error + "실패");
                        }
                    }
            ) {
                @Override
                public Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("joinid", joinid_str);
                    params.put("joinpassword", password_str);
                    params.put("joinpassword2", password2_str);
                    params.put("joinemail",email_str);

                    return params;
                }
            };

            staticmethod.requestQueue.add(request);


    }

}