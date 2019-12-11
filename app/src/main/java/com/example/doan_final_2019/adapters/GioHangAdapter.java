package com.example.doan_final_2019.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan_final_2019.CurrencyFormat;
import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.activities.GioHangActivity;
import com.example.doan_final_2019.activities.SanPhamActivity;
import com.example.doan_final_2019.activities.SanPhamItemActivity;
import com.example.doan_final_2019.models.GioHang;

import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GioHang> gioHangs;
    private CurrencyFormat currencyFormat = new CurrencyFormat();

    private int tongSL = 0;
    private int tongTien = 0;

    public GioHangAdapter(Context context, ArrayList<GioHang> gioHangs) {
        this.context = context;
        this.gioHangs = gioHangs;
    }

    @Override
    public int getCount() {
        return gioHangs.size();
    }

    @Override
    public Object getItem(int position) {
        return gioHangs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            dataitem = new MyView();
            convertView = inflater.inflate(R.layout.item_giohang, null);
            dataitem.tv_soluongGH = convertView.findViewById(R.id.tv_soluongGH);
            dataitem.iv_imageGH = convertView.findViewById(R.id.iv_imageGH);
            dataitem.tv_tenGH = convertView.findViewById(R.id.tv_tenGH);
            dataitem.tv_danhmucGH = convertView.findViewById(R.id.tv_danhmucGH);
            dataitem.tv_giatienGH = convertView.findViewById(R.id.tv_giatienGH);
            dataitem.btn_xoaGioHang = convertView.findViewById(R.id.btn_xoaGioHang);
            convertView.setTag(dataitem);
        } else {
            dataitem = (MyView) convertView.getTag();
        }
        dataitem.tv_soluongGH.setText("Số lượng: " + gioHangs.get(position).getSoluonghang() + "");
        new DownloadImage(dataitem.iv_imageGH).execute(gioHangs.get(position).getSanPham().getAnh_sp());
        dataitem.tv_tenGH.setText(gioHangs.get(position).getSanPham().getTen_sp());
        dataitem.tv_danhmucGH.setText("Danh mục: " + gioHangs.get(position).getSanPham().getDanhMuc().getTenDanhMuc() + "");
        dataitem.tv_giatienGH.setText("Đơn giá "+(currencyFormat.CurrencyFormat(String.valueOf(gioHangs.get(position).getSanPham().getGia_sp())))+" VND");
        dataitem.btn_xoaGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gioHangs.remove(position);
                SanPhamActivity.numberCart--;
                SanPhamActivity.tvCart.setText(SanPhamActivity.numberCart + "");
                SanPhamItemActivity.tvCart.setText(SanPhamActivity.numberCart + "");
                notifyDataSetChanged();
                changeThanhToan(gioHangs);
                tongSL = 0;
                tongTien = 0;
            }
        });
        return convertView;
    }

    //change when click btn_xoaGioHang
    private void changeThanhToan(ArrayList<GioHang> gioHangs) {
        for (int i = 0; i < gioHangs.size(); i++) {
            tongSL = gioHangs.get(i).getSoluonghang() + tongSL;
        }

        for (int i = 0; i < gioHangs.size(); i++) {
            tongTien = (gioHangs.get(i).getSanPham().getGia_sp() * gioHangs.get(i).getSoluonghang()) + tongTien;
        }

        if (tongSL == 0 && tongTien == 0) {
            GioHangActivity.llEmptyBox.setVisibility(View.VISIBLE);
        }

        GioHangActivity.tv_tongSL.setText(tongSL + "");
        GioHangActivity.tv_tongTien.setText(currencyFormat.CurrencyFormat(String.valueOf(tongTien)) + " VND");
    }

    private static class MyView {
        ImageView iv_imageGH;
        TextView tv_tenGH, tv_danhmucGH, tv_giatienGH, tv_soluongGH;
        Button btn_xoaGioHang;
    }
}
