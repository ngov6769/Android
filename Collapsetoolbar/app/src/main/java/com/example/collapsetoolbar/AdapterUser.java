package com.example.collapsetoolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterUser extends BaseAdapter {
    Context context;
    int layout;
    List<User> list;

    public AdapterUser(Context context, int layout, List<User> list) {
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
        ImageView imghinh;
        TextView nametxt,diachitxt;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hoder hoder;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            hoder = new Hoder();
            hoder.diachitxt = convertView.findViewById(R.id.diachi);
            hoder.imghinh = convertView.findViewById(R.id.img_avatar);
            hoder.nametxt = convertView.findViewById(R.id.name);
            convertView.setTag(hoder);
        }else{
            hoder = (Hoder) convertView.getTag();
        }
        User user = list.get(position);
        hoder.nametxt.setText(user.getName());
        hoder.diachitxt.setText(user.getAddress());
        hoder.imghinh.setImageResource(user.getResourceId());
        return convertView;
    }
}
