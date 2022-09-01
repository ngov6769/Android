package com.example.customizespinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterCategory extends BaseAdapter {
    Context context;
    List<Category> list;
    int layout;

    public AdapterCategory(Context context, int layout,List<Category> list) {
        this.context = context;
        this.list = list;
        this.layout = layout;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.dong_list,null);
        TextView seleted = convertView.findViewById(R.id.content);
        Category category = list.get(position);
        seleted.setText(category.getName());
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.dong_item,null);
        TextView tvCategory = convertView.findViewById(R.id.monhoc);
        Category category = list.get(position);
        tvCategory.setText(category.getName());
        return convertView;
    }
}
