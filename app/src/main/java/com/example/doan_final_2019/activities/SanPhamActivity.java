package com.example.doan_final_2019.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_final_2019.Data;
import com.example.doan_final_2019.FormatEditText;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.adapters.SanPhamAdapter;
import com.example.doan_final_2019.models.SanPham;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SanPhamActivity extends AppCompatActivity {
    GridView gridViewSP;
    public static TextView tvCart;
    EditText etSearch;
    SanPhamAdapter sanPhamAdapter;
    Data dataSP = new Data();
    public static ArrayList<SanPham> sanPhams = new ArrayList<>();
    public static int numberCart = 0;
    Dialog dialog;
    int positionLongClick;
    FormatEditText formatEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham);

//      *******************************************************************
        gridViewSP = findViewById(R.id.gridViewSP);
        etSearch = findViewById(R.id.etSearch);
//      *******************************************************************

        if (sanPhams.isEmpty()) {
            dataSP.DataSanPham(sanPhams);
        }

        gridViewSP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), SanPhamItemActivity.class);
                intent.putExtra("positionItem", position);
                startActivity(intent);
            }
        });

        gridViewSP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                dialog = new Dialog(SanPhamActivity.this, R.style.DiaLogLongClick);
                dialog.setContentView(R.layout.dialog_custom_long);
                dialog.show();
                positionLongClick = position;
                return true;
            }
        });


        sanPhamAdapter = new SanPhamAdapter(getApplicationContext(), sanPhams);
        gridViewSP.setAdapter(sanPhamAdapter);

        gridViewSP.setTextFilterEnabled(true);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                sanPhamAdapter.getFilter().filter(s);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sanpham, menu);
        getSupportActionBar().setElevation(0);

//        actionView == button Cart on actionBar
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        tvCart = actionView.findViewById(R.id.notification_badge);
        tvCart.setText(numberCart + "");
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
            }
        });
        return true;
    }

    //#region action bar
    //R.id.home == back button on action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_cart:
                Toast.makeText(this, "32", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_SortByName:
                Collections.sort(sanPhams, new NameSort());
                sanPhamAdapter.notifyDataSetChanged(); /*F5 làm mới cuộc đời*/
                Toast.makeText(this, "Đã sắp xếp theo tên", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_SortByPrice_toLow:
                Collections.sort(sanPhams, new PriceSortToLow());
                sanPhamAdapter.notifyDataSetChanged(); /*F5 làm mới cuộc đời*/
                Toast.makeText(this, "Đã sắp xếp theo giá tiền giảm dần", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_SortByPrice_toHigh:
                Collections.sort(sanPhams, new PriceSortToHigh());
                sanPhamAdapter.notifyDataSetChanged(); /*F5 làm mới cuộc đời*/
                Toast.makeText(this, "Đã sắp xếp theo giá tiền tăng dần", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_SortByNew:
                Collections.sort(sanPhams, new NewSort());
                sanPhamAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Đã sắp xếp theo ngày thêm gần nhất", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnThemSPClick:
                themHang();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
    //#endregion

    public void btDialogCustomEditClick(View view) {
        suaHang();
        dialog.dismiss();
    }

    public void btDialogCustomDel(View view) {
        sanPhams.remove(positionLongClick);
        sanPhamAdapter.notifyDataSetChanged();
        Toast.makeText(this, "Xoá thành công!", Toast.LENGTH_SHORT).show();
        dialog.dismiss();
    }

    public void btDialogCustomAdd(View view) {
        themHang();
        dialog.dismiss();
    }

    //#region action sort
    public class NameSort implements Comparator<SanPham> {
        @Override
        public int compare(SanPham o1, SanPham o2) {
            return o1.getTen_sp().compareToIgnoreCase(o2.getTen_sp());
        }
    }

    public class PriceSortToLow implements Comparator<SanPham> {
        @Override
        public int compare(SanPham o1, SanPham o2) {
            return o2.getGia_sp() >= o1.getGia_sp() ? 1 : -1;
        }
    }

    public class PriceSortToHigh implements Comparator<SanPham> {
        @Override
        public int compare(SanPham o1, SanPham o2) {
            return o1.getGia_sp() >= o2.getGia_sp() ? 1 : -1;
        }
    }

    //    sort by new ( by time - date )
    public class NewSort implements Comparator<SanPham> {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        int i;

        @Override
        public int compare(SanPham o1, SanPham o2) {
            int yearTemp1 = o1.getNgaythem_sp().getYear();
            int yearTemp2 = o2.getNgaythem_sp().getYear();
//           the year minus 1900
            if (yearTemp1 < 1000) {
                yearTemp1 += 1900;
            }
            if (yearTemp2 < 1000) {
                yearTemp2 += 1900;
            }
            String dateTemp1 = o1.getNgaythem_sp().getDate() + "-" + o1.getNgaythem_sp().getMonth() +
                    "-" + yearTemp1 + " " + o1.getNgaythem_sp().getHours() + ":" +
                    o1.getNgaythem_sp().getMinutes() + ":" + o1.getNgaythem_sp().getSeconds();
            String dateTemp2 = o2.getNgaythem_sp().getDate() + "-" + o2.getNgaythem_sp().getMonth() +
                    "-" + yearTemp2 + " " + o2.getNgaythem_sp().getHours() + ":"
                    + o2.getNgaythem_sp().getMinutes() + ":" + o2.getNgaythem_sp().getSeconds();
            try {
                i = dateFormat.parse(dateTemp2).compareTo(dateFormat.parse(dateTemp1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return i;
        }
    }
//#endregion

    //    ------------------------------------------------------------------------------
//    -                                                                            -
//    -                                                                            -
//    -                                                                            -
//    -         -----------------------------------------------------------        -
//    ------------------------------------------------------------------------------


    private void themHang() {
        final Dialog dialog = new Dialog(SanPhamActivity.this, R.style.DiaLogThemHang);
        dialog.setContentView(R.layout.dialog_sanpham_themhang);
        dialog.show();

        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);
        Button btnAddDialogClick = dialog.findViewById(R.id.btnDialogAddClick);

        final EditText etDialogTenSP = dialog.findViewById(R.id.etDialogTenSP);
        final EditText etDialogSoLuong = dialog.findViewById(R.id.etDialogSoLuong);
        final EditText etDialogGiaSP = dialog.findViewById(R.id.etDialogGiaSP);
        final EditText etDialogMoTaSP = dialog.findViewById(R.id.etDialogMoTaSP);

        etDialogGiaSP.addTextChangedListener(new FormatEditText(etDialogGiaSP));

        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnAddDialogClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Date(year, month, day) => the year minus 1900.
                try {
                    Date currentTime = Calendar.getInstance().getTime();
                    SanPham sanPham = new SanPham(1, etDialogTenSP.getText().toString(), null,
                            Integer.parseInt(etDialogSoLuong.getText().toString()),
                            Integer.parseInt(etDialogGiaSP.getText().toString().replace(".", ",").replace(",","")),
                            etDialogMoTaSP.getText().toString(),
                            null, 0, currentTime, false);
                    sanPhams.add(sanPham);
                    sanPhamAdapter.notifyDataSetChanged();
                    Toast.makeText(SanPhamActivity.this, "Đã thêm thành công", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } catch (Exception e) {
                    Toast.makeText(SanPhamActivity.this, "Vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void suaHang() {
        final Dialog dialog = new Dialog(SanPhamActivity.this, R.style.DiaLogThemHang);
        dialog.setContentView(R.layout.dialog_sanpham_suahang);
        dialog.show();

        final EditText etDialogEditTenSP = dialog.findViewById(R.id.etDialogEditTenSP);
        final EditText etDialogEditSoLuong = dialog.findViewById(R.id.etDialogEditSoLuong);
        final EditText etDialogEditGiaSP = dialog.findViewById(R.id.etDialogEditGiaSP);
        final EditText etDialogEditMoTaSP = dialog.findViewById(R.id.etDialogEditMoTaSP);
        Button btnDialogEditClick = dialog.findViewById(R.id.btnDialogEditClick);
        Button btnDialogClose = dialog.findViewById(R.id.btnDialogClose);

        etDialogEditGiaSP.addTextChangedListener(new FormatEditText(etDialogEditGiaSP));

        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        etDialogEditTenSP.setText(sanPhams.get(positionLongClick).getTen_sp() + "");
        etDialogEditSoLuong.setText(sanPhams.get(positionLongClick).getSoluong_sp() + "");
        etDialogEditGiaSP.setText(sanPhams.get(positionLongClick).getGia_sp() + "");
        etDialogEditMoTaSP.setText(sanPhams.get(positionLongClick).getMota_sp() + "");

        btnDialogEditClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    sanPhams.set(positionLongClick, new SanPham(sanPhams.get(positionLongClick).getId_sp(),
                            etDialogEditTenSP.getText().toString(), sanPhams.get(positionLongClick).getDanhmuc_sp(),
                            Integer.parseInt(etDialogEditSoLuong.getText().toString()), Integer.parseInt(etDialogEditGiaSP.getText().toString().replaceAll(",", "")),
                            etDialogEditMoTaSP.getText().toString(), sanPhams.get(positionLongClick).getAnh_sp(),
                            sanPhams.get(positionLongClick).getLuongnguoidung_sp(), sanPhams.get(positionLongClick).getNgaythem_sp(),
                            sanPhams.get(positionLongClick).getTrangThaiGioHang()));
                    sanPhamAdapter.notifyDataSetChanged();
                    Toast.makeText(SanPhamActivity.this, "Đã sửa thành công!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } catch (Exception e) {
                    Toast.makeText(SanPhamActivity.this, "Vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


//    ********************************************************
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
