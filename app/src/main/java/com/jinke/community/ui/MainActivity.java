package com.jinke.community.ui;

import android.content.Intent;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.jinke.baselibrary.base.BaseActivity;
import com.jinke.baselibrary.ui.MainTestActivity;
import com.jinke.community.R;
import com.jinke.community.present.MainPresent;
import com.jinke.community.view.IMainView;

public class MainActivity extends BaseActivity<IMainView, MainPresent> implements IMainView {


    @Override
    public MainPresent initPresenter() {
        return new MainPresent();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_test_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tx_main_top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainTestActivity.class));
            }
        });

    }

    @Override
    public void showLoading() {
        //显示对话框

    }

    @Override
    public void hideLoading() {
        //隐藏对话框

    }

    @Override
    public void onDealData(String s) {
        ToastUtils.showShort(s);
    }
}
