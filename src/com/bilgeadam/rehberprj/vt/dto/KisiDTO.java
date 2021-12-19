package com.bilgeadam.rehberprj.vt.dto;

import java.util.Date;

public class KisiDTO {

    private String ad;
    private String soyad;
    private double maas;
    private Date dogtar;
    private String mobil_telefon;

    private int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    public Date getDogtar() {
        return dogtar;
    }

    public void setDogtar(Date dogtar) {
        this.dogtar = dogtar;
    }

    public String getMobil_telefon() {
        return mobil_telefon;
    }

    public void setMobil_telefon(String mobil_telefon) {
        this.mobil_telefon = mobil_telefon;
    }


}
