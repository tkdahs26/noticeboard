package com.example.board;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Html;
import android.view.View;
import android.view.ViewStructure;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

public class _2_0homepage extends AppCompatActivity {
    ArrayList<TextView> id_view=new ArrayList<TextView>();
    ArrayList<TextView> title_view=new ArrayList<TextView>();
    ArrayList<TextView> writer_view=new ArrayList<TextView>();
static String gettitle="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._2_0activity_homepage);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        id_view.add(findViewById(R.id.id1));
        id_view.add(findViewById(R.id.id2));
        id_view.add(findViewById(R.id.id3));
        id_view.add(findViewById(R.id.id4));
        id_view.add(findViewById(R.id.id5));

        title_view.add(findViewById(R.id.title1));
        title_view.add(findViewById(R.id.title2));
        title_view.add(findViewById(R.id.title3));
        title_view.add(findViewById(R.id.title4));
        title_view.add(findViewById(R.id.title5));

        writer_view.add(findViewById(R.id.writer1));
        writer_view.add(findViewById(R.id.writer2));
        writer_view.add(findViewById(R.id.writer3));
        writer_view.add(findViewById(R.id.writer4));
        writer_view.add(findViewById(R.id.writer5));

        ImageButton backbtn = (ImageButton) findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent registerintent = new Intent(_2_0homepage.this, _1_0first_page.class);
                _2_0homepage.this.startActivity(registerintent);
            }
        });

        ImageButton gowritepage_btn = (ImageButton) findViewById(R.id.gowritepage_btn);
        gowritepage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(_2_0homepage.this, _2_1write_page.class);
                _2_0homepage.this.startActivity(registerintent);
            }
        });

        ImageButton refresh = (ImageButton) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(_2_0homepage.this, _2_0homepage.class);
                _2_0homepage.this.startActivity(registerintent);
            }
        });


        Iterator<TextView> iter2 = title_view.iterator();
        while(iter2.hasNext()){
            TextView iternext= (TextView) iter2.next();
            iternext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(iternext.getId());
                    System.out.println(iternext.getText());
                    gettitle= (String) iternext.getText();
                    Intent registerintent = new Intent(_2_0homepage.this, _3_0content_page.class);
                    _2_0homepage.this.startActivity(registerintent);
                }
            });
        }




        homepage_method();
    }


    @Override
    public void onBackPressed() {
        Intent registerintent = new Intent(_2_0homepage.this, _1_0first_page.class);
        _2_0homepage.this.startActivity(registerintent);
        super.onBackPressed();
    }



    public void homepage_method() {

        String url = "http://tidahk.dothome.co.kr/homepage.php";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("response\n" + response);
                        try {
                            StringBuilder sb0=new StringBuilder();
                            StringBuilder sb1=new StringBuilder();
                            StringBuilder sb2=new StringBuilder();
                            StringBuilder sb3=new StringBuilder();
                            String[] sp0=new String[100];
                            String[] sp1=new String[100];
                            String[] sp2=new String[100];
                            String[] sp3=new String[100];
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject1 = (JSONObject) jsonParser.parse(response);
                            JSONArray json0 = (JSONArray) jsonObject1.get("result");
                            for (int i = 0; i < json0.size(); i++) {
                                JSONObject json1 = (JSONObject) json0.get(i);
                                String json2 = (String) json1.get("index");
                                String json3 = (String) json1.get("title");

                                String json5 = (String) json1.get("writer");
                                sb0.append(json2+"split");
                                sb1.append(json3+"split");

                                sb3.append(json5+"split");

                            }
                            sp0=sb0.toString().split("split");
                            sp1=sb1.toString().split("split");
                            sp3=sb3.toString().split("split");

                            for(int i=0;i<sp0.length;i++){
                                id_view.get(i).setText(sp0[i]);
                                title_view.get(i).setText(sp1[i]);
                                writer_view.get(i).setText(sp3[i]);
                            }

                        } catch (ParseException|NullPointerException e) {
                            e.printStackTrace();
                        }

                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error + "통신실패");
                    }
                }
        );

        staticmethod.requestQueue.add(request);


    }
















}