package com.jackshaw.moviecatalogueuiux;

import android.content.Context;
import android.os.DeadObjectException;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    Context mContext;
    List<Movie> mData;

    public MovieAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.baris_item,viewGroup,false);
        final MyViewHolder iniholder = new MyViewHolder(v);

        iniholder.baris_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent inidetail = new Intent(context, Detail.class);
                inidetail.putExtra(Detail.EXTRA_MOVIE, mData.get(i));
                context.startActivity(inidetail);
            }
        });
        return iniholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.tv_judul.setText(mData.get(i).getJudul());
        myViewHolder.tv_deskripsi.setText(mData.get(i).getDeskripsi());
        final Movie iniMovieee= mData.get(i);
        Glide.with(myViewHolder.baris_item.getContext())
                .load(iniMovieee.getIniposter())
                .apply(new RequestOptions().override(200, 300))
                .into(myViewHolder.img_poster);

        myViewHolder.baris_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent inidetail = new Intent(context, Detail.class);
                inidetail.putExtra(Detail.EXTRA_MOVIE, mData.get(i));
                context.startActivity(inidetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout baris_item;
        private TextView tv_judul;
        private TextView tv_deskripsi;
        private ImageView img_poster;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            baris_item = (RelativeLayout) itemView.findViewById(R.id.baris);
            tv_judul = (TextView) itemView.findViewById(R.id.tv_judul);
            tv_deskripsi = (TextView) itemView.findViewById(R.id.tv_deskripsi);
            img_poster = (ImageView) itemView.findViewById(R.id.img_poster);
        }
    }

}
