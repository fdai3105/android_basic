package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_final_2019.Data;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.DanhMucAdapter;
import com.example.doan_final_2019.models.DanhMuc;
import com.example.doan_final_2019.models.SanPham;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Objects;

public class DanhMucActivity extends AppCompatActivity {
    private GridView gvDanhMuc;
    private Data dt = new Data();
    public static ArrayList<DanhMuc> danhMucs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);
        gvDanhMuc = findViewById(R.id.gvDanhMuc);

        if (danhMucs.isEmpty()) {
            dt.DataDanhMuc(danhMucs);
        }

        for (int i = 0; i < SanPhamActivity.sanPhams.size() ; i++) {
            if (!danhMucs.contains(SanPhamActivity.sanPhams.get(i).getDanhmuc_sp())) {
                danhMucs.add(new DanhMuc("",SanPhamActivity.sanPhams.get(i).getDanhmuc_sp()));
            }
        }


        DanhMucAdapter danhMucAdapter = new DanhMucAdapter(danhMucs, getApplicationContext());

        gvDanhMuc.setAdapter(danhMucAdapter);

        gvDanhMuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DanhMucItemActivity.class);
                TextView textView = view.findViewById(R.id.tv_tenDM);
                intent.putExtra("tenDM",textView.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_danhmuc, menu);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            case R.id.action_themDM:
                themDM();
            case R.id.action_sortDM:
        }
        return true;
    }

    private void themDM() {
    }
}
