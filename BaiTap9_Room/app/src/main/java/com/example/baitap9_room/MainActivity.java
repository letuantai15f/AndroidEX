package com.example.baitap9_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.baitap9_room.DAO.UserDAO;
import com.example.baitap9_room.DAO.UserDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnadd;
    EditText txtnhap;
    private UserAdappter userAdappter;
    private RecyclerView recyclerView;
            private ArrayList<EntityUser> entityUsers;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtnhap=findViewById(R.id.txtthongtinnhap);
        btnadd=findViewById(R.id.btnadd);
        recyclerView=findViewById(R.id.list);
        entityUsers=new ArrayList<>();
        userAdappter=new UserAdappter();
        userAdappter.setData(entityUsers);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdappter);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addUser();
            }


        });

    }
    private void addUser() {

        String ten=txtnhap.getText().toString().trim();
        if(ten.isEmpty()){
            return;
        }
        EntityUser entityUser= new EntityUser(ten);
        UserDB.getInstance(this).userDao().insertAll(entityUser);
        Toast.makeText(this, "Thanh Cong", Toast.LENGTH_SHORT).show();
        txtnhap.setText("");
       entityUsers= (ArrayList<EntityUser>) UserDB.getInstance(this).userDao().getAll();
       userAdappter.setData(entityUsers);
    }


}