package com.example.mylogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView username,password;
    Button register,login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username.findViewById(R.id.username);
        password.findViewById(R.id.password);
        register.findViewById(R.id.register);
        login.findViewById(R.id.login);
        DB = new DBHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();

                if(TextUtils.isEmpty(pass)||TextUtils.isEmpty(user)){
                    Toast.makeText(MainActivity.this,"all fields are required!",Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkuser = DB.checkuser(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertdata(user,pass);
                        if(insert==true){
                            Toast.makeText(MainActivity.this,"registration successfully",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this,"registration failed",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Something went wrong!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}