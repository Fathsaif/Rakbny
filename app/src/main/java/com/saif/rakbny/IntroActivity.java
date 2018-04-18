package com.saif.rakbny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }
    public void signinBtn(View view){

        startActivity(new Intent(this,SignInActivity.class));
    }
    public void signupBtn(View view){
        startActivity(new Intent(this,SignUpActivity.class));

    }
}
