package com.bawei.demo0417;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.Toast;

import com.bawei.demo0417.bean.MovieBean;
import com.bawei.demo0417.mvp.presenter.MainPresenterIml;
import com.bawei.demo0417.mvp.view.MainView;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenterIml mainPresenterIml = new MainPresenterIml();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=20";

        mainPresenterIml.attch(this);
        mainPresenterIml.showData(url);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

    }

    @Override
    public void success(String data) {
      //  Log.i("aaa", "success: " + data);
        MovieBean movieBean = new Gson().fromJson(data, MovieBean.class);
        final List<MovieBean.ResultBean> result = movieBean.getResult();

        final RecyclerAdapter adapter = new RecyclerAdapter(this,result);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    //    recyclerView.addItemDecoration(new DividerItemDecoration(this,
    //            DividerItemDecoration.VERTICAL));

        DividerItemDecoration decoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        decoration.setDrawable(ContextCompat.getDrawable(this,R.drawable.custom_divider));
        recyclerView.addItemDecoration(decoration);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnRecyclerViewListener(new RecyclerAdapter.onRecyclerViewListener() {
            @Override
            public void setOnClick(int position) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setOnLongClick(int position) {
                Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
                result.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        recyclerView.setAdapter(adapter);

    }

    @Override
    public void fail() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenterIml.detch();
    }
}
