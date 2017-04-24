package com.example.dell.four;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    private String name = null;
    private String email = null;
    private String  password = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText editName = (EditText) findViewById(R.id.name);
        name = String.valueOf(editName.getText());
        EditText editEmail = (EditText)findViewById(R.id.email);
        email = editEmail.getText().toString();
        EditText editPassword = (EditText) findViewById(R.id.password);
        password = editPassword.getText().toString();

        Button SignUpButton = (Button) findViewById(R.id.sign_up);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }
    public void signUp(){
        System.out.println("hello"+name+email);
        PostSignUp post = new PostSignUp();
        SignupTaskParams para= new SignupTaskParams(name,email,password);
        post.execute(para);
    }
}

class SignupTaskParams{
    private String name;
    private String email;
    private String password;

    public String getName(){
        return name;
    }
    public String getEmail(){
        return name;
    }
    public String getPassword(){
        return name;
    }

        SignupTaskParams(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}