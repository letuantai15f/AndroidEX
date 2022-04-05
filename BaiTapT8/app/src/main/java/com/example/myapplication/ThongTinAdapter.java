package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
        thongtinSQL=new ThongtinSQL(context,"ThongTin.sqlite",null,1);
        thongtinSQL.QueryData("CREATE TABLE IF NOT EXISTS ThongTin(stt INTEGER  PRIMARY KEY  AUTOINCREMENT,  ChiTiet VARCHAR(200))");
        stt.setText(Integer.toString(thongtinEntity.getId()) );
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Toast.makeText(context, stt.getText(), Toast.LENGTH_SHORT).show();
               thongtinSQL.QueryData("DELETE From ThongTin Where stt="+stt.getText()+"");
                notifyDataSetChanged();
                Cursor datathongtin=thongtinSQL.GetData("select * from ThongTin");



                while (datathongtin.moveToNext()){
                    String ten=datathongtin.getString(1);
                    int id=datathongtin.getInt(0);
                    entityArrayList.add(new ThongtinEntity(id,ten));

                }



            }
        });
        notifyDataSetInvalidated();

        return  convertView;
    }
}
