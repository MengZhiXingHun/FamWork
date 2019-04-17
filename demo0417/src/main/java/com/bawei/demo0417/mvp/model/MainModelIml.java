package com.bawei.demo0417.mvp.model;

import com.android.volley.VolleyError;
import com.bawei.demo0417.HttpUtil.VolleyHttp;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainModelIml implements MainModel {
    @Override
    public void getData(String url, final CallBack back) {

        new VolleyHttp().VolleyGet(url, new VolleyHttp.HttpCallBack() {
            @Override
            public void success(String data) {
                back.success(data);
            }

            @Override
            public void fail(VolleyError error) {
                back.fail();
            }
        });

    }
}
