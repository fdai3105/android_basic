package com.example.doan_final_2019;

import android.widget.Toast;

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
        sp.add(new SanPham(2, "Coca", "Giải Khát", 10, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/158925/bhx/6-lon-nuoc-ngot-coca-cola-ca-phe-330ml-201909101538451013_300x300.jpg", 2.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(3, "Coca", "Giải Khát", 20, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 3.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(4, "Coca", "Giải Khát", 19, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(5, "Coca", "Giải Khát", 0, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(6, "Coca", "Giải Khát", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(7, "Coca", "Giải Khát", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(8, "Coca", "Giải Khát", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(9, "Coca", "Giải Khát", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(10, "End", "Giải Khát", 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
    }

    public void DataDanhMuc(ArrayList<SanPham> sp) {

    }

}
