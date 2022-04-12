package com.example.baitap9_room.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.baitap9_room.EntityUser;

@Database(entities = {EntityUser.class},version = 1)
public abstract class UserDB extends RoomDatabase {
    private static final String DATABASE_NAME="user.db";
    private static  UserDB instance;

    public static synchronized UserDB getInstance(Context context) {
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),UserDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDAO userDao();

}
