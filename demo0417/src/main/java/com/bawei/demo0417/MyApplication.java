package com.bawei.demo0417;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class MyApplication extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(getApplicationContext());

    }

    public static RequestQueue getRequestQueue(){
        return requestQueue;
    }

}
