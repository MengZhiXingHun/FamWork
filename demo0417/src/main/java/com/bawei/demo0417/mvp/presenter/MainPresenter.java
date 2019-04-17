package com.bawei.demo0417.mvp.presenter;

import com.bawei.demo0417.mvp.view.MainView;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public interface MainPresenter {

    void attch(MainView mainView);
    void showData(String url);
    void detch();

}
