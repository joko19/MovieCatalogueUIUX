package com.jackshaw.moviecatalogueuiux;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private TextView tvJudul, judul, tvInfo, tvProduksi, tvTahun, tvKonten;
    private ImageView imgPoster, img1, img2, img3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);


        Movie pilihFilm = getIntent().getParcelableExtra(EXTRA_MOVIE);
        TVShow acara = getIntent().getParcelableExtra(EXTRA_TV);

        tvJudul = findViewById(R.id.tv_judul);
        judul = findViewById(R.id.judul);
        tvInfo = findViewById(R.id.tv_sutradara);
        tvProduksi = findViewById(R.id.tv_produksi);
        tvTahun = findViewById(R.id.tv_tahun);
        tvKonten = findViewById(R.id.tv_content);
        imgPoster = findViewById(R.id.img_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);

        if (pilihFilm != null){
            tvJudul.setText(pilihFilm.getJudul());
            judul.setText(pilihFilm.getJudul());
            tvInfo.setText(pilihFilm.getSutradara());
            tvProduksi.setText(pilihFilm.getProduksi());
            tvTahun.setText(pilihFilm.getTahun());
            tvKonten.setText(pilihFilm.getKonten());
            tambahGambar(pilihFilm.getIniposter(), imgPoster);
            tambahGambar(pilihFilm.getPemeran1(), img1);
            tambahGambar(pilihFilm.getPemeran2(), img2);
            tambahGambar(pilihFilm.getPemeran3(), img3);
        }

        if (acara != null) {
            tvJudul.setText(acara.getJudul());
            judul.setText(acara.getJudul());
            tvInfo.setText(acara.getKategori());
            tvTahun.setText(acara.getTampilperdana());
            tvProduksi.setText(acara.getProduksitvshow());
            tvKonten.setText(acara.getIsitvshow());
            tambahGambar(acara.getPoster(), imgPoster);
            tambahGambar(acara.getImgtvs1(), img1);
            tambahGambar(acara.getImgtvs2(), img2);
            tambahGambar(acara.getImgtvs3(), img3);
        }
    }

    public void tambahGambar(String data, ImageView letak){
            Glide.with(Detail.this)
                    .load(data)
                    .into(letak);
    }
}
