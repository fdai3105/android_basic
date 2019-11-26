package com.example.doan_final_2019.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.SanPhamAdapter;
import com.example.doan_final_2019.models.SanPham;

import java.util.ArrayList;

public class DanhMucItemActivity extends AppCompatActivity {
    GridView gvDanhMucItem;

    private SanPhamActivity sanPhamActivity = new SanPhamActivity();
    private ArrayList<SanPham> sanPhams = new ArrayList<>();
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_muc_item);

        gvDanhMucItem = findViewById(R.id.gvDanhMucItem);

        String tenDM = getIntent().getStringExtra("tenDM");
        for (int i = 0; i < sanPhamActivity.sanPhams.size() ; i++) {
            if (sanPhamActivity.sanPhams.get(i).getDanhmuc_sp().equalsIgnoreCase(tenDM)) {
                sanPhams.add(sanPhamActivity.sanPhams.get(i));
            }
        }
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(),sanPhams);
        gvDanhMucItem.setAdapter(sanPhamAdapter);
    }
}
