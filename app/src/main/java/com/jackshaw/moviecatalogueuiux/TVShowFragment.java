package com.jackshaw.moviecatalogueuiux;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {

    View v;
    private String[] datajudul, datadeskripsi, dataKategori, dataProduksitv, dataTayangPerdana, dataKonten, dataposter, img1, img2, img3;
    private ArrayList<TVShow> tvShows;
    private RecyclerView iniRecyclerView;

    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_tvshow, container, false);
        siap();
        tambah();
        iniRecyclerView = (RecyclerView) v.findViewById(R.id.rvtvshow);
        TVShowAdapter initvshow = new TVShowAdapter(getContext(), tvShows);
        iniRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        iniRecyclerView.setAdapter(initvshow);
        return v;
    }

    public void siap(){
        datajudul = getResources().getStringArray(R.array.judul_tvshow);
        datadeskripsi = getResources().getStringArray(R.array.deskripsi_tvshow);
        dataposter = getResources().getStringArray(R.array.poster_tvshow);
        dataKategori = getResources().getStringArray(R.array.kategori);
        dataProduksitv = getResources().getStringArray(R.array.produksi_tv_show);
        dataTayangPerdana = getResources().getStringArray(R.array.tayang_perdana);
        dataKonten = getResources().getStringArray(R.array.konten_tvshow);
        img1 = getResources().getStringArray(R.array.gambar1);
        img2 = getResources().getStringArray(R.array.gambar2);
        img3 = getResources().getStringArray(R.array.gambar3);
    }

    public void tambah(){
        tvShows = new ArrayList<>();
        for (int j=0; j<datajudul.length; j++){
            TVShow initv = new TVShow();
            initv.setJudul(datajudul[j]);
            initv.setDeskripsi(datadeskripsi[j]);
            initv.setPoster(dataposter[j]);
            initv.setKategori(dataKategori[j]);
            initv.setTampilperdana(dataTayangPerdana[j]);
            initv.setProduksitvshow(dataProduksitv[j]);
            initv.setIsitvshow(dataKonten[j]);
            initv.setImgtvs1(img1[j]);
            initv.setImgtvs2(img2[j]);
            initv.setImgtvs3(img3[j]);
            tvShows.add(initv);
        }
    }
}
