package com.example.sif.mvptest.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.sif.mvptest.Model.RecyclerUser;
import com.example.sif.mvptest.R;
import com.example.sif.mvptest.databinding.ItemLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context context;
    private List<RecyclerUser> users = new ArrayList<>();


    public RecyclerAdapter(Context context, List<RecyclerUser> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(itemLayoutBinding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclerUser user = users.get(position);
        holder.itemLayoutBinding.setRecyclerUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ItemLayoutBinding itemLayoutBinding;

        public MyViewHolder(ItemLayoutBinding itemLayoutBindingobj) {
            super(itemLayoutBindingobj.getRoot());
            itemLayoutBinding = itemLayoutBindingobj;
        }
    }
}
