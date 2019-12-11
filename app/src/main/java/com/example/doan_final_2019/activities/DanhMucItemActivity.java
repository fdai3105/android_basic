package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.doan_final_2019.CurrencyFormat;
import com.example.doan_final_2019.DownloadImage;
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
        setContentView(R.layout.activity_danhmuc_item);

        gvDanhMucItem = findViewById(R.id.gvDanhMucItem);

        String tenDM = getIntent().getStringExtra("tenDM");
        for (int i = 0; i < sanPhamActivity.sanPhams.size(); i++) {
            if (sanPhamActivity.sanPhams.get(i).getDanhMuc().getTenDanhMuc().equalsIgnoreCase(tenDM)) {
                sanPhams.add(sanPhamActivity.sanPhams.get(i));
            }
        }
        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), sanPhams);
        gvDanhMucItem.setAdapter(sanPhamAdapter);
        gvDanhMucItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewDialogDM(position);
            }
        });
    }

    private void viewDialogDM(int p) {
        final Dialog dialog = new Dialog(this, R.style.DiaLogBottom);
        dialog.setContentView(R.layout.dialog_danhmuc_xemitem);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        dialog.show();
        /*---------------------------------------------*/
        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);
        ImageView ivAnhItem = dialog.findViewById(R.id.ivAnhItem);
        TextView tvIDItem = dialog.findViewById(R.id.tvIDItem);
        TextView tvTenItem = dialog.findViewById(R.id.tvTenItem);
        TextView tvDanhMucItem = dialog.findViewById(R.id.tvDanhMucItem);
        TextView tvGiaItem = dialog.findViewById(R.id.tvGiaItem);
        RatingBar rbItem = dialog.findViewById(R.id.rbItem);
        TextView tvSoLuongItem = dialog.findViewById(R.id.tvSoLuongItem);
        TextView tvNgayThemItem = dialog.findViewById(R.id.tvNgayThemItem);
        /*---------------------------------------------*/
        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        int year = sanPhams.get(p).getNgaythem_sp().getYear();
        int year2 = sanPhams.get(p).getNgaythem_sp().getYear();
        //getYear() return year-1900??
        if (year < 1000) {
            year += 1900;
        }

        //getMonth start 0>11
        String ngayThem = sanPhams.get(p).getNgaythem_sp().getDate() +
                "-" + (sanPhams.get(p).getNgaythem_sp().getMonth() + 1) +
                "-" + year + " " + sanPhams.get(p).getNgaythem_sp().getHours() + ":"
                + sanPhams.get(p).getNgaythem_sp().getMinutes();

        if (sanPhams.get(p).getAnh_sp().trim().length() == 0) {
            ivAnhItem.setImageResource(R.drawable.img_empty);
        } else {
            new DownloadImage(ivAnhItem).execute(SanPhamActivity.sanPhams.get(p).getAnh_sp());
        }

        tvIDItem.setText("ID: " + sanPhams.get(p).getId_sp() + "");
        tvTenItem.setText(sanPhams.get(p).getTen_sp() + "");
        tvDanhMucItem.setText("Danh mục: " + sanPhams.get(p).getDanhMuc().getTenDanhMuc());
        tvGiaItem.setText(new CurrencyFormat().CurrencyFormat(String.valueOf(sanPhams.get(p).getGia_sp())) + " VND");
        rbItem.setRating(sanPhams.get(p).getLuongnguoidung_sp());
        tvSoLuongItem.setText("Số lượng: " + sanPhams.get(p).getSoluong_sp());
        tvNgayThemItem.setText("Ngày thêm: " + ngayThem);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setTitle("Danh mục: " + getIntent().getStringExtra("tenDM"));
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
}
