package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ThongtinSQL thongtinSQL;
    ListView listView;
    Button btnsave,btndelete;
    ThongTinAdapter thongTinAdapter;
    TextView txtid;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listthongtin);
        editText=findViewById(R.id.editTextTextPersonName);
        btnsave=findViewById(R.id.btnsave);

//        ThongtinEntity thongtinEntity=new ThongtinEntity(1,"Da Lat");
        ArrayList<ThongtinEntity> entityArrayList=new ArrayList<>();
//        entityArrayList.add(thongtinEntity);
        thongTinAdapter=new ThongTinAdapter(this,R.layout.layout_list,entityArrayList);
        listView.setAdapter(thongTinAdapter);




    btnsave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String ten=editText.getText().toString();
            thongtinSQL.QueryData("insert into ThongTin values(null,'"+ten+"')");
            Cursor datathongtin=thongtinSQL.GetData("select * from ThongTin");



            while (datathongtin.moveToNext()){
                String ten2=datathongtin.getString(1);
                int id=datathongtin.getInt(0);
                entityArrayList.add(new ThongtinEntity(id,ten2));

            }
            thongTinAdapter.notifyDataSetChanged();

        }
    });
        thongtinSQL=new ThongtinSQL(this,"ThongTin.sqlite",null,1);
        thongtinSQL.QueryData("CREATE TABLE IF NOT EXISTS ThongTin(stt INTEGER  PRIMARY KEY  AUTOINCREMENT,  ChiTiet VARCHAR(200))");
//        thongtinSQL.QueryData("insert into ThongTin values(null,'ĐA LAT')");
        Cursor datathongtin=thongtinSQL.GetData("select * from ThongTin");



        while (datathongtin.moveToNext()){
            String ten=datathongtin.getString(1);
                    int id=datathongtin.getInt(0);
                    entityArrayList.add(new ThongtinEntity(id,ten));

        }

        thongTinAdapter.notifyDataSetChanged();


    }
}