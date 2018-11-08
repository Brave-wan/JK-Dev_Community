package com.jinke.baselibrary.http;

import com.jinke.baselibrary.bean.SMSBean;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by think on 2017/4/13.
 */

public class SmartHttpManager {

    private ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;

    private static SmartHttpManager instance;

    public static SmartHttpManager get() {
        if (instance == null) {
            instance = new SmartHttpManager();
        }
        return instance;
    }

    public ApiStores getApiStores() {
        if (apiStores == null) {
            apiStores = AppClient.getRetrofit().create(ApiStores.class);
        }
        return apiStores;
    }

    public void addSubscription(Observable<HousingResult<SMSBean>> observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    public void addSubscription(Observable<HousingResult<SMSBean>> sms, Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions())
//            mCompositeSubscription.unsubscribe();使用unsubscribe后mCompositeSubscription不能继续使用所以使用clear
            mCompositeSubscription.clear();
    }
}

