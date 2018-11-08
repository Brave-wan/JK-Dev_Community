package com.jinke.baselibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 17-6-13.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends TitleActivity {
    public T presenter;
    private static List<FragmentActivity> mList = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        presenter = initPresenter();
        if (null != presenter)
            presenter.attach((V) this);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (null != presenter)
            presenter.attach((V) this);
    }


    @Override
    protected void onDestroy() {
        if (null != presenter)
            presenter.dettach();
        super.onDestroy();
    }

    /**
     * 初始化Presenter
     *
     * @return
     */
    public abstract T initPresenter();

    //布局文件ID
    protected abstract int getContentViewId();

    protected abstract void initView();

    public static void addActivity(FragmentActivity activity) {
        mList.add(activity);
    }

    public static void exit() {
        try {
            for (FragmentActivity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
            mList = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

}
