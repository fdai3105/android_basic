package com.example.doan_final_2019.models;

public class DanhMuc {
    private String anhDanhMuc;
    private String tenDanhMuc;

    public DanhMuc(String anhDanhMuc, String tenDanhMuc) {
        this.anhDanhMuc = anhDanhMuc;
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getAnhDanhMuc() {
        return anhDanhMuc;
    }

    public void setAnhDanhMuc(String anhDanhMuc) {
        this.anhDanhMuc = anhDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }
}
