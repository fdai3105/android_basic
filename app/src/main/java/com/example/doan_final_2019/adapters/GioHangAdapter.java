package com.example.doan_final_2019.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.models.SanPham;

import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SanPham> sanPhams;

    public GioHangAdapter(Context context, ArrayList<SanPham> sanPhams) {
        this.context = context;
        this.sanPhams = sanPhams;
    }

    @Override
    public int getCount() {
        return sanPhams.size();
    }

    @Override
    public Object getItem(int position) {
        return sanPhams.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            dataitem = new MyView();
            convertView = inflater.inflate(R.layout.item_giohang, null);
            dataitem.tv_idGH = convertView.findViewById(R.id.tv_idGH);
            dataitem.iv_imageGH = convertView.findViewById(R.id.iv_imageGH);
            dataitem.tv_tenGH = convertView.findViewById(R.id.tv_tenGH);
            dataitem.tv_danhmucGH = convertView.findViewById(R.id.tv_danhmucGH);
            dataitem.tv_giatienGH = convertView.findViewById(R.id.tv_giatienGH);
            convertView.setTag(dataitem);
        } else {
            dataitem = (MyView) convertView.getTag();
        }
        dataitem.tv_idGH.setText(sanPhams.get(position).getId_sp()+"");
        new DownloadImage(dataitem.iv_imageGH).execute(sanPhams.get(position).getAnh_sp());
        dataitem.tv_tenGH.setText(sanPhams.get(position).getTen_sp());
        dataitem.tv_danhmucGH.setText(sanPhams.get(position).getDanhmuc_sp()+"");
        dataitem.tv_giatienGH.setText(sanPhams.get(position).getGia_sp()+"");
        return convertView;
    }

    private static class MyView {
        ImageView iv_imageGH;
        TextView tv_tenGH, tv_danhmucGH, tv_giatienGH,tv_idGH;
    }
}
