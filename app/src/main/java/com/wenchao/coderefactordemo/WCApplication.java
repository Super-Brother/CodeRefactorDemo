package com.wenchao.coderefactordemo;

import android.app.Application;

/**
 * @author wenchao
 * @date 2019/7/12.
 * @time 14:57
 * description：
 */
public class WCApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        HttpHelper.init(new VolleyProcessor(this));
        HttpHelper.init(new OkHttpProcessor());
    }
}
