package com.example.doan_final_2019;

import android.widget.Toast;

import com.example.doan_final_2019.models.DanhMuc;
import com.example.doan_final_2019.models.NhanVien;
import com.example.doan_final_2019.models.SanPham;

import java.util.ArrayList;
import java.util.Date;

public class Data {

    public void DataSanPham(ArrayList<SanPham> sp) {
//     month start 0>11
        sp.add(new SanPham(1, "Coca", new DanhMuc("","Giải Khát"), 100, 10000000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 1.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(2, "Xi Măng", new DanhMuc("","VLXD"), 10, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/158925/bhx/6-lon-nuoc-ngot-coca-cola-ca-phe-330ml-201909101538451013_300x300.jpg", 2.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(3, "Coca", new DanhMuc("","Thuốc"), 20, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 3.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(4, "Coca", new DanhMuc("","Café"), 19, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(5, "Coca", new DanhMuc("","Giải Khát"), 0, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(6, "Coca", new DanhMuc("","Giải Khát"), 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(7, "Coca", new DanhMuc("","Giải Khát"), 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(8, "Coca", new DanhMuc("","Giải Khát"), 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(9, "Coca", new DanhMuc("","Giải Khát"), 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
        sp.add(new SanPham(10, "End", new DanhMuc("","Giải Khát"), 100, 10000, "Đắt hàng", "https://cdn.tgdd.vn/Products/Images/2443/195226/bhx/6-chai-nuoc-ngot-coca-cola-600ml-201908271644056611_300x300.jpg", 5.0f, new Date(2000, 4, 1, 22, 0), false));
    }

    public void DataNhanVien(ArrayList<NhanVien> nv) {
        nv.add(new NhanVien(1,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/6Y44TcL.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(2,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/juw8HDv.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(3,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/DGBUnkQ.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(4,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/DDye22U.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(5,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/yRS8jjO.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(6,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/tj8JxIT.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(7,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/XtMxUw8.png","Thành Phố Huế","Quản Lí"));
        nv.add(new NhanVien(8,"Hoàng Phi Đại","0777230926","Nam","https://i.imgur.com/IeXOdsw.png","Thành Phố Huế","Quản Lí"));
    }
}
