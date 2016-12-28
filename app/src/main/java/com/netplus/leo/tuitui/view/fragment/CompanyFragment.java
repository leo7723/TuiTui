package com.netplus.leo.tuitui.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.netplus.leo.tuitui.R;
import com.netplus.leo.tuitui.bean.Company;
import com.netplus.leo.tuitui.view.CompanyInfofmationActivity;
import com.netplus.leo.tuitui.view.adapter.CompanyAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by leo on 2016/12/12.
 */

public class CompanyFragment extends android.app.Fragment{
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    ArrayList<Company> list;

    CompanyAdapter companyAdapter;
    Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.company_list,container,false);
        ButterKnife.bind(this,view);
        list=new ArrayList<Company>();
        init();
        companyAdapter=new CompanyAdapter(list,context);

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setAdapter(companyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        companyAdapter.SetOnItemClickListener(new CompanyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent(getActivity(), CompanyInfofmationActivity.class);
                startActivity(intent);
            }
        });
    }

    void  init(){
        for (int i=0;i<10;i++){
            Company company=new Company();
            list.add(company);
        }
    }
}