package com.bawei.demo0417.HttpUtil;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.demo0417.MyApplication;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class VolleyHttp {

    public void VolleyGet(String url, final HttpCallBack back){

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        back.success(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        back.fail(error);
                    }
                });

        request.setTag("4月17号日靠题");
        MyApplication.getRequestQueue().add(request);

    }

    public interface HttpCallBack{
        void success(String data);
        void fail(VolleyError error);
    }

}
