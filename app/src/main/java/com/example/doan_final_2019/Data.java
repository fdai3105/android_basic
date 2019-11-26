package com.example.doan_final_2019;

import android.widget.Toast;

import com.example.doan_final_2019.models.DanhMuc;
import com.example.doan_final_2019.models.SanPham;

import java.util.ArrayList;
import java.util.Date;

public class Data {
    public ArrayList<SanPham> sanPhams = new ArrayList<>();
    public ArrayList<SanPham> sanPhamsVuaThem = new ArrayList<>();


    public void HangMoiThem(SanPham sp) {
        sanPhamsVuaThem.add(sp);
    }

    public void DataSanPham(ArrayList<SanPham> sp) {
//     month start 0>11
        sp.add(new SanPham(1, "Coca", "Giải Khát", 100, 10000000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 1.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(2, "Xi Măng", "VLXD", 10, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/158925/bhx/6-lon-nuoc-ngot-coca-cola-ca-phe-330ml-201909101538451013_300x300.jpg", 2.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(3, "Coca", "DM1", 20, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 3.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(4, "Coca", "DM2", 19, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(5, "Coca", "DM3", 0, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(6, "Coca", "DM4", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(7, "Coca", "DM2", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(8, "Coca", "DM6", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(9, "Coca", "DM7", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(10, "End", "DM8", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
    }

    public void DataDanhMuc(ArrayList<DanhMuc> dm) {
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 1"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 2"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 3"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 4"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 5"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 5"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 7"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 8"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 9"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 0"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 10"));
        dm.add(new DanhMuc("https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg","Thử 11"));
    }

}
