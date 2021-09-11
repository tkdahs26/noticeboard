package com.example.board;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class registerclass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerclass);

        TextView backbtn = (TextView) findViewById(R.id.backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent = new Intent(registerclass.this, MainActivity.class);
                registerclass.this.startActivity(registerintent);
            }
        });


        Button joinbtn = (Button) findViewById(R.id.join_btn);
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send();
            }
        });
        if (staticmethod.requestQueue == null) {
            staticmethod.requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

    }


    public void send() {
        String url = "http://192.168.1.100/joinphp/phpa.php";
        EditText joinid_edit = (EditText) findViewById(R.id.joinid_edit);
        EditText password_edit = (EditText) findViewById(R.id.password_edit);
        EditText password2_edit = (EditText) findViewById(R.id.password2_edit);
        EditText name_edit = (EditText) findViewById(R.id.name_edit);
        final String joinid_str = joinid_edit.getText().toString();
        final String password_str = password_edit.getText().toString();
        final String password2_str = password2_edit.getText().toString();
        final String name_str = name_edit.getText().toString();

        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(registerclass.this);
                        builder.setMessage(response + "성공")
                                .create()
                                .show();

                        System.out.println(response+"성공");
                    }
                }
                ,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(registerclass.this);
                        builder.setMessage(error.getMessage() + "실패")
                                .create()
                                .show();
                        System.out.println(error+"실패");
                    }
                }
        ) {@Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("joinid", joinid_str);
                params.put("joinpassword", password_str);
                params.put("joinpassword2", password2_str);
                params.put("joinname", name_str);

                return params;
        }
        };

        staticmethod.requestQueue.add(request);

    }

}