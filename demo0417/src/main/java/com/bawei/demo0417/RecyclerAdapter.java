package com.bawei.demo0417;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.demo0417.bean.MovieBean;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * @作者 杜彬
 * @创建日期 2019/3/20
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private onRecyclerViewListener listener;
    private Context context;
    private List<MovieBean.ResultBean> list;

    public RecyclerAdapter(Context context, List<MovieBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapter.ViewHolder viewHolder, int i) {

        viewHolder.textIntroduce.setText(list.get(i).getSummary());
        viewHolder.textTitle.setText(list.get(i).getName());
        Glide.with(context)
                .load(list.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(viewHolder.pic);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.setOnClick(viewHolder.getAdapterPosition());
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.setOnLongClick(viewHolder.getAdapterPosition());
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView pic;
        private TextView textIntroduce,textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            pic = (ImageView)itemView.findViewById(R.id.pic);
            textIntroduce = (TextView)itemView.findViewById(R.id.textIntroduce);
            textTitle = (TextView)itemView.findViewById(R.id.textTitle);

        }
    }

    public void setOnRecyclerViewListener(onRecyclerViewListener listener){
        this.listener = listener;
    }

    interface onRecyclerViewListener{
        void setOnClick(int position);
        void setOnLongClick(int position);
    }

}
