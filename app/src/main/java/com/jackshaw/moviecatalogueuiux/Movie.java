package com.jackshaw.moviecatalogueuiux;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String judul, deskripsi, sutradara, produksi, tahun, konten, iniposter, pemeran1, pemeran2, pemeran3;
    public Movie() {
    }

    public Movie(String judul, String deskripsi, String poster) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        iniposter = poster;
    }

    //setter

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public void setProduksi(String produksi) {
        this.produksi = produksi;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setPemeran1(String pemeran1) {
        this.pemeran1 = pemeran1;
    }

    public void setPemeran2(String pemeran2) {
        this.pemeran2 = pemeran2;
    }

    public void setPemeran3(String pemeran3) {
        this.pemeran3 = pemeran3;
    }
//getter

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getSutradara() {
        return sutradara;
    }

    public String getProduksi() {
        return produksi;
    }

    public String getTahun() {
        return tahun;
    }

    public String getKonten() {
        return konten;
    }

    public String getPemeran1() {
        return pemeran1;
    }

    public String getPemeran2() {
        return pemeran2;
    }

    public String getPemeran3() {
        return pemeran3;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.sutradara);
        dest.writeString(this.produksi);
        dest.writeString(this.tahun);
        dest.writeString(this.konten);
        dest.writeString(this.iniposter);
        dest.writeString(this.pemeran1);
        dest.writeString(this.pemeran2);
        dest.writeString(this.pemeran3);

    }

    protected Movie(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.sutradara = in.readString();
        this.produksi = in.readString();
        this.tahun = in.readString();
        this.konten = in.readString();
        this.iniposter = in.readString();
        this.pemeran1 = in.readString();
        this.pemeran2 = in.readString();
        this.pemeran3 = in.readString();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


    public String getIniposter() {
        return iniposter;
    }

    public void setIniposter(String iniposter) {
        this.iniposter = iniposter;
    }
}
