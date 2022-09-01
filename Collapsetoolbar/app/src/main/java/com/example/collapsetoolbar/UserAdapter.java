package com.example.collapsetoolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHoder>{
    private List<User> listUser;
    void setData(List<User> list){
        this.listUser = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_user,parent,false);
        return new UserHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHoder holder, int position) {
        User user = listUser.get(position);
        if(user == null) return;
        holder.imganh.setImageResource(user.getResourceId());
        holder.txtdiachi.setText(user.getAddress());
        holder.txtten.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(listUser!=null) return listUser.size();
        return 0;
    }

    public class UserHoder extends RecyclerView.ViewHolder{
        private ImageView imganh;
        private TextView txtten;
        private TextView txtdiachi;
        public UserHoder(@NonNull View itemView) {
            super(itemView);
            imganh = itemView.findViewById(R.id.img_avatar);
            txtten = itemView.findViewById(R.id.name);
            txtdiachi = itemView.findViewById(R.id.diachi);
        }
    }
}
