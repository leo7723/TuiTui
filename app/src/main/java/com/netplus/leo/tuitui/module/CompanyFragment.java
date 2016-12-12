package com.netplus.leo.tuitui.module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.netplus.leo.tuitui.R;
import com.netplus.leo.tuitui.bean.Company;
import com.netplus.leo.tuitui.presenter.CompanyPresenter;
import com.netplus.leo.tuitui.view.CompanyView;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by leo on 2016/12/12.
 */

public class CompanyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.company_list,container);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
