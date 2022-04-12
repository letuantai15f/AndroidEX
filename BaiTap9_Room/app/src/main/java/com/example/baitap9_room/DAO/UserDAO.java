package com.example.baitap9_room.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.baitap9_room.EntityUser;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    List<EntityUser> getAll();


    @Insert
    void insertAll(EntityUser users);

    @Delete
    void delete(EntityUser user);
}
