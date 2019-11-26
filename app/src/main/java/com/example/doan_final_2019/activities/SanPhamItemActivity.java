package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.models.SanPham;

import java.text.DecimalFormat;

public class SanPhamItemActivity extends AppCompatActivity {
    ImageView ivAnhItem;
    TextView tvIDItem, tvTenItem, tvDanhMucItem, tvSoLuongItem, tvGiaItem, tvNgayThemItem;
    RatingBar rbItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_item);

//        ***************************************************
        tvIDItem = findViewById(R.id.tvIDItem);
        ivAnhItem = findViewById(R.id.ivAnhItem);
        tvTenItem = findViewById(R.id.tvTenItem);
        tvDanhMucItem = findViewById(R.id.tvDanhMucItem);
        tvSoLuongItem = findViewById(R.id.tvSoLuongItem);
        tvGiaItem = findViewById(R.id.tvGiaItem);
        rbItem = findViewById(R.id.rbItem);
        tvNgayThemItem = findViewById(R.id.tvNgayThemItem);
//        ***************************************************
        int positionItem = getIntent().getIntExtra("positionItem", 0);
//         ;
        int year = SanPhamActivity.sanPhams.get(positionItem).getNgaythem_sp().getYear();
        if (year < 1000) {
            year += 1900;
        }
//        getMonth start 0>11
        String ngayThem = SanPhamActivity.sanPhams.get(positionItem).getNgaythem_sp().getDate() +
                "-" + (SanPhamActivity.sanPhams.get(positionItem).getNgaythem_sp().getMonth() + 1) +
                "-" + year + " " + SanPhamActivity.sanPhams.get(positionItem).getNgaythem_sp().getHours() + ":"
                + SanPhamActivity.sanPhams.get(positionItem).getNgaythem_sp().getMinutes();

        new DownloadImage(ivAnhItem).execute(SanPhamActivity.sanPhams.get(positionItem).getAnh_sp());
        tvIDItem.setText("ID: " + SanPhamActivity.sanPhams.get(positionItem).getId_sp());
        tvTenItem.setText("Tên Sản Phẩm: " + SanPhamActivity.sanPhams.get(positionItem).getTen_sp());
        tvDanhMucItem.setText("Danh Mục: " + SanPhamActivity.sanPhams.get(positionItem).getDanhMuc().getTenDanhMuc());
        tvGiaItem.setText(currencyFormat(String.valueOf(SanPhamActivity.sanPhams.get(positionItem).getGia_sp())) + " VND");
        rbItem.setRating(SanPhamActivity.sanPhams.get(positionItem).getLuongnguoidung_sp());
        if (SanPhamActivity.sanPhams.get(positionItem).getSoluong_sp() == 0) {
            tvSoLuongItem.setTextColor(Color.RED);
            tvSoLuongItem.setText("Hết hàng");
        } else {
            tvSoLuongItem.setText("Trong Kho: " + SanPhamActivity.sanPhams.get(positionItem).getSoluong_sp());

        }
        tvNgayThemItem.setText("Ngày thêm: " + ngayThem);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return true;
    }

    public static String currencyFormat(String s) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(Double.parseDouble(s));
    }
}
