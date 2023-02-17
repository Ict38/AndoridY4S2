package com.example.chuong3tbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt1, edt2;
    TextView tv1;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding);
        initGUI();
        btn1.setOnClickListener(new View.OnClickListener() { // khong de onClick trong xml
            @Override
            public void onClick(View view) {
                String edtValue1 = edt1.getText().toString();
                String edtValue2 = edt2.getText().toString();
                double n1,n2;
                try {
                    n1 = Double.parseDouble(edtValue1);
                    n2 = Double.parseDouble(edtValue2);
                    tv1.setText("Tong: " + (n1 + n2));
                }catch (NumberFormatException e ) {
                    Toast.makeText(getApplicationContext(), "De nghi nhap so", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() { // khong de onClick trong xml
            @Override
            public void onClick(View view) {
                String edtValue1 = edt1.getText().toString();
                String edtValue2 = edt2.getText().toString();
                double n1,n2;
                try {
                    n1 = Double.parseDouble(edtValue1);
                    n2 = Double.parseDouble(edtValue2);
                    tv1.setText("Hieu: " + (n1 - n2));
                }catch (NumberFormatException e ) {
                    Toast.makeText(getApplicationContext(), "De nghi nhap so", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initGUI() {
        edt1 = findViewById(R.id.sh1);
        edt2 = findViewById(R.id.sh2);
        tv1 = findViewById(R.id.tong);
        btn1 = findViewById(R.id.btnadd);
        btn2 = findViewById(R.id.btnsub);
    }
    public void tong(View v){ // Truong hop de onClick trong xml
        String edtValue1 = edt1.getText().toString();
        String edtValue2 = edt2.getText().toString();
        double n1,n2;
        try {
            n1 = Double.parseDouble(edtValue1);
            n2 = Double.parseDouble(edtValue2);
            tv1.setText("Tong:" + (n1 + n2));
        }catch (NumberFormatException e ) {
            Toast.makeText(this, "De nghi nhap so", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        if(view== btn1){
            String edtValue1 = edt1.getText().toString();
            String edtValue2 = edt2.getText().toString();
            double n1,n2;
            try {
                n1 = Double.parseDouble(edtValue1);
                n2 = Double.parseDouble(edtValue2);
                tv1.setText("Tong:" + (n1 + n2));
            }catch (NumberFormatException e ) {
                Toast.makeText(this, "De nghi nhap so", Toast.LENGTH_SHORT).show();
            }
        }
    }
}