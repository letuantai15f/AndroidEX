package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ThongTinAdapter extends ArrayAdapter<ThongtinEntity> {
    private Context context;
    private int resource;
    private ArrayList<ThongtinEntity> entityArrayList;
    public ThongTinAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ThongtinEntity> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.entityArrayList=objects;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout_list,parent,false);
        TextView id=convertView.findViewById(R.id.id);
        TextView thongtin=convertView.findViewById(R.id.thongtin);
        ThongtinEntity thongtinEntity= entityArrayList.get(position);
        thongtin.setText(thongtinEntity.getThongtin());
        id.setText(thongtinEntity.getId());
        return  convertView;
    }
}
