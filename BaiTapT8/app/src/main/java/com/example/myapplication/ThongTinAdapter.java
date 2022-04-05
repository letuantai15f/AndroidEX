package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ThongTinAdapter extends ArrayAdapter<ThongtinEntity> {
    private Context context;
    private int resource;
    ImageButton button;
    ThongtinSQL thongtinSQL;
    private ArrayList<ThongtinEntity> entityArrayList;
    public ThongTinAdapter( Context context, int resource,  ArrayList<ThongtinEntity> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.entityArrayList=objects;
    }


    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.layout_list,parent,false);
        TextView stt=convertView.findViewById(R.id.stt);
        TextView thongtin=convertView.findViewById(R.id.thongtin);
        button=convertView.findViewById(R.id.btnxoa);
        ThongtinEntity thongtinEntity= entityArrayList.get(position);
        thongtin.setText(thongtinEntity.getThongtin());
        stt.setText(Integer.toString(thongtinEntity.getId()) );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, stt.getText(), Toast.LENGTH_SHORT).show();
                thongtinSQL.QueryData("Delete From ThongTin where stt="+stt.getText()+"");

            }
        });
        return  convertView;
    }
}
