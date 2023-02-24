package com.example.chuong3tbdd;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chuong3tbdd.model.Technology;
import com.example.chuong3tbdd.model.TechnologyAdapter;

public class BtvnChuong4_1 extends AppCompatActivity {
    private ListView listView;
    private TechnologyAdapter adapter;
    private Technology[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_hw);
        listView = findViewById(R.id.listview);
        InitData();
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
    }
}