package com.example.dell.four;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle extras = getIntent().getExtras();
        String data = extras.getString("data");

        System.out.println("received submission at ProfileActi :" + data);

        ProfilePost post= new ProfilePost();
        String para= null;
        try {
            para = post.execute(data).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONObject jobj = new JSONObject(para);
            System.out.println("json tester "+jobj.get("name").toString());


            TextView mEdit = (TextView) findViewById(R.id.id);
            mEdit.setText("@"+jobj.get("id").toString());

            TextView mEdit1 = (TextView) findViewById(R.id.name);
            mEdit1.setText(jobj.get("name").toString());

            TextView mEdit2 = (TextView) findViewById(R.id.status);
            mEdit2.setText(jobj.get("status").toString());

            final String flink=jobj.get("flink").toString();

            Button facebook= (Button) findViewById(R.id.button2);
            facebook.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    try {
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(flink));
                        startActivity(myIntent);
                    } catch (ActivityNotFoundException e) {

                    }
                }
            });

            System.out.println("data is: " + data);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ImageView mImageView;
        mImageView = (ImageView) findViewById(R.id.image);


    }



}
