package com.example.doan_final_2019.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.GioHangAdapter;
import com.example.doan_final_2019.models.GioHang;
import com.example.doan_final_2019.models.SanPham;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    GridView gridViewGH;
    public static ArrayList<SanPham> gioHang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        gridViewGH = findViewById(R.id.gridViewGH);

        GioHangAdapter gioHangAdapter = new GioHangAdapter(getApplicationContext(),gioHang);
        gridViewGH.setAdapter(gioHangAdapter);
    }
}
