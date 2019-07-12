package com.wenchao.coderefactordemo;

import java.util.Map;

/**
 * @author wenchao
 * @date 2019/7/12.
 * @time 13:02
 * description：
 */
public interface IHttpProcessor {

    void post(String url, Map<String, Object> map, ICallBack callBack);
}
