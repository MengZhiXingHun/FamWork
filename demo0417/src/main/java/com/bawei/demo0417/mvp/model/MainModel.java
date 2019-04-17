package com.bawei.demo0417.mvp.model;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface MainModel {

    interface CallBack{
        void success(String data);
        void fail();
    }

    void getData(String url,CallBack back);

}
