package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.doan_final_2019.Data;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.NhanVienAdapter;
import com.example.doan_final_2019.models.NhanVien;

import java.util.ArrayList;
import java.util.Objects;

public class NhanVienActivity extends AppCompatActivity {
    GridView gridViewNV;
    Data data = new Data();
    public static ArrayList<NhanVien> nhanViens = new ArrayList<>();
    private static NhanVienAdapter nhanVienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);

        gridViewNV = findViewById(R.id.gridViewNV);

        if (nhanViens.isEmpty()) {
            data.DataNhanVien(nhanViens);
        }

        nhanVienAdapter = new NhanVienAdapter(nhanViens, getApplicationContext());
        gridViewNV.setAdapter(nhanVienAdapter);

        gridViewNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NhanVienItemActivity.class);
                intent.putExtra("positionNV", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nhanvien, menu);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
            break;
            case R.id.btnThemNV:
                themNV();
                break;
        }
        return true;
    }

    private void themNV() {
        final Dialog dialog = new Dialog(this, R.style.DiaLog);
        dialog.setContentView(R.layout.dialog_nhanvien_themnv);
        dialog.show();
        /*--------------------------------------------------------------------------------------*/
        final EditText etDialogAddTenNV = dialog.findViewById(R.id.etDialogAddTenNV);
        final EditText etDialogAddAnhNV = dialog.findViewById(R.id.etDialogAddAnhNV);
        final RadioButton rbDialogGioiTinhNam = dialog.findViewById(R.id.rbDialogSuaGioiTinhNam);
        final RadioButton rbDialogGioiTinhNu = dialog.findViewById(R.id.rbDialogSuaGioiTinhNu);
        final EditText etDialogAddChucVuNV = dialog.findViewById(R.id.etDialogAddChucVuNV);
        final EditText etDialogAddDiaChiNV = dialog.findViewById(R.id.etDialogAddDiaChiNV);
        final EditText etDialogAddSDTNV = dialog.findViewById(R.id.etDialogAddSDTNV);
        Button btnDialogAddNVClick = dialog.findViewById(R.id.btnDialogAddNVClick);
        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);
        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnDialogAddNVClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDialogAddTenNV.getText().toString().trim().length() == 0 ||
                        etDialogAddChucVuNV.getText().toString().trim().length() == 0 ||
                        etDialogAddSDTNV.getText().toString().trim().length() == 0 ||
                        etDialogAddDiaChiNV.getText().toString().trim().length() == 0) {
                    Toast.makeText(NhanVienActivity.this, "Vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                } else {
                    String gioiTinh = null;
                    if (rbDialogGioiTinhNam.isChecked()) {
                        gioiTinh = "Nam";
                    } else if (rbDialogGioiTinhNu.isChecked()) {
                        gioiTinh = "Nữ";
                    }
                    try {
                        NhanVien nhanVien = new NhanVien(nhanViens.size() + 1,
                                etDialogAddTenNV.getText().toString(),
                                etDialogAddSDTNV.getText().toString(), gioiTinh,
                                etDialogAddAnhNV.getText().toString(),
                                etDialogAddDiaChiNV.getText().toString(),
                                etDialogAddChucVuNV.getText().toString());
                        nhanViens.add(nhanVien);
                        nhanVienAdapter.notifyDataSetChanged();
                        Toast.makeText(NhanVienActivity.this, "Đã thêm nhân viên", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    } catch (Exception e) {
                        Toast.makeText(NhanVienActivity.this, "Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static void reset() {
        nhanVienAdapter.notifyDataSetChanged();
    }
}
