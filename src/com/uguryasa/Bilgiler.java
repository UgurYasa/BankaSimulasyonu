package com.uguryasa;

public class Bilgiler {
    private String ad;
    private String soyad;
    private int yas;
    private String tcNo;
    private String kullaniciAd;
    private String kullaniciSifre;
    private String tNo;
    private String mail;
    private String gSorusu;
    private String gCevabi;
    private String gIpucu;
    private String adres;
    private String amac;
    private double tlBakiye;
    private double dolarBakiye;
    private double euroBakiye;
    private double sterlinBakiye;
    private double altınGram;
    private int cAltin;
    private int yAltin;
    private int tAltin;
    private int cumhuriyetAltin;

    private double borc;

    public Bilgiler(String ad, String soyad, int yas, String tcNo, String kullaniciAd, String kullaniciSifre, String tNo, String mail, String gSorusu, String gCevabi, String gIpucu, String adres, String amac, double tlBakiye, double dolarBakiye, double euroBakiye,double sterlinBakiye,double altınGram,int cAltin,int yAltin,int tAltin,int cumhuriyetAltin,double borc) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.tcNo = tcNo;
        this.kullaniciAd = kullaniciAd;
        this.kullaniciSifre = kullaniciSifre;
        this.tNo = tNo;
        this.mail = mail;
        this.gSorusu = gSorusu;
        this.gCevabi = gCevabi;
        this.gIpucu = gIpucu;
        this.adres = adres;
        this.amac = amac;
        this.tlBakiye = tlBakiye;
        this.dolarBakiye = dolarBakiye;
        this.euroBakiye = euroBakiye;
        this.sterlinBakiye=sterlinBakiye;
        this.altınGram=altınGram;
        this.cAltin=cAltin;
        this.yAltin=yAltin;
        this.cumhuriyetAltin=cumhuriyetAltin;
        this.tAltin=tAltin;
        this.borc=borc;
    }


    public Bilgiler(String ad, String soyad, String yas2, String tcNo, String kullaniciAd, String kullaniciSifre, String tNo, String mail, String gSorusu, String gCevabi, String gIpucu, String adres, String amac, String tlBakiye2, String dolarBakiye2, String euroBakiye2,String sterlinBakiye2,String altınGram2,String cAltin2,String yAltin2,String tAltin2,String cumhuriyetAltin2,String borc2) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = Integer.parseInt(yas2);
        this.tcNo = tcNo;
        this.kullaniciAd = kullaniciAd;
        this.kullaniciSifre = kullaniciSifre;
        this.tNo = tNo;
        this.mail = mail;
        this.gSorusu = gSorusu;
        this.gCevabi = gCevabi;
        this.gIpucu = gIpucu;
        this.adres = adres;
        this.amac = amac;
        this.tlBakiye = Double.valueOf(tlBakiye2);
        this.dolarBakiye = Double.valueOf(dolarBakiye2);
        this.euroBakiye = Double.valueOf(euroBakiye2);
        this.sterlinBakiye=Double.valueOf(sterlinBakiye2);
        this.altınGram=Double.valueOf(altınGram2);
        this.cAltin = Integer.parseInt(cAltin2);
        this.yAltin = Integer.parseInt(yAltin2);
        this.cumhuriyetAltin = Integer.parseInt(cumhuriyetAltin2);
        this.tAltin = Integer.parseInt(tAltin2);
        this.borc=Double.valueOf(borc2);
    }

    public Bilgiler() {
    }

    public double getBorc() {
        return borc;
    }

    public void setBorc(double borc) {
        this.borc = borc;
    }

    public int gettAltin() {
        return tAltin;
    }

    public void settAltin(int tAltin) {
        this.tAltin = tAltin;
    }

    public int getCumhuriyetAltin() {
        return cumhuriyetAltin;
    }

    public void setCumhuriyetAltin(int cumhuriyetAltin) {
        this.cumhuriyetAltin = cumhuriyetAltin;
    }

    public int getyAltin() {
        return yAltin;
    }

    public void setyAltin(int yAltin) {
        this.yAltin = yAltin;
    }

    public int getcAltin() {
        return cAltin;
    }

    public void setcAltin(int cAltin) {
        this.cAltin = cAltin;
    }

    public double getAltınGram() {
        return altınGram;
    }

    public void setAltınGram(double altınGram) {
        this.altınGram = altınGram;
    }

    public double getSterlinBakiye() {
        return sterlinBakiye;
    }

    public void setSterlinBakiye(double sterlinBakiye) {
        this.sterlinBakiye = sterlinBakiye;
    }

    public double getTlBakiye() {
        return tlBakiye;
    }

    public void setTlBakiye(double tlBakiye) {
        this.tlBakiye = tlBakiye;
    }

    public double getDolarBakiye() {
        return dolarBakiye;
    }

    public void setDolarBakiye(double dolarBakiye) {
        this.dolarBakiye = dolarBakiye;
    }

    public double getEuroBakiye() {
        return euroBakiye;
    }

    public void setEuroBakiye(double euroBakiye) {
        this.euroBakiye = euroBakiye;
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

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    public String gettNo() {
        return tNo;
    }

    public void settNo(String tNo) {
        this.tNo = tNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getgSorusu() {
        return gSorusu;
    }

    public void setgSorusu(String gSorusu) {
        this.gSorusu = gSorusu;
    }

    public String getgCevabi() {
        return gCevabi;
    }

    public void setgCevabi(String gCevabi) {
        this.gCevabi = gCevabi;
    }

    public String getgIpucu() {
        return gIpucu;
    }

    public void setgIpucu(String gIpucu) {
        this.gIpucu = gIpucu;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAmac() {
        return amac;
    }

    public void setAmac(String amac) {
        this.amac = amac;
    }


    @Override
    public String toString() {
        return ad+"-"+soyad+"-"+String.valueOf(yas)+"-"+tcNo+"-"+kullaniciAd+"-"+kullaniciSifre+"-"+tNo+"-"+mail+"-"+gSorusu+"-"+gCevabi+"-"+gIpucu+"-"+adres+"-"+amac+"-"+tlBakiye+"-"+String.valueOf(dolarBakiye)+"-"+String.valueOf(euroBakiye)+"-"+String.valueOf(sterlinBakiye)+"-"+String.valueOf(altınGram)+"-"+String.valueOf(cAltin)+"-"+String.valueOf(yAltin)+"-"+String.valueOf(tAltin)+"-"+String.valueOf(cumhuriyetAltin)+"-"+String.valueOf(borc);
    }
}
