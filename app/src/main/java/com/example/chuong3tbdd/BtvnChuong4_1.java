package com.example.chuong3tbdd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.chuong3tbdd.model.Technology;
import com.example.chuong3tbdd.model.TechnologyAdapter;

public class BtvnChuong4_1 extends AppCompatActivity {
    private ListView listView;
    private TechnologyAdapter adapter;
    private Technology[] list;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_hw);
        listView = findViewById(R.id.listview);
        InitData();
        registerForContextMenu(tv);
        adapter = new TechnologyAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for(int dem = 0; dem < listView.getAdapter().getCount(); dem++){
                    listView.getChildAt(dem).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(i).setBackgroundColor(Color.YELLOW);
                Toast.makeText(BtvnChuong4_1.this, adapter.getItem(i).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitData() {
        Integer[] imgs = {R.drawable.c, R.drawable.cplusplus,
        R.drawable.java, R.drawable.python, R.drawable.android};
        String[] name = {"C","C++","JAVA","PYTHON","ANDROID"};
        String[] sub = {"sub C","sub C++","sub JAVA","sub PYTHON","sub ANDROID"};
        String[] des = {"desc C","desc C++","desc JAVA","desc PYTHON","desc ANDROID"};
        list = new Technology[imgs.length];
        for(int i = 0; i < imgs.length; i++){
            list[i] = new Technology(imgs[i],name[i],sub[i],des[i]);
        }
        tv = findViewById(R.id.title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFile:
                Toast.makeText(this, "HERE IS THE FILE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mPhone:
                Toast.makeText(this, "HERE IS THE PHONE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mExit:
                Toast.makeText(this, "HERE IS THE EXIT", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mEmail:
                Toast.makeText(this, "HERE IS THE EMAIL", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mRed:
                tv.setTextColor(R.color.cRed);
                Toast.makeText(this, "RED", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mGreen:

                tv.setTextColor(R.color.cGreen);
                Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mBlue:

                tv.setTextColor(R.color.cBlue);
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}