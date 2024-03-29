package com.wenchao.coderefactordemo;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author wenchao
 * @date 2019/7/12.
 * @time 13:06
 * description：相当于房产公司的业务员
 */
public class HttpHelper implements IHttpProcessor {

    private static HttpHelper instance = new HttpHelper();

    private HttpHelper() {
    }

    public static HttpHelper getInstance() {
        synchronized (HttpHelper.class) {
            if (instance == null) {
                instance = new HttpHelper();
            }
        }
        return instance;
    }

    private static IHttpProcessor mHttpProcessor;

    public static void init(IHttpProcessor iHttpProcessor) {
        mHttpProcessor = iHttpProcessor;
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        String finalUrl = appendParams(url, params);
        mHttpProcessor.post(finalUrl, params, callBack);
    }

    private String appendParams(String url, Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }
        StringBuilder urlBuilder = new StringBuilder(url);
        if (urlBuilder.indexOf("?") <= 0) {
            urlBuilder.append("?");
        } else {
            if (!urlBuilder.toString().endsWith("?")) {
                urlBuilder.append("&");
            }
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            urlBuilder.append("&").append(entry.getKey()).append("=").append(encode(entry.getValue().toString()));
        }
        Log.e("url:", urlBuilder.toString());
        return urlBuilder.toString();
    }

    private String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
