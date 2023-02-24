package com.example.chuong3tbdd.model;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chuong3tbdd.R;

public class TechnologyAdapter extends ArrayAdapter<Technology> {
    private Context context;
    private Technology[] tlist;
    public TechnologyAdapter(@NonNull Context context, Technology[] tlist) {
        super(context, R.layout.item_tech, tlist);
        this.context = context;
        this.tlist = tlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tech, null, true);
        ImageView imageView = view.findViewById(R.id.img);
        TextView txtView = view.findViewById(R.id.tname);
        TextView txtSub = view.findViewById(R.id.tsub);
        TextView txtDesc = view.findViewById(R.id.desc);
        Technology t = tlist[position];
        imageView.setImageResource(t.getImg());
        txtView.setText(t.getName());
        txtSub.setText(t.getSubText());
        txtDesc.setText(t.getDesc());
        return view;
    }

    public Technology getItem(int position){
        return tlist[position];
    }
}
