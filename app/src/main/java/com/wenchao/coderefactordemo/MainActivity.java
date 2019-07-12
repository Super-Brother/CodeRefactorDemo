package com.wenchao.coderefactordemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String url = "https://api.apiopen.top/getSingleJoke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, Object> params = new HashMap<>();
        params.put("sid", "28654780");
        HttpHelper.getInstance().post(url, params, new ICallBack() {
            @Override
            public void onSuccess(String result) {
                Log.e("result:", result);
            }

            @Override
            public void onFailure() {
                Log.e("result:", "请求失败");
            }
        });
    }
}
