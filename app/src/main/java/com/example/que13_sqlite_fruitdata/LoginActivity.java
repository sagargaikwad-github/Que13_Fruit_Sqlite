package com.example.que13_sqlite_fruitdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView user_tv,pass_tv;
    Button login_btn;
    TextView newuser_tv;
    int log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_tv=findViewById(R.id.login_username);
        pass_tv=findViewById(R.id.login_password);
        login_btn=findViewById(R.id.login_button);
        newuser_tv=findViewById(R.id.new_register_textview);

//
        SharedPreferences sharedPreferences=getSharedPreferences("Register",MODE_PRIVATE);
        String log_email=sharedPreferences.getString("Email"," ");
        String log_password=sharedPreferences.getString("Password"," ");

       user_tv.setText(log_email);
//     pass.setText(log_password);
//        String e=user.getText().toString();
//        String p=pass.getText().toString();


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String e=user_tv.getText().toString().trim();
                String p=pass_tv.getText().toString().trim();


//
//                SharedPreferences islogin=getSharedPreferences("Login",MODE_PRIVATE);
//                SharedPreferences.Editor editor=islogin.edit();
//                editor.putString("login","LOGIN");
//                editor.apply();


                DBManager dbManager=new DBManager(LoginActivity.this);

                if(e.equals("") || p.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Please provide username and password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   boolean login=dbManager.login(e,p);
                   if(login==true)
                   {
                       SharedPreferences Login=getSharedPreferences("Login1",MODE_PRIVATE);
                       String a="LOGIN";
                       SharedPreferences.Editor myedit=Login.edit();
                       myedit.putString("isLogin", a);
                       myedit.apply();

                       Intent intent=new Intent(LoginActivity.this,FruitMainActivity.class);
                       startActivity(intent);

                   }
                   else
                   {
                       Toast.makeText(LoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                   }
                   
                }
            }
        });
        newuser_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              SharedPreferences.Editor newedit=sharedPreferences.edit();
              newedit.clear();
              newedit.apply();

                Intent register=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(register);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}