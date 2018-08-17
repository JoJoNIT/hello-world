package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity {
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//

//    }

    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText,mBtnRadioButton;
    private Button mBtnCheckBox;
    private Button mBtnSpinner;
    private Button mBtnMy,mBtnTimePicker;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_edittext);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnSpinner = findViewById(R.id.btn_spinner);
        mBtnMy = findViewById(R.id.btn_my);
        mBtnTimePicker = findViewById(R.id.btn_timepicker);
        setListeners();
    }
    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnSpinner.setOnClickListener(onClick);
        mBtnMy.setOnClickListener(onClick);
        mBtnTimePicker.setOnClickListener(onClick);
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this,TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btn_edittext:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(MainActivity.this,CheckBoxActivity.class);
                    break;
                case R.id.btn_spinner:
                    intent = new Intent(MainActivity.this,SpinnerActivity.class);
                    break;
                case R.id.btn_my:
                    intent = new Intent(MainActivity.this,MyActivity.class);
                case R.id.btn_timepicker:
                    intent = new Intent(MainActivity.this, TimePickerActivity.class);
            }
            startActivity(intent);
        }
    }
}
