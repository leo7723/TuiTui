package com.netplus.leo.tuitui.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.netplus.leo.tuitui.MainActivity;
import com.netplus.leo.tuitui.R;
import com.netplus.leo.tuitui.bean.Company;
import com.netplus.leo.tuitui.view.fragment.CompanyFragment;

import java.util.ArrayList;

/**
 * Created by leo on 2016/12/23.
 */

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private ArrayList<Company> list;
    private Context context;
    OnItemClickListener mItemClickListener;

    public CompanyAdapter(ArrayList<Company> list, Context context){
        this.list=list;
        this.context=context;
    }
    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CompanyViewHolder holder= new CompanyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.company_list_item,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        //holder.Job.setImageURI(list.get(position).getCompanyName());
        //holder.Job.setImageURI(list.get(position).getCompanyName());
    }


    @Override
    public int getItemCount() {

        return list.size();
    }
    class CompanyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView Company;
        ImageView Job;
        TextView textView;
        public CompanyViewHolder(View itemView) {
            super(itemView);
            Company= (ImageView) itemView.findViewById(R.id.company_image);
            Job= (ImageView) itemView.findViewById(R.id.job_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mItemClickListener!=null){
            mItemClickListener.onItemClick(view,getPosition());
            }
        }
    }
    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
