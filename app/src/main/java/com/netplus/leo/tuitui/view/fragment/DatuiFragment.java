package com.netplus.leo.tuitui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.netplus.leo.tuitui.R;
import com.netplus.leo.tuitui.view.adapter.DatuiPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by leo on 2016/12/17.
 */

public class DatuiFragment extends android.app.Fragment {
    // 记录当前选中位置
    private int currentIndex;

    private DatuiPageAdapter adapter;
    private List<View> views;
    private static final int[] pics = {R.layout.datui_card,
            R.layout.datui_card, R.layout.datui_card, R.layout.datui_card};


   @BindView(R.id.Datui)
    ViewPager vp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.datui_pege, container, false);
        ButterKnife.bind(this,view);
        views= new ArrayList<View>();
        for (int i = 0; i < pics.length; i++) {
            View mview = LayoutInflater.from(getActivity()).inflate(pics[i], null);
            views.add(mview);
        }
        adapter=new DatuiPageAdapter(views);
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(new PageChangeListener());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int position) {
            // arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
        }

        // 当前页面被滑动时调用
        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {
            // arg0 :当前页面，及你点击滑动的页面
            // arg1:当前页面偏移的百分比
            // arg2:当前页面偏移的像素位置
        }

        // 当新的页面被选中时调用
        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
        }
    }
}