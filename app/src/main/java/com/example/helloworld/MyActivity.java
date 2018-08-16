package com.example.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.helloworld.R;

public class MyActivity extends AppCompatActivity {
    private Button mBtnlogin,mBtnwhereof,mBtnhelp,mBtnupdate,mBtnedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.helloworld.R.layout.activity_my);
        mBtnlogin = findViewById(R.id.btn_login);
        mBtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "请登录", Toast.LENGTH_SHORT).show();
            }
        });
        mBtnedit = findViewById(R.id.btn_edit);

        mBtnedit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        mBtnwhereof = findViewById(R.id.btn_whereof);

        mBtnwhereof.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        mBtnhelp = findViewById(R.id.btn_help);

        mBtnhelp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
        mBtnupdate = findViewById(R.id.btn_update);

        mBtnupdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });
    }
}
