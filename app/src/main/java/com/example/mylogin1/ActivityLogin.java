package com.example.mylogin1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    TextView username,password;
    Button login;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username.findViewById(R.id.username1);
        password.findViewById(R.id.password1);
        login.findViewById(R.id.login1);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user  = username.getText().toString();
                String pass= password.getText().toString();
                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)){
                    Toast.makeText(ActivityLogin.this,"All field are required!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}