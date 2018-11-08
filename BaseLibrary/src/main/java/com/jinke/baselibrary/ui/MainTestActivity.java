package com.jinke.baselibrary.ui;

import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.jinke.baselibrary.R;
import com.jinke.baselibrary.base.BaseActivity;
import com.jinke.baselibrary.present.MainPresent;
import com.jinke.baselibrary.view.IMainView;

import java.util.HashMap;
import java.util.Map;


public class MainTestActivity extends BaseActivity<IMainView, MainPresent> implements IMainView, View.OnClickListener {


    @Override
    public MainPresent initPresenter() {
        return new MainPresent();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.tx_main_request).setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tx_main_request) {
            Map<String, String> map = new HashMap<>();
            presenter.dealData(map);

        }
    }
}
