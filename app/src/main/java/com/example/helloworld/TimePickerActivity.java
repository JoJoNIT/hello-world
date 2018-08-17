package com.example.helloworld;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.TimePickerDialog;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.NumberFormat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;


import java.lang.reflect.Field;
import java.sql.Time;
import java.util.Arrays;


public class TimePickerActivity extends AppCompatActivity {
//        implements TimePickerDialog.OnTimeSetListener{


     private static final String TAG = "TimePickerActivity";
    private Spinner spinner;
    private TimePicker tp1,tp2;


//    public void onTimeSet(RadialPickerLayout view,int hourOfDay,int minute,int second){
//        String time = "You picker the following time:"+hourOfDay+"h"+minute+"m"+second;
//    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        tp1 = (TimePicker)findViewById(R.id.tp1);
        tp1.setIs24HourView(true);
        tp2 = (TimePicker)findViewById(R.id.tp2);
        tp2.setIs24HourView(true);
        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Log.e(TAG, "onTimeChanged: "+i );
            //    Toast.makeText(getApplicationContext(),i,Toast.LENGTH_LONG).show();
            }
        });
        Resources systemResources = Resources.getSystem();
        int hourNumberPickerId = systemResources.getIdentifier("hour","id","android");
        int minuteNumberPickerId = systemResources.getIdentifier("minute","id","android");
        NumberPicker hourNumberPicker = (NumberPicker) tp1.findViewById(hourNumberPickerId);
        NumberPicker minuteNumberPicker = (NumberPicker) tp1.findViewById(minuteNumberPickerId);
        setNumberPickerDivider( hourNumberPicker);
        setNumberPickerDivider(  minuteNumberPicker);
        NumberPicker hourNumberPicker2 = (NumberPicker) tp2.findViewById(hourNumberPickerId);
        NumberPicker minuteNumberPicker2 = (NumberPicker) tp2.findViewById(minuteNumberPickerId);
        setNumberPickerDivider( hourNumberPicker2);
        setNumberPickerDivider(  minuteNumberPicker2);
//        String[] Time = initTime();
//        WheelView wheelView1 = findViewById(R.id.wheel_view_wv1);
//        wheelView1.setOffset(1);
//        wheelView1.setItems(Arrays.asList(Time));
//        wheelView1.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//            public void onSelected(int selectedIndex, String item) {
//                Log.d(TAG, "selectedIndex:" + selectedIndex + ",item:" + item);
//            }
//        });
//        WheelView wheelView = findViewById(R.id.wheel_view_wv);
//        wheelView.setOffset(1);
//        wheelView.setItems(Arrays.asList(Time));
//        wheelView.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
//            public void onSelected(int selectedIndex, String item) {
//                Log.d(TAG, "selectedIndex:" + selectedIndex + ",item:" + item);
//            }
//        });

        String[] ctype = new String[]{"重复", "每日", "工作日", "自定义"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_gallery_item);     //设置下拉列表框的下拉选项样式
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


    }

//    @Override
//    public void onTimeSet(TimePicker timePicker, int i, int i1) {
//        String time = "You picked the following time: "+i+"h"+i1+"m";
//        Log.e(TAG, "onTimeSet: "+time );
//    }

//    private String[] initTime() {
//        String[] time = new String[48];
//        for (int i = 0; i < 24; i++) {
//            String hour = String.valueOf(i);
//            if (i < 10) {
//                hour = "0" + hour;
//            }
//            time[i * 2] = hour + ":00";
//            time[i * 2 + 1] = hour + ":30";
//        }
//        return time;
//    }

    private void setNumberPickerDivider(NumberPicker numberPicker) {
        final int count = numberPicker.getChildCount();
        for(int i = 0; i < count; i++){
            try{
                Field dividerField = numberPicker.getClass().getDeclaredField("mSelectionDivider");
                dividerField.setAccessible(true);
                ColorDrawable colorDrawable = new ColorDrawable(
                        ContextCompat.getColor(this, android.R.color.holo_blue_light));
                dividerField.set(numberPicker,colorDrawable);
                numberPicker.invalidate();
            }
            catch(NoSuchFieldException | IllegalAccessException | IllegalArgumentException e){
                Log.w("setNumberPickerTxtClr", e);
            }
        }
    }


}
