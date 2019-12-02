package com.example.doan_final_2019.models;

import java.util.Date;

public class GioHang {
    private int id_donhang;
    private Date ngaymuahang;
    private int soluonghang;
    private SanPham sanPham;

    public GioHang(int id_donhang, Date ngaymuahang, int soluonghang, SanPham sanPham) {
        this.id_donhang = id_donhang;
        this.ngaymuahang = ngaymuahang;
        this.soluonghang = soluonghang;
        this.sanPham = sanPham;
    }

    public int getId_donhang() {
        return id_donhang;
    }

    public void setId_donhang(int id_donhang) {
        this.id_donhang = id_donhang;
    }

    public Date getNgaymuahang() {
        return ngaymuahang;
    }

    public void setNgaymuahang(Date ngaymuahang) {
        this.ngaymuahang = ngaymuahang;
    }

    public int getSoluonghang() {
        return soluonghang;
    }

    public void setSoluonghang(int soluonghang) {
        this.soluonghang = soluonghang;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }


}
