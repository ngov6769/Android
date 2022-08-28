package com.example.sqlhinhanh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<HinhAnh> list;

    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class Hoder{
        TextView ten,mota;
        ImageView hinh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hoder hoder;
        if(convertView == null){
            hoder = new Hoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            hoder.hinh = convertView.findViewById(R.id.loadhinh);
            hoder.mota = convertView.findViewById(R.id.mota);
            hoder.ten = convertView.findViewById(R.id.ten);
            convertView.setTag(hoder);
        }
        else{
            hoder = (Hoder) convertView.getTag();
        }
        HinhAnh hinhanh = list.get(position);
        hoder.ten.setText(hinhanh.getTen());
        hoder.mota.setText(hinhanh.getMota());
        byte[] ha = hinhanh.getAnh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(ha,0,ha.length);
        hoder.hinh.setImageBitmap(bitmap);
        return convertView;
    }
}
