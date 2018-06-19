package com.example.administrator.viewpagertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainFragmentActivity extends FragmentActivity implements View.OnClickListener {

    // 三个tab布局
    private RelativeLayout knowLayout, iWantKnowLayout, meLayout;
    // 底部标签切换的Fragment
    private Fragment knowFragment, iWantKnowFragment, meFragment, currentFragment;
    // 底部标签图片
    private ImageView knowImg, iWantKnowImg, meImg;
    // 底部标签的文本
    private TextView knowTv, iWantKnowTv, meTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main_layout);
        initUI();
        initTab();
    }
    /**
     * 初始化UI
     */
    private void initUI() {
        knowLayout = (RelativeLayout) findViewById(R.id.rl_know);
        iWantKnowLayout = (RelativeLayout) findViewById(R.id.rl_want_know);
        meLayout = (RelativeLayout) findViewById(R.id.rl_me);
        knowLayout.setOnClickListener(this);
        iWantKnowLayout.setOnClickListener(this);
        meLayout.setOnClickListener(this);

        knowImg = (ImageView) findViewById(R.id.iv_know);
        iWantKnowImg = (ImageView) findViewById(R.id.iv_i_want_know);
        meImg = (ImageView) findViewById(R.id.iv_me);
        knowTv = (TextView) findViewById(R.id.tv_know);
        iWantKnowTv = (TextView) findViewById(R.id.tv_i_want_know);
        meTv = (TextView) findViewById(R.id.tv_me);

    }

    /**
     * 初始化底部标签
     */
    private void initTab() {
        if (knowFragment == null) {
            knowFragment = new ZhidaoFragment();
        }

        if (!knowFragment.isAdded()) {
            // 提交事务
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content_layout, knowFragment).commit();

            // 记录当前Fragment
            currentFragment = knowFragment;
            // 设置图片文本的变化
            knowImg.setImageResource(R.drawable.btn_know_pre);
            knowTv.setTextColor(getResources()
                    .getColor(R.color.bottomtab_press));
            iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
            iWantKnowTv.setTextColor(getResources().getColor(
                    R.color.bottomtab_normal));
            meImg.setImageResource(R.drawable.btn_my_nor);
            meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_know: // 知道
                showFragment1();
                break;
            case R.id.rl_want_know: // 我想知道
                showFragment2();
                break;
            case R.id.rl_me: // 我的
                showFragment3();
                break;
            default:
                break;
        }
    }

    /**
     * 点击第一个tab
     */
    private void showFragment1() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (knowFragment == null) {
            knowFragment = new ZhidaoFragment();
            transaction.add(R.id.content_layout,knowFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(knowFragment);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        knowImg.setImageResource(R.drawable.btn_know_pre);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
    }

    /**
     * 点击第二个tab
     */
    private void showFragment2() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (iWantKnowFragment == null) {
            iWantKnowFragment = new IWantKnowFragment();
            transaction.add(R.id.content_layout,iWantKnowFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(iWantKnowFragment);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        knowImg.setImageResource(R.drawable.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_pre);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_press));
        meImg.setImageResource(R.drawable.btn_my_nor);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

    }

    /**
     * 点击第三个tab
     */
    private void showFragment3() {
        //开启事务，fragment的控制是由事务来实现的
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        //第一种方式（add），初始化fragment并添加到事务中，如果为null就new一个
        if (meFragment == null) {
            meFragment = new MeFragment();
            transaction.add(R.id.content_layout,meFragment);
        }
        //隐藏所有fragment
        hideFragment(transaction);
        //显示需要显示的fragment
        transaction.show(meFragment);
        //提交事务
        transaction.commit();
        // 设置底部tab变化
        knowImg.setImageResource(R.drawable.btn_know_nor);
        knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
        iWantKnowImg.setImageResource(R.drawable.btn_wantknow_nor);
        iWantKnowTv.setTextColor(getResources().getColor(
                R.color.bottomtab_normal));
        meImg.setImageResource(R.drawable.btn_my_pre);
        meTv.setTextColor(getResources().getColor(R.color.bottomtab_press));

    }

    //隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        if(knowFragment != null){
            transaction.hide(knowFragment);
        }
        if(iWantKnowFragment != null){
            transaction.hide(iWantKnowFragment);
        }
        if(meFragment != null){
            transaction.hide(meFragment);
        }
    }

}
