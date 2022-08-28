package com.example.webservice;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    MainActivity context;
    int layout;
    List<SinhVien> list;

    public SinhVienAdapter(MainActivity context, int layout, List<SinhVien> list) {
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
        TextView hotentxt,namsinhtxt,diachitxt;
        ImageButton xoa,sua;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hoder hoder;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout,null);
            hoder = new Hoder();
            hoder.diachitxt = (TextView) convertView.findViewById(R.id.diachi);
            hoder.hotentxt = (TextView) convertView.findViewById(R.id.hoten);
            hoder.namsinhtxt = (TextView) convertView.findViewById(R.id.namsinh);
            hoder.sua = (ImageButton) convertView.findViewById(R.id.sua);
            hoder.xoa = (ImageButton) convertView.findViewById(R.id.xoa);
            convertView.setTag(hoder);
        }
        else{
            hoder = (Hoder) convertView.getTag();
        }
        SinhVien sinhVien = list.get(position);
        hoder.hotentxt.setText(sinhVien.getHoten());
        hoder.namsinhtxt.setText("Năm sinh: "+sinhVien.getNamsinh());
        hoder.diachitxt.setText(sinhVien.getDiachi());
        hoder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhan(sinhVien.getHoten(),sinhVien.getId());
            }
        });
        hoder.sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                Button xacnhan = (Button) dialog.findViewById(R.id.xacnhanupdatebtn);
                Button huy = (Button) dialog.findViewById(R.id.huyupdatebtn);
                EditText hoten = (EditText) dialog.findViewById(R.id.hotenupdate);
                EditText namsinh = (EditText) dialog.findViewById(R.id.namsinhupdate);
                EditText diachi = (EditText) dialog.findViewById(R.id.diachiupdate);
                hoten.setText(sinhVien.getHoten());
                namsinh.setText(sinhVien.getNamsinh()+"");
                diachi.setText(sinhVien.getDiachi());
                huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                xacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String tenmoi = hoten.getText().toString().trim();
                        String diachimoi = diachi.getText().toString().trim();
                        int namsinhmoi = Integer.parseInt(namsinh.getText().toString().trim());
                        context.ReadUpdate(tenmoi,namsinhmoi,diachimoi,sinhVien.getId());
                        dialog.cancel();
                    }
                });
            }
        });

        return convertView;
    }
    void XacNhan(String ten,int id){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Thông báo!");
        dialog.setMessage("Bạn có muốn xóa "+ten+" ra khỏi danh sách này không?");
        dialog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        dialog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.ReadDelete(id);
            }
        });
        dialog.show();
    }
}
