package com.example.que13_sqlite_fruitdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Handler handler=new Handler(Looper.myLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences register=getSharedPreferences("Register",MODE_PRIVATE);
                String SharedPref_Email=register.getString("Email","");
                String SharedPref_Password=register.getString("Password","");

                SharedPreferences login=getSharedPreferences("Login1",MODE_PRIVATE);
                String Check_Login=login.getString("isLogin","");


                if(Check_Login.equals("LOGIN"))
                {
                    Intent intent1=new Intent(SplashScreen.this,FruitMainActivity.class);
                    startActivity(intent1);
                }
                else
                {
                  if(SharedPref_Email.isEmpty())
                  {
                      Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                      startActivity(intent);
                  }
                  else
                  {
                      Intent intent=new Intent(SplashScreen.this,LoginActivity.class);
                      startActivity(intent);
                  }
                }


            }
        },2500);
    }
}