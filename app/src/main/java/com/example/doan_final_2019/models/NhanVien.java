package com.example.doan_final_2019.models;

public class NhanVien {
    private int id_nv;
    private String ten_nv;
    private String sdt_nv;
    private String gioitinh_nv;
    private String anh_nv;
    private String diachi_nv;
    private String chucvu_nv;

    public NhanVien(int id_nv, String ten_nv, String sdt_nv, String gioitinh_nv, String anh_nv, String diachi_nv, String chucvu_nv) {
        this.id_nv = id_nv;
        this.ten_nv = ten_nv;
        this.sdt_nv = sdt_nv;
        this.gioitinh_nv = gioitinh_nv;
        this.anh_nv = anh_nv;
        this.diachi_nv = diachi_nv;
        this.chucvu_nv = chucvu_nv;
    }

    public int getId_nv() {
        return id_nv;
    }

    public void setId_nv(int id_nv) {
        this.id_nv = id_nv;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public String getSdt_nv() {
        return sdt_nv;
    }

    public void setSdt_nv(String sdt_nv) {
        this.sdt_nv = sdt_nv;
    }

    public String getGioitinh_nv() {
        return gioitinh_nv;
    }

    public void setGioitinh_nv(String gioitinh_nv) {
        this.gioitinh_nv = gioitinh_nv;
    }

    public String getAnh_nv() {
        return anh_nv;
    }

    public void setAnh_nv(String anh_nv) {
        this.anh_nv = anh_nv;
    }

    public String getDiachi_nv() {
        return diachi_nv;
    }

    public void setDiachi_nv(String diachi_nv) {
        this.diachi_nv = diachi_nv;
    }

    public String getChucvu_nv() {
        return chucvu_nv;
    }

    public void setChucvu_nv(String chucvu_nv) {
        this.chucvu_nv = chucvu_nv;
    }
}
