package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_final_2019.CurrencyFormat;
import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.models.GioHang;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class SanPhamItemActivity extends AppCompatActivity {
    ImageView ivAnhItem;
    TextView tvIDItem, tvTenItem, tvDanhMucItem, tvSoLuongItem, tvGiaItem, tvNgayThemItem;
    RatingBar rbItem;
    public static TextView tvCart;
    int positionItem;

    public static ArrayList<GioHang> gioHangs = new ArrayList<>();
    CurrencyFormat currencyFormat = new CurrencyFormat();

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
        positionItem = getIntent().getIntExtra("positionItem", 0);
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
        tvTenItem.setText(SanPhamActivity.sanPhams.get(positionItem).getTen_sp());
        tvDanhMucItem.setText("Danh Mục: " + SanPhamActivity.sanPhams.get(positionItem).getDanhMuc().getTenDanhMuc());
        tvGiaItem.setText(currencyFormat.CurrencyFormat(String.valueOf(SanPhamActivity.sanPhams.get(positionItem).getGia_sp())) + " VND");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_sanpham, menu);
        getSupportActionBar().setElevation(0);

        //Badge Cart on actionBar
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        tvCart = actionView.findViewById(R.id.notification_badge);
        tvCart.setText(SanPhamActivity.numberCart + "");

        //Badge Cart onClick
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return true;
    }

    public void btnThemVaoGioClick(View view) {
        final Dialog dialog = new Dialog(this, R.style.DiaLogBottom);
        dialog.setContentView(R.layout.dialog_sanpham_item_themvaogio);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        dialog.show();

        final TextView tv_soluong = dialog.findViewById(R.id.tv_soluong);
        Button btn_tangSoLuong = dialog.findViewById(R.id.btn_tangSoLuong);
        Button btn_giamSoLuong = dialog.findViewById(R.id.btn_giamSoLuong);
        final TextView tv_tongTien = dialog.findViewById(R.id.tv_tongTien);
        Button btn_themVaoGio = dialog.findViewById(R.id.btn_themVaoGio);

        tv_tongTien.setText("Tổng tiền: " + currencyFormat.CurrencyFormat(String.valueOf(SanPhamActivity.sanPhams.get(positionItem).getGia_sp())) + " VND");
        btn_tangSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_soluong.setText(Integer.parseInt(tv_soluong.getText().toString()) + 1 + "");
                tv_tongTien.setText("Tổng tiền: " + currencyFormat.CurrencyFormat(String.valueOf(SanPhamActivity.sanPhams.get(positionItem).getGia_sp() * Integer.parseInt(tv_soluong.getText().toString()))) + " VND");
            }
        });
        btn_giamSoLuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(tv_soluong.getText().toString()) > 0) {
                    tv_soluong.setText(Integer.parseInt(tv_soluong.getText().toString()) - 1 + "");
                    tv_tongTien.setText("Tổng tiền: " + currencyFormat.CurrencyFormat(String.valueOf(SanPhamActivity.sanPhams.get(positionItem).getGia_sp() * Integer.parseInt(tv_soluong.getText().toString()))) + " VND");
                }
            }
        });

        btn_themVaoGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(tv_soluong.getText().toString()) > 0) {
                    SanPhamActivity.numberCart++;
                    SanPhamActivity.tvCart.setText(SanPhamActivity.numberCart + "");
                    Date currentTime = Calendar.getInstance().getTime();

                    GioHang gioHang = new GioHang(gioHangs.size() + 1, currentTime, Integer.parseInt(tv_soluong.getText().toString()), SanPhamActivity.sanPhams.get(positionItem));
                    gioHangs.add(gioHang);

                    tvCart.setText(SanPhamActivity.numberCart + "");
                    Toast.makeText(SanPhamItemActivity.this, "Đã thêm sản phẩm!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(SanPhamItemActivity.this, "Vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
