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
import com.example.doan_final_2019.activities.DanhMucItemActivity;
import com.example.doan_final_2019.activities.SanPhamActivity;
import com.example.doan_final_2019.models.DanhMuc;

import java.util.ArrayList;
import java.util.Random;

public class DanhMucAdapter extends BaseAdapter {
    private ArrayList<DanhMuc> danhMucs;
    private Context context;

    public DanhMucAdapter(ArrayList<DanhMuc> danhMucs, Context context) {
        this.danhMucs = danhMucs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return danhMucs.size();
    }

    @Override
    public Object getItem(int position) {
        return danhMucs.get(position);
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
            convertView = inflater.inflate(R.layout.item_danhmuc, null);
            dataitem.iv_imageDM = convertView.findViewById(R.id.iv_imageDM);
            dataitem.tv_tenDM = convertView.findViewById(R.id.tv_tenDM);
            convertView.setTag(dataitem);
        } else {
            dataitem = (MyView) convertView.getTag();
        }
        dataitem.tv_tenDM.setText(danhMucs.get(position).getTenDanhMuc());
        if (danhMucs.get(position).getAnhDanhMuc().trim().length() == 0) {
            new DownloadImage(dataitem.iv_imageDM).execute("https://sanitationsolutions.net/wp-content/uploads/2015/05/empty-image.png");
        } else {
            new DownloadImage(dataitem.iv_imageDM).execute(danhMucs.get(position).getAnhDanhMuc());
        }
        return convertView;
    }

    private static class MyView {
        ImageView iv_imageDM;
        TextView tv_tenDM;
    }
}
