package com.jackshaw.moviecatalogueuiux;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.jackshaw.moviecatalogueuiux.Detail.EXTRA_MOVIE;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment implements  View.OnClickListener{
    View v;
    private RecyclerView myrecyclerview;
    private String[] dataJudul, dataDeskripsi, dataSutradara, dataProduksi, dataTahun, dataKonten, poster, dataPemeran1, dataPemeran2, dataPemeran3;
    private ArrayList<Movie> movies;
    public MoviesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_movies, container, false);
        prepare();
        addItem();
        myrecyclerview = (RecyclerView) v.findViewById(R.id.rv_movies);
        MovieAdapter inimovieadapter = new MovieAdapter(getContext(), movies);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(inimovieadapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.data_movie);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        poster = getResources().getStringArray(R.array.data_poster);
        dataSutradara = getResources().getStringArray(R.array.dataSutradara);
        dataProduksi = getResources().getStringArray(R.array.dataProduksi);
        dataTahun = getResources().getStringArray(R.array.dataTahun);
        dataPemeran2 = getResources().getStringArray(R.array.data_pemeran1);
        dataPemeran1 = getResources().getStringArray(R.array.data_pemeran2);
        dataPemeran3 = getResources().getStringArray(R.array.data_pemeran3);
        dataKonten = getResources().getStringArray(R.array.dataKonten);

    }
    private void addItem(){
        movies = new ArrayList<>();
        for (int i=0; i<dataJudul.length; i++){
            Movie ikimovie = new Movie();
            ikimovie.setJudul(dataJudul[i]);
            ikimovie.setDeskripsi(dataDeskripsi[i]);
            ikimovie.setIniposter(poster[i]);
            ikimovie.setSutradara(dataSutradara[i]);
            ikimovie.setProduksi(dataProduksi[i]);
            ikimovie.setTahun(dataTahun[i]);
            ikimovie.setKonten(dataKonten[i]);
            ikimovie.setPemeran1(dataPemeran1[i]);
            ikimovie.setPemeran2(dataPemeran2[i]);
            ikimovie.setPemeran3(dataPemeran3[i]);
            movies.add(ikimovie);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
