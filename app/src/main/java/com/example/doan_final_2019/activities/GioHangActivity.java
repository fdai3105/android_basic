package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.doan_final_2019.CurrencyFormat;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.GioHangAdapter;
import com.example.doan_final_2019.models.GioHang;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    GridView gridViewGH;
    public static LinearLayout llEmptyBox;
    public static TextView tv_tongTien, tv_tongSL;

    int tongSL = 0;
    int tongTien = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        gridViewGH = findViewById(R.id.gridViewGH);
        llEmptyBox = findViewById(R.id.llEmptyCart);
        tv_tongTien = findViewById(R.id.tv_tongTien);
        tv_tongSL = findViewById(R.id.tv_tongSL);

        checkEmptyGH(SanPhamItemActivity.gioHangs);

        GioHangAdapter gioHangAdapter = new GioHangAdapter(getApplicationContext(), SanPhamItemActivity.gioHangs);
        gridViewGH.setAdapter(gioHangAdapter);

        changeBill(SanPhamItemActivity.gioHangs);
    }

    public static void checkEmptyGH(ArrayList<GioHang> gioHangs) {
        if (!gioHangs.isEmpty()) {
            llEmptyBox.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


    //change TongTien && TongSoLuong
    private void changeBill(ArrayList<GioHang> gioHangs) {
        for (int i = 0; i < gioHangs.size(); i++) {
            tongSL = gioHangs.get(i).getSoluonghang() + tongSL;
        }

        for (int i = 0; i < gioHangs.size(); i++) {
            tongTien = (gioHangs.get(i).getSanPham().getGia_sp() * gioHangs.get(i).getSoluonghang()) + tongTien;
        }

        tv_tongSL.setText(tongSL + "");
        tv_tongTien.setText(new CurrencyFormat().CurrencyFormat(String.valueOf(tongTien)) + " VND");
    }
}
