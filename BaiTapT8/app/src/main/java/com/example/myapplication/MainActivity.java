package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ThongtinSQL thongtinSQL;
    ListView listView;
    ThongTinAdapter thongTinAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listthongtin);
        thongtinSQL=new ThongtinSQL(this,"thongtin.sqlite",null,1);
        thongtinSQL.QueryData("CREATE TABLE IF NOT EXISTS ThongTin(id INTEGER  PRIMARY KEY  AUTOINCREMENT,  ChiTiet VARCHAR(200))");
        thongtinSQL.QueryData("insert into ThongTin values(1,'ĐA LAT')");
        Cursor datathongtin=thongtinSQL.GetData("select & from ThongTin");

        ArrayList<ThongtinEntity> entityArrayList=new ArrayList<>();
        thongTinAdapter=new ThongTinAdapter(this,R.layout.layout_list,entityArrayList);
        listView.setAdapter(thongTinAdapter);

        while (datathongtin.moveToNext()){
            String ten=datathongtin.getString(2);
                    int id=datathongtin.getInt(1);
                    entityArrayList.add(new ThongtinEntity(id,ten));

        }
        thongTinAdapter.notifyDataSetChanged();


    }
}