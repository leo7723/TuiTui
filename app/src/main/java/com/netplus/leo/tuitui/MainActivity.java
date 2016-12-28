package com.netplus.leo.tuitui;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;


import com.netplus.leo.tuitui.Utils.AnimatorUtils;
import com.netplus.leo.tuitui.view.fragment.CompanyFragment;
import com.netplus.leo.tuitui.view.fragment.DatuiFragment;
import com.netplus.leo.tuitui.view.fragment.PersenalFragment;
import com.ogaclejapan.arclayout.ArcLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private CompanyFragment companyFragment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.menu_layout)
    FrameLayout menuLayout;
    @BindView(R.id.arc_layout)
    ArcLayout arcLayout;
    @BindView(R.id.fab)
    View fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        fab.setOnClickListener(this);
        for (int i = 0, size = arcLayout.getChildCount(); i < size; i++) {
            arcLayout.getChildAt(i).setOnClickListener(this);
        }
        setDefaultFragment();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        companyFragment=new CompanyFragment();
        transaction.replace(R.id.fragment_container, companyFragment);
        transaction.commit();
    }
    private void setFragment(android.app.Fragment fragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
    //事件监听
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fab:onFabClick(view);break;
            case R.id.company_fragment_button: setFragment(new CompanyFragment());
                hideMenu();fab.setSelected(!fab.isSelected());toolbar.setTitle("腿推"); break;
            case R.id.datui_fragment_button: setFragment(new DatuiFragment());
                hideMenu();fab.setSelected(!fab.isSelected()); toolbar.setTitle("学长信息");break;
            case R.id.personal_fragment_button: setFragment(new PersenalFragment());
                hideMenu();fab.setSelected(!fab.isSelected()); toolbar.setTitle("个人信息");break;
        }

    }
    private void onFabClick(View v) {
        if (v.isSelected()) {
            hideMenu();
        } else {
            showMenu();
        }
        v.setSelected(!v.isSelected());
    }


    //菜单动画
    @SuppressWarnings("New")
    private void showMenu() {
        menuLayout.setVisibility(View.VISIBLE);

        List<Animator> animList = new ArrayList<>();

        for (int i = 0, len = arcLayout.getChildCount(); i < len; i++) {
            animList.add(createShowItemAnimator(arcLayout.getChildAt(i)));
        }

        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
        animSet.setInterpolator(new OvershootInterpolator());
        animSet.playTogether(animList);
        animSet.start();
    }

    @SuppressWarnings("NewApi")
    private void hideMenu() {

        List<Animator> animList = new ArrayList<>();

        for (int i = arcLayout.getChildCount() - 1; i >= 0; i--) {
            animList.add(createHideItemAnimator(arcLayout.getChildAt(i)));
        }

        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(400);
        animSet.setInterpolator(new AnticipateInterpolator());
        animSet.playTogether(animList);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                menuLayout.setVisibility(View.INVISIBLE);
            }
        });
        animSet.start();

    }

    private Animator createShowItemAnimator(View item) {

        float dx = fab.getX() - item.getX();
        float dy = fab.getY() - item.getY();

        item.setRotation(0f);
        item.setTranslationX(dx);
        item.setTranslationY(dy);

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.rotation(0f, 720f),
                AnimatorUtils.translationX(dx, 0f),
                AnimatorUtils.translationY(dy, 0f)
        );

        return anim;
    }

    private Animator createHideItemAnimator(final View item) {
        float dx = fab.getX() - item.getX();
        float dy = fab.getY() - item.getY();

        Animator anim = ObjectAnimator.ofPropertyValuesHolder(
                item,
                AnimatorUtils.rotation(720f, 0f),
                AnimatorUtils.translationX(0f, dx),
                AnimatorUtils.translationY(0f, dy)
        );

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                item.setTranslationX(0f);
                item.setTranslationY(0f);
            }
        });

        return anim;
    }


}
