package com.example.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.HashMap;
import java.util.Map;

public class content_page extends AppCompatActivity {
    static String json1_title="";
    static String json2_content="";
    static String json3_id="";
    static String json4_writer="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_page);
        if (Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);


        }



        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        overlapmethod();


        Button writerview_textview = (Button) findViewById(R.id.fix_button);
        writerview_textview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                Intent registerintent=new Intent(content_page.this, passwordcheck_page.class);
                content_page.this.startActivity(registerintent);
            }
        });





    }



    public void overlapmethod() {

        TextView contentview_textview = (TextView) findViewById(R.id.fixcontent_edit);
        TextView titleview_textview = (TextView) findViewById(R.id.fixtitle_edit);
        TextView writerview_textview = (TextView) findViewById(R.id.fixwriter_textview);




        String url = "http://192.168.1.100/joinphp/contentpage.php";
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        System.out.println("response2"+response);

                        try {
                            JSONParser jsonParser = new JSONParser();
                            JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
                            JSONObject json0 = (JSONObject) jsonObject.get("result");
                             json1_title = (String) json0.get("title");
                             json2_content = (String) json0.get("content");
                             json3_id= (String) json0.get("id");
                            json4_writer = (String) json0.get("writer");
                            contentview_textview.setText(json2_content);
                            titleview_textview.setText(json1_title);
                            writerview_textview.setText(json4_writer);
                        } catch (NullPointerException| ParseException e) {
                            System.out.println(e);
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
        ) {
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("title_php", homepage.gettitle);
                return params;
            }
        };

        staticmethod.requestQueue.add(request);


    }






}