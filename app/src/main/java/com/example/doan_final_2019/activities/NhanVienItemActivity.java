package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.models.NhanVien;

public class NhanVienItemActivity extends AppCompatActivity {
    ImageView tv_itemAnhNV;
    TextView tv_itemTenNV, tv_itemChucVuNV, tv_itemDiaChiNV, tv_itemSDTNV, tv_itemGioiTinhNV;
    int postion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_item);

        tv_itemAnhNV = findViewById(R.id.iv_itemAnhNV);
        tv_itemTenNV = findViewById(R.id.iv_itemTenNV);
        tv_itemGioiTinhNV = findViewById(R.id.iv_itemGioiTinhNV);
        tv_itemChucVuNV = findViewById(R.id.iv_itemChucVuNV);
        tv_itemDiaChiNV = findViewById(R.id.iv_itemDiaChiNV);
        tv_itemSDTNV = findViewById(R.id.iv_itemSDTNV);

        postion = getIntent().getIntExtra("positionNV", 0);

        if (NhanVienActivity.nhanViens.get(postion).getAnh_nv().trim().length() == 0) {
            tv_itemAnhNV.setImageResource(R.drawable.img_empty);
        }
        if (NhanVienActivity.nhanViens.get(postion).getAnh_nv().trim().length() == 0) {
            tv_itemAnhNV.setImageResource(R.drawable.img_empty);
        } else {
            new DownloadImage(tv_itemAnhNV).execute(SanPhamActivity.sanPhams.get(postion).getAnh_sp());
        }
        tv_itemTenNV.setText(NhanVienActivity.nhanViens.get(postion).getTen_nv() + "");
        tv_itemChucVuNV.setText(NhanVienActivity.nhanViens.get(postion).getChucvu_nv() + "");
        tv_itemGioiTinhNV.setText("Giới tính: " + NhanVienActivity.nhanViens.get(postion).getGioitinh_nv());
        tv_itemDiaChiNV.setText(NhanVienActivity.nhanViens.get(postion).getDiachi_nv() + "");
        tv_itemSDTNV.setText(NhanVienActivity.nhanViens.get(postion).getSdt_nv() + "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item_nhanvien, menu);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Nhân viên: "+NhanVienActivity.nhanViens.get(postion).getTen_nv());

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.btnSuaNV:
                suaNV();
                break;
            case R.id.btnXoaNV:
                xoaNV();
                break;
        }
        return true;
    }

    private void suaNV() {
        final Dialog dialog = new Dialog(this, R.style.DiaLog);
        dialog.setContentView(R.layout.dialog_nhanvien_sua);
        dialog.show();

        final EditText etDialogTenNV = dialog.findViewById(R.id.etDialogSuaTenNV);
        final EditText etDialogChucVuNV = dialog.findViewById(R.id.etDialogSuaChucVuNV);
        final RadioButton rbDialogSuaGioiTinhNam = dialog.findViewById(R.id.rbDialogSuaGioiTinhNam);
        RadioButton rbDialogSuaGioiTinhNu = dialog.findViewById(R.id.rbDialogSuaGioiTinhNu);
        final EditText etDialogDiaChiNV = dialog.findViewById(R.id.etDialogSuaDiaChiNV);
        final EditText etDialogSDTNV = dialog.findViewById(R.id.etDialogSuaSDTNV);
        Button btnDialogSuaNVClick = dialog.findViewById(R.id.btnDialogSuaNVClick);
        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);
        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        etDialogTenNV.setText(NhanVienActivity.nhanViens.get(postion).getTen_nv() + "");
        etDialogChucVuNV.setText(NhanVienActivity.nhanViens.get(postion).getChucvu_nv() + "");
        if (NhanVienActivity.nhanViens.get(postion).getGioitinh_nv() == "Nam") {
            rbDialogSuaGioiTinhNam.setChecked(true);
        } else {
            rbDialogSuaGioiTinhNu.setChecked(true);
        }
        etDialogDiaChiNV.setText(NhanVienActivity.nhanViens.get(postion).getDiachi_nv() + "");
        etDialogSDTNV.setText(NhanVienActivity.nhanViens.get(postion).getSdt_nv() + "");
        btnDialogSuaNVClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gioitinh;
                if (rbDialogSuaGioiTinhNam.isChecked()) {
                    gioitinh = "Nam";
                } else {
                    gioitinh = "Nữ";
                }
                NhanVienActivity.nhanViens.set(postion, new NhanVien(NhanVienActivity.nhanViens.get(postion).getId_nv(),
                        etDialogTenNV.getText().toString(), etDialogSDTNV.getText().toString(),
                        gioitinh, NhanVienActivity.nhanViens.get(postion).getAnh_nv(),
                        etDialogDiaChiNV.getText().toString(), etDialogChucVuNV.getText().toString()));

                tv_itemTenNV.setText(etDialogTenNV.getText() + "");
                tv_itemChucVuNV.setText(etDialogChucVuNV.getText() + "");
                tv_itemGioiTinhNV.setText(gioitinh + "");
                NhanVienActivity.reset();
                dialog.dismiss();
            }
        });
    }

    private void xoaNV() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xoá nhân viên");
        builder.setMessage("Bạn có muốn xoá " + NhanVienActivity.nhanViens.get(postion).getTen_nv() + " không?");
        builder.setCancelable(true);
        builder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Xoá", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                NhanVienActivity.nhanViens.remove(postion);
                NhanVienActivity.reset();
                onBackPressed();
            }
        });
        builder.show();
    }
}
