package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.doan_final_2019.Data;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.NhanVienAdapter;
import com.example.doan_final_2019.models.NhanVien;

import java.util.ArrayList;

public class NhanVienActivity extends AppCompatActivity {
    GridView gridViewNV;
    Data data = new Data();
    public static ArrayList<NhanVien> nhanViens = new ArrayList<>();
    static NhanVienAdapter nhanVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);

        gridViewNV = findViewById(R.id.gridViewNV);

        if(nhanViens.isEmpty()) {
            data.DataNhanVien(nhanViens);
        }

        nhanVienAdapter = new NhanVienAdapter(nhanViens,getApplicationContext());
        gridViewNV.setAdapter(nhanVienAdapter);

        gridViewNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),NhanVienItemActivity.class);
                intent.putExtra("positionNV", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id
                    .home : onBackPressed();
        }
        return true;
    }

    public static void reset() {
        nhanVienAdapter.notifyDataSetChanged();
    }
}
