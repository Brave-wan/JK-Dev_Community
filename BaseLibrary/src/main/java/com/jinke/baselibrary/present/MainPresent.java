package com.jinke.baselibrary.present;


import com.jinke.baselibrary.base.BasePresenter;
import com.jinke.baselibrary.bean.SMSBean;
import com.jinke.baselibrary.http.ApiCallback;
import com.jinke.baselibrary.http.HousingResult;
import com.jinke.baselibrary.http.SmartHttpManager;
import com.jinke.baselibrary.view.IMainView;

import java.util.Map;

public class MainPresent extends BasePresenter<IMainView> {



    public void dealData(Map<String, String> map) {
        if (mView != null) {
            mView.showLoading();
            SmartHttpManager.get().addSubscription(SmartHttpManager.get().getApiStores().getSMS(map), new ApiCallback<HousingResult<SMSBean>>() {
                @Override
                public void onSuccess(HousingResult<SMSBean> model) {
                    // 成功
                    mView.onDealData(model.getMsg());
                    mView.hideLoading();

                }

                @Override
                public void onFailure(HousingResult result) {
                    mView.onDealData(result.getMsg());
                    mView.hideLoading();
                }
            });
        }
    }

}
