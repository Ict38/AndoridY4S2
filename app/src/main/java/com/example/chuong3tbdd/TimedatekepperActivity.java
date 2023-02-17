package com.example.chuong3tbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class TimedatekepperActivity extends AppCompatActivity {
    EditText txtDate, txtTime;
    Button btnDate, btnTime;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timedatekepper);
        txtDate = findViewById(R.id.dt);
        txtTime = findViewById(R.id.tt);
        btnTime = findViewById(R.id.tb);
        btnDate = findViewById(R.id.db);
        lv = findViewById(R.id.listview);
        String[] st = getResources().getStringArray(R.array.technology);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item1, st);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(TimedatekepperActivity.this, adapter.getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar q = Calendar.getInstance();
                int cy = q.get(Calendar.YEAR);
                int cm = q.get(Calendar.MONTH);
                int cd = q.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(TimedatekepperActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                        txtDate.setText(d + "/" + (m+1) + "/" + y);
                    }
                }, cy,cm,cd);
                dialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog = new TimePickerDialog(TimedatekepperActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int h, int m) {
                        txtTime.setText(h+":"+m);
                    }
                },6,53,true);
                dialog.show();
            }
        });
    }
}