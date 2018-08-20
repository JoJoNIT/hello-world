package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtn3;
    private TextView mTv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Button mBtn1 = findViewById(R.id.btn_1);
        mBtn1.setOnClickListener(this);
        Button mBtn4 = findViewById(R.id.btn_4);
        mBtn4.setOnClickListener(this);


        mBtn3 = findViewById(R.id.btn_3);
        mBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"btn3被点击了",Toast.LENGTH_SHORT).show();
            }
        });
        mTv1 = (TextView)findViewById(R.id.tv_1);
        mTv1.setOnClickListener(this);
  }
    public void showToast(View view){
        Toast.makeText(this,"btn4被点击了",Toast.LENGTH_SHORT).show();
    }
    public void b(View view){
        Toast.makeText(ButtonActivity.this,"button2被点击了",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                Toast.makeText(ButtonActivity.this,"button1被点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4:
                Toast.makeText(ButtonActivity.this,"button4被点击了",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_1 :
                Toast.makeText(ButtonActivity.this,"tv1被点击了",Toast.LENGTH_SHORT).show();
        }
    }
}
