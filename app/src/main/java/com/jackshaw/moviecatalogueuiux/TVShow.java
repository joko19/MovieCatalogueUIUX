package com.jackshaw.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShow implements Parcelable {
    private String judul, deskripsi, kategori, produksitvshow, tampilperdana, isitvshow, poster, imgtvs1, imgtvs2, imgtvs3;

    public TVShow() {
    }

    public TVShow(String judul, String deskripsi, String poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.poster = poster;
    }

    //setter

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setProduksitvshow(String produksitvshow) {
        this.produksitvshow = produksitvshow;
    }

    public void setTampilperdana(String tampilperdana) {
        this.tampilperdana = tampilperdana;
    }

    public void setIsitvshow(String isitvshow) {
        this.isitvshow = isitvshow;
    }

    public void setImgtvs1(String imgtvs1) {
        this.imgtvs1 = imgtvs1;
    }

    public void setImgtvs2(String imgtvs2) {
        this.imgtvs2 = imgtvs2;
    }

    public void setImgtvs3(String imgtvs3) {
        this.imgtvs3 = imgtvs3;
    }
    //getter

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPoster() {
        return poster;
    }

    public String getKategori() {
        return kategori;
    }

    public String getProduksitvshow() {
        return produksitvshow;
    }

    public String getTampilperdana() {
        return tampilperdana;
    }

    public String getIsitvshow() {
        return isitvshow;
    }

    public String getImgtvs1() {
        return imgtvs1;
    }

    public String getImgtvs2() {
        return imgtvs2;
    }

    public String getImgtvs3() {
        return imgtvs3;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.kategori);
        dest.writeString(this.produksitvshow);
        dest.writeString(this.tampilperdana);
        dest.writeString(this.isitvshow);
        dest.writeString(this.poster);
        dest.writeString(this.imgtvs1);
        dest.writeString(this.imgtvs2);
        dest.writeString(this.imgtvs3);
    }

    protected TVShow(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.kategori = in.readString();
        this.produksitvshow = in.readString();
        this.tampilperdana = in.readString();
        this.isitvshow = in.readString();
        this.poster = in.readString();
        this.imgtvs1 = in.readString();
        this.imgtvs2 = in.readString();
        this.imgtvs3 = in.readString();
    }

    public static final Parcelable.Creator<TVShow> CREATOR = new Parcelable.Creator<TVShow>() {
        @Override
        public TVShow createFromParcel(Parcel source) {
            return new TVShow(source);
        }

        @Override
        public TVShow[] newArray(int size) {
            return new TVShow[size];
        }
    };
}
