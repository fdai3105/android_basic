package com.example.doan_final_2019.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


public class SanPham {
    private int id_sp;
    private String ten_sp;
    private DanhMuc danhMuc;
    private int soluong_sp;
    private int gia_sp;
    private String mota_sp;
    private String anh_sp;
    private float luongnguoidung_sp;
    private Date ngaythem_sp;

    public SanPham(int id_sp, String ten_sp, DanhMuc danhMuc, int soluong_sp, int gia_sp, String mota_sp, String anh_sp, float luongnguoidung_sp, Date ngaythem_sp) {
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.danhMuc = danhMuc;
        this.soluong_sp = soluong_sp;
        this.gia_sp = gia_sp;
        this.mota_sp = mota_sp;
        this.anh_sp = anh_sp;
        this.luongnguoidung_sp = luongnguoidung_sp;
        this.ngaythem_sp = ngaythem_sp;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Date getNgaythem_sp() {
        return ngaythem_sp;
    }

    public void setNgaythem_sp(Date ngaythem_sp) {
        this.ngaythem_sp = ngaythem_sp;
    }

    public String getAnh_sp() {
        return anh_sp;
    }

    public void setAnh_sp(String anh_sp) {
        this.anh_sp = anh_sp;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public int getSoluong_sp() {
        return soluong_sp;
    }

    public void setSoluong_sp(int soluong_sp) {
        this.soluong_sp = soluong_sp;
    }

    public int getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public String getMota_sp() {
        return mota_sp;
    }

    public void setMota_sp(String mota_sp) {
        this.mota_sp = mota_sp;
    }

    public float getLuongnguoidung_sp() {
        return luongnguoidung_sp;
    }

    public void setLuongnguoidung_sp(float luongnguoidung_sp) {
        this.luongnguoidung_sp = luongnguoidung_sp;
    }

    @Override
    public String toString() {
        return
                id_sp + "_" +
                        ten_sp + "-" +
                        soluong_sp + "-" +
                        gia_sp + "-" +
                        mota_sp + "-" +
                        anh_sp + "-" +
                        luongnguoidung_sp + "-" +
                        ngaythem_sp
                ;
    }
}
