package com.jackshaw.moviecatalogueuiux;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.MyViewHolder> {

    Context aContext;
    List<TVShow> atv;

    public TVShowAdapter(Context aContext, List<TVShow> atv) {
        this.aContext = aContext;
        this.atv = atv;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(aContext).inflate(R.layout.baris_item, viewGroup, false);
        MyViewHolder iniholder = new MyViewHolder(v);
        return iniholder;
    }

    @Override
    public void onBindViewHolder(@NonNull TVShowAdapter.MyViewHolder myViewHolder, final int i) {
    myViewHolder.tv_judul.setText(atv.get(i).getJudul());
    myViewHolder.tv_deskripsi.setText(atv.get(i).getDeskripsi());
    final TVShow initv= atv.get(i);
    Glide.with(myViewHolder.baris_item.getContext())
                .load(initv.getPoster())
                .apply(new RequestOptions().override(200, 300))
                .into(myViewHolder.img_poster);
    myViewHolder.baris_item.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = v.getContext();
            Intent inidetail = new Intent(context, Detail.class);
            inidetail.putExtra(Detail.EXTRA_TV, (Parcelable) atv.get(i));
            context.startActivity(inidetail);
        }
    });
    }

    @Override
    public int getItemCount() {
        return atv.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout baris_item;
        private TextView tv_judul, tv_deskripsi;
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
