package com.wenchao.coderefactordemo;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author wenchao
 * @date 2019/7/12.
 * @time 14:50
 * description：
 */
public abstract class HttpCallBack<T> implements ICallBack {

    @Override
    public void onSuccess(String result) {
        Gson gson = new Gson();
        Class<?> clazz = getT(this);
        T t = (T) gson.fromJson(result, clazz);
        onSuccess(t);
    }

    public abstract void onSuccess(T t);

    private Class<?> getT(Object obj) {
        Type genType = obj.getClass().getGenericSuperclass();
        final Type[] actualTypeArguments = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class<?>) actualTypeArguments[0];
    }

    @Override
    public void onFailure() {

    }
}
