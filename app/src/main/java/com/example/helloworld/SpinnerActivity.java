package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import com.skateboard.zxinglib.CaptureActivity;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button mBtnsubmit;
    private ImageView mIvpicture;
    private EditText mEtid,mEtdetail;
    private String deviceInfo,cardNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        String[] ctype = new String[]{"智慧服务", "故障报修", "个人中心", "充值缴费", "吐槽"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String cardNumber = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mEtid = findViewById(R.id.et_id);

        mEtdetail=findViewById(R.id.et_detail);
        mBtnsubmit = findViewById(R.id.btn_submit);
        mBtnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String deviceId = mEtid.getText().toString().trim();
                String detail = mEtdetail.getText().toString().trim();



                Toast.makeText(SpinnerActivity.this,"提交成功"+ deviceId+cardNumber +detail,Toast.LENGTH_SHORT).show();
            }
        });

        mIvpicture = findViewById(R.id.iv_picture);
        mIvpicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SpinnerActivity.this,CaptureActivity.class);
                startActivityForResult(intent,1001);
            }

        });

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1001 && resultCode== Activity.RESULT_OK)
        {
            deviceInfo = data.getStringExtra(CaptureActivity.KEY_DATA);
            mEtid.setText(deviceInfo.split("#")[0]);
            Toast.makeText(SpinnerActivity.this, deviceInfo, Toast.LENGTH_SHORT).show();
        }
    }
}
