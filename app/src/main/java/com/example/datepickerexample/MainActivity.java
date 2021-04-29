package com.example.datepickerexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker dp;
    private TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  컨트롤 연결
        dp = findViewById(R.id.datePicker);
        timeText = findViewById(R.id.timeText);

        //  DatePicker 초기화
        Calendar cal = Calendar.getInstance();
        dp.init(cal.get(Calendar.YEAR), //  년
                cal.get(Calendar.MONTH),    //  월 -> 주의: Java의 MONTH는 0부터
                cal.get(Calendar.DATE), //  일
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view,
                                              int year,
                                              int monthOfYear,  //  Java의 MONTH는 0부터
                                              int dayOfMonth) {
                        timeText.setText(String.format("%d-%02d-%02d", year, monthOfYear + 1, dayOfMonth));
                    }
                }
        );

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = dp.getYear();
                int month = dp.getMonth() + 1;
                int date = dp.getDayOfMonth();

                Toast.makeText(MainActivity.this,
                        String.format("%d-%02d-%02d", year, month, date),
                        Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}