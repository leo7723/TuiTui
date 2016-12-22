package com.netplus.leo.tuitui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.netplus.leo.tuitui.R;

import butterknife.BindView;

/**
 * Created by leo on 2016/12/17.
 */

public class PersenalFragment extends android.app.Fragment{
    @BindView(R.id.persenal_tv)
    TextView persenal_tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater.inflate(R.layout.persenal_page,container);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}