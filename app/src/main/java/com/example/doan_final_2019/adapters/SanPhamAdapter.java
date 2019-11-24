package com.example.doan_final_2019.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doan_final_2019.DownloadImage;
import com.example.doan_final_2019.MainActivity;
import com.example.doan_final_2019.R;
import com.example.doan_final_2019.activities.GioHangActivity;
import com.example.doan_final_2019.activities.SanPhamActivity;
import com.example.doan_final_2019.models.GioHang;
import com.example.doan_final_2019.models.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private ArrayList<SanPham> sanPhams;

    public ArrayList<SanPham> orig;
    String trangThaiHang;

    public SanPhamAdapter(Context context, ArrayList<SanPham> sanPhams) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final MyView dataitem;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            dataitem = new MyView();
            convertView = inflater.inflate(R.layout.item_sanpham, null);

            dataitem.iv_imageSP = convertView.findViewById(R.id.iv_imageSP);
            dataitem.tv_tenSP = convertView.findViewById(R.id.tv_tenSP);
            dataitem.tv_soluongSP = convertView.findViewById(R.id.tv_soluongSP);
            dataitem.tv_giatienSP = convertView.findViewById(R.id.tv_giatienSP);
            convertView.setTag(dataitem);
        } else {
            dataitem = (MyView) convertView.getTag();
        }

        if (sanPhams.get(position).getSoluong_sp() >= 20) {
            trangThaiHang = "Còn Nhiều";
        } else if (sanPhams.get(position).getSoluong_sp() < 20 && sanPhams.get(position).getSoluong_sp() > 0) {
            trangThaiHang = "Gần hết";
        } else {
            trangThaiHang = "Hết hàng";
        }

        new DownloadImage(dataitem.iv_imageSP).execute(sanPhams.get(position).getAnh_sp());
        dataitem.tv_tenSP.setText(sanPhams.get(position).getTen_sp() + "");
        dataitem.tv_soluongSP.setText(trangThaiHang);
        dataitem.tv_giatienSP.setText(currencyFormat(String.valueOf(sanPhams.get(position).getGia_sp())) + " VND");
        return convertView;
    }


    private static class MyView {
        ImageView iv_imageSP;
        TextView tv_tenSP, tv_soluongSP, tv_giatienSP;
    }

    public static String currencyFormat(String s) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(Double.parseDouble(s));
    }


    //    search item
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<SanPham> results = new ArrayList<SanPham>();
                if (orig == null)
                    orig = sanPhams;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final SanPham s : orig) {
                            if (s.getTen_sp().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(s);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                sanPhams = (ArrayList<SanPham>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
