package com.example.chuong3tbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edt1, edt2;
    TextView tv1;
    Button btn1,btn2;
    Spinner spTinh;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adding);
//        initHW1();
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String username = edt1.getText().toString();
//                String password = edt2.getText().toString();
//                if(username.equals("huy") && password.equals("123")){
//                    Toast.makeText(getApplicationContext(), "Dang Nhap Thanh Cong", Toast.LENGTH_SHORT).show();
//                }
//                Toast.makeText(getApplicationContext(), "Dang Nhap That Bai", Toast.LENGTH_SHORT).show();
//            }
//        });
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
        spTinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sh1 = edt1.getText().toString();
                String sh2 = edt2.getText().toString();
                double n1,n2;
                try {
                    n1 = Double.parseDouble(sh1);
                    n2 = Double.parseDouble(sh2);
//                    String o = arrayAdapter.getItem(i).toString();
                    String o = spTinh.getSelectedItem().toString();
                    tv1.setText(tinh(n1,n2,o));
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "de nghi nhap so", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initHW1() {
        edt1 = findViewById(R.id.username);
        edt2 = findViewById(R.id.password);
        btn1 = findViewById(R.id.dn);
    }

    private void initGUI() {
        edt1 = findViewById(R.id.sh1);
        edt2 = findViewById(R.id.sh2);
        tv1 = findViewById(R.id.tong);
        btn1 = findViewById(R.id.btnadd);
        btn2 = findViewById(R.id.btnsub);
        spTinh = findViewById(R.id.pheptoan);
        String[] list = getResources().getStringArray(R.array.pheptinh);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinner_resource, list);
        spTinh.setAdapter(arrayAdapter);

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
    private String tinh(double x, double y, String pheptinh){
        String t = "";
        switch (pheptinh){
            case "Cong":
                t = "Tong: " + (x+y);
                break;
            case "Tru":
                t = "Hieu: " + (x-y);
                break;
            case "Nhan":
                t = "Tich: " + (x*y);
                break;
            case "Chia":
                if(y==0) t = "So chia khong hop le";
                else t = "Thuong: " + (x/y);
                break;
        }
        return t;
    }
}