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
import com.example.doan_final_2019.models.NhanVien;

import java.util.ArrayList;

public class NhanVienAdapter extends BaseAdapter {
    ArrayList<NhanVien> nhanViens = new ArrayList<>();
    Context context;

    public NhanVienAdapter(ArrayList<NhanVien> nhanViens, Context context) {
        this.nhanViens = nhanViens;
        this.context = context;
    }

    @Override
    public int getCount() {
        return nhanViens.size();
    }

    @Override
    public Object getItem(int position) {
        return nhanViens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            dataitem = new MyView();
            convertView = inflater.inflate(R.layout.item_nhanvien, null);

            dataitem.iv_anhNV = convertView.findViewById(R.id.iv_anhNV);
            dataitem.tv_tenNV = convertView.findViewById(R.id.tv_tenNV);
            dataitem.tv_chucviNV = convertView.findViewById(R.id.tv_chucviNV);
            convertView.setTag(dataitem);
        } else {
            dataitem = (MyView) convertView.getTag();
        }
        new DownloadImage(dataitem.iv_anhNV).execute(nhanViens.get(position).getAnh_nv());
        dataitem.tv_tenNV.setText(nhanViens.get(position).getTen_nv());
        dataitem.tv_chucviNV.setText(nhanViens.get(position).getChucvu_nv());
        return convertView;
    }

    private static class MyView {
        ImageView iv_anhNV;
        TextView tv_tenNV;
        TextView tv_chucviNV;
    }
}
