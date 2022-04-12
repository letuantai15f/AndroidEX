package com.example.baitap9_room;

import androidx.room.PrimaryKey;

@androidx.room.Entity (tableName = "user")
public class EntityUser {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ten;

    public EntityUser(String ten) {
        this.ten = ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                '}';
    }
}
