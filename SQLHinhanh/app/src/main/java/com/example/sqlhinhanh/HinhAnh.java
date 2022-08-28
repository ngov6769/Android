package com.example.sqlhinhanh;

public class HinhAnh {
    int id;
    String mota,ten;
    byte[] anh;

    public HinhAnh(int id, String mota, String ten, byte[] anh) {
        this.id = id;
        this.mota = mota;
        this.ten = ten;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }
}
