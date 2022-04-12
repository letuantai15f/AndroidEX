package com.example.baitap9_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdappter extends RecyclerView.Adapter<UserAdappter.UserView> {
    private Context context;

    private ArrayList<EntityUser> userArrayList;
    public void setData(ArrayList<EntityUser> data){
    this.userArrayList=data;
    notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserView holder, int position) {
        EntityUser entityUser=userArrayList.get(position);
        if(entityUser==null) {
            return;
        }
        holder.tvten.setText(entityUser.getTen());
    }

    @Override
    public int getItemCount() {
        if (userArrayList!=null){
            return userArrayList.size();
        }
        return 0;
    }

    public class  UserView extends RecyclerView.ViewHolder{
        private TextView tvten;

        public UserView(@NonNull View itemView) {
            super(itemView);
            tvten=itemView.findViewById(R.id.txtten);
        }
    }

}
