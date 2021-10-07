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

import java.util.HashMap;
import java.util.Map;

public class fixcontent_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixcontent_page);




        EditText fixtitle_edit = (EditText) findViewById(R.id.fixtitle_edit);
        EditText fixcontent_edit = (EditText) findViewById(R.id.fixcontent_edit);
        TextView fixwriter_textview = (TextView) findViewById(R.id.fixwriter_textview);
        Button fix_button = (Button) findViewById(R.id.fix_button);



        fixtitle_edit.setText(content_page.json1_title);
        fixcontent_edit.setText(content_page.json2_content);
        fixwriter_textview.setText(content_page.json4_writer);

        fix_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fix_method();
            }
        });


    }






    public void fix_method() {

        EditText fixtitle_edit = (EditText) findViewById(R.id.fixtitle_edit);
        EditText fixcontent_edit = (EditText) findViewById(R.id.fixcontent_edit);
        String fixtitle = fixtitle_edit.getText().toString();
        String fixcontent = fixcontent_edit.getText().toString();
        String url = "http://192.168.1.100/joinphp/fix.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("fixcontentresponse"+response);

                        AlertDialog.Builder builder = new AlertDialog.Builder(fixcontent_page.this);
                        builder.setTitle("글쓰기 성공");
                        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                System.out.println("버튼클릭");
                            }
                        });
                        builder.setNegativeButton("나가기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent registerintent = new Intent(fixcontent_page.this, homepage.class);
                                fixcontent_page.this.startActivity(registerintent);
                            }
                        });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error + "통신실패");
                    }
                }
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("fixtitle_php", fixtitle);
                params.put("fixcontent_php", fixcontent);
                params.put("id_php", content_page.json3_id);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }




}