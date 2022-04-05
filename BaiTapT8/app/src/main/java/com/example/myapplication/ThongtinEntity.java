package com.example.myapplication;

public class ThongtinEntity {
    private int id;
    private String thongtin;

    public ThongtinEntity(int id, String thongtin) {
        this.id = id;
        this.thongtin = thongtin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }

    @Override
    public String toString() {
        return "ThongtinEntity{" +
                "id=" + id +
                ", thongtin='" + thongtin + '\'' +
                '}';
    }
}
