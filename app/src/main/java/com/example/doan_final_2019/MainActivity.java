package com.example.doan_final_2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.doan_final_2019.activities.DanhMucActivity;
import com.example.doan_final_2019.activities.InfoActivity;
import com.example.doan_final_2019.activities.NhanVienActivity;
import com.example.doan_final_2019.activities.SanPhamActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSanPhamClick(View view) {
        Intent intent  = new Intent(getApplicationContext(), SanPhamActivity.class);
        startActivity(intent);
    }

    public void btnDanhMucClick(View view) {
        Intent intent  = new Intent(getApplicationContext(), DanhMucActivity.class);
        startActivity(intent);
    }

    public void btnNhanVienClick(View view) {
        Intent intent  = new Intent(getApplicationContext(), NhanVienActivity.class);
        startActivity(intent);
    }

    public void btnInfoClick(View view) {
        Intent intent  = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }
}
