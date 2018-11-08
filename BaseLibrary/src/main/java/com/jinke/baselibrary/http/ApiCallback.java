package com.jinke.baselibrary.http;

import android.text.TextUtils;

import com.blankj.utilcode.util.NetworkUtils;

import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 作者：Rance on 2016/11/18 15:19
 * 邮箱：rance935@163.com
 */
public abstract class ApiCallback<M> extends Subscriber<M> {

    public abstract void onSuccess(M model);

    public abstract void onFailure(HousingResult result);


    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        HousingResult errorMessageInfo = new HousingResult();
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            errorMessageInfo.setMsg(httpException.getMessage());
            errorMessageInfo.setCode(code);
        } else if (e instanceof SocketTimeoutException) {
            int code = 1000;
            errorMessageInfo.setMsg("连接超时");
            errorMessageInfo.setCode(code);
        }
        if (!NetworkUtils.isConnected()) {
            errorMessageInfo.setMsg("请检查网络连接");
        }
        if (!TextUtils.isEmpty(errorMessageInfo.getMsg())) {
            onFailure(errorMessageInfo);
        }
    }

    @Override
    public void onNext(M model) {
        int code = ((HousingResult) model).getCode();
        HousingResult baseResult = new HousingResult();
        switch (code) {
            case 200:
                onSuccess(model);
                break;
            default:
                baseResult.setCode(code);
                baseResult.setMsg(((HousingResult) model).getMsg());
                onFailure(baseResult);
                break;
        }
    }

    @Override
    public void onCompleted() {
    }

}
