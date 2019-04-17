package com.bawei.demo0417.mvp.presenter;

import com.bawei.demo0417.mvp.model.MainModel;
import com.bawei.demo0417.mvp.model.MainModelIml;
import com.bawei.demo0417.mvp.view.MainView;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MainPresenterIml implements MainPresenter {

    private MainModelIml mainModelIml;
    private MainView mainView;

    @Override
    public void attch(MainView mainView) {
        mainModelIml = new MainModelIml();
        this.mainView = mainView;
    }

    @Override
    public void showData(String url) {
        mainModelIml.getData(url, new MainModel.CallBack() {
            @Override
            public void success(String data) {
                mainView.success(data);
            }

            @Override
            public void fail() {
                mainView.fail();
            }
        });
    }

    @Override
    public void detch() {
        if (mainModelIml != null){
            mainModelIml = null;
        }
        if (mainView != null){
            mainView = null;
        }
        System.gc();
    }
}
