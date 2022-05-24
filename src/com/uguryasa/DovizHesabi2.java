package com.uguryasa;

import javax.swing.*;

public class DovizHesabi2 extends Banka {
    public void dovizIslem(Bilgiler bilgi){
        Guncelle guncelle=new Guncelle();
        String temp;
        double t;
        double miktar;
        double tl= bilgi.getTlBakiye();
        double dolar= bilgi.getDolarBakiye();
        double euro= bilgi.getEuroBakiye();
        double sterlin=bilgi.getSterlinBakiye();
        String secenekler[] = { "TL>>>DOVIZ", "DOVIZ>>>TL","ÇIKIŞ"};
        String soru = "TL BAKIYENİZ      : "+tl+" TL\nDOLAR BAKİYE   : "+dolar+" $\nEURO BAKIYE      : "+euro+" €\nSTERLIN BAKIYE : "+sterlin+" £\n --YAPMAK İSTEDİĞİNİZ İŞLEMİ SECİNİZ-- ";
        String baslik = "                         DOVİZ HESABİ";
        int n = JOptionPane.showOptionDialog(null, soru, baslik,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                secenekler, secenekler[0]);


        String a="DOLAR   >>>>> "+dolarKuru+" TL";
        String b="EURO   >>>>> "+euroKuru+" TL";
        String c="STERLIN   >>>>> "+sterlinKuru+" TL";
        String[] dizi = new String[]{a,b,c};

        if (n==0){
            String soru2 = "Hangi işlemi yapmak istiyorsunuz ?";
            String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                    JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[2]);


            if (secim==a){
                String soru3 = "TL >>> DOLAR \n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru3, "");
                miktar=Double.parseDouble(f);
                if (miktar>tl){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n TL BAKIYENİZ >>>"+tl);
                    dovizIslem(bilgi);
                }
                else {
                    t=miktar / dolarKuru;
                    double dolar2 = (double) (Math.round(t*100.0)/100.0);
                    dolar = dolar+dolar2;
                    double turkLirasi = tl - miktar;
                    tl=(double) (Math.round(turkLirasi*100.0)/100.0);
                    bilgi.setDolarBakiye(dolar);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nDOLAR BAKİYENİZ : "+bilgi.getDolarBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);


            }
            else if (secim==b){
                String soru4 = "TL >>> EURO \n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru4, "");
                miktar=Double.parseDouble(f);
                if (miktar>tl){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n TL BAKIYENİZ >>>"+tl);
                    dovizIslem(bilgi);
                }
                else {
                    t = miktar / euroKuru;
                    double euro2=(double) (Math.round(t*100.0)/100.0);
                    euro=euro+euro2;
                    double turkLirasi = tl - miktar;
                    tl=(double) (Math.round(turkLirasi*100.0)/100.0);
                    bilgi.setEuroBakiye(euro);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nEURO BAKİYENİZ : "+bilgi.getEuroBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);

            }
            else if (secim==c){
                String soru5 = "TL >>> STERLİN \n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru5, "");
                miktar=Double.parseDouble(f);
                if (miktar>tl){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n TL BAKIYENİZ >>>"+tl);
                    dovizIslem(bilgi);
                }
                else {
                    t= miktar / sterlinKuru;
                    double sterlin2=(double) (Math.round(t*100.0)/100.0);
                    sterlin=sterlin+sterlin2;
                    double turkLirasi = tl - miktar;
                    tl=(double) (Math.round(turkLirasi*100.0)/100.0);
                    bilgi.setSterlinBakiye(sterlin);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nSTERLİN BAKİYENİZ : "+bilgi.getSterlinBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);


            }
        }

        else if (n==1){
            String soru2 = "Hangi işlemi yapmak istiyorsunuz ?";
            String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                    JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[2]);


            if (secim==a){
                String soru3 = "DOLAR >>> TL \nDOLAR BAKİYE  : "+dolar+" $\n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru3, "");
                miktar=Double.parseDouble(f);
                if (miktar>dolar){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n DOLAR BAKIYENİZ >>>"+dolar);
                    dovizIslem(bilgi);
                }
                else {
                    t=miktar * dolarKuru;
                    double tl2 = (double) (Math.round(t*100.0)/100.0);
                    tl = tl+tl2;
                    dolar = dolar - miktar;
                    double dolar2=(double) (Math.round(dolar*100.0)/100.0);
                    bilgi.setDolarBakiye(dolar2);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nDOLAR BAKİYENİZ : "+bilgi.getDolarBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);


            }
            else if (secim==b){
                String soru4 = "EURO >>> TL \nEURO BAKİYE  : "+euro+" $\n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru4, "");
                miktar=Double.parseDouble(f);
                if (miktar>euro){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n EURO BAKIYENİZ >>>"+euro);
                    dovizIslem(bilgi);
                }
                else {
                    t = miktar * euroKuru;
                    double tl2=(double) (Math.round(t*100.0)/100.0);
                    euro=euro-miktar;
                    double euro2=(double) (Math.round(euro*100.0)/100.0);
                    tl = tl + tl2;
                    bilgi.setEuroBakiye(euro2);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nEURO BAKİYENİZ : "+bilgi.getEuroBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);

            }
            else if (secim==c){
                String soru5 = "STERLİN >>> TL \nSTERLİN BAKİYE  : "+sterlin+" $\n --CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ-- ";
                String f = JOptionPane.showInputDialog(null, soru5, "");
                miktar=Double.parseDouble(f);
                if (miktar>sterlin){
                    JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n STERLİN BAKIYENİZ >>>"+sterlin);
                    dovizIslem(bilgi);
                }
                else {
                    t= miktar * sterlinKuru;
                    double tl2=(double) (Math.round(t*100.0)/100.0);
                    sterlin=sterlin-miktar;
                    double sterlin2=(double) (Math.round(sterlin*100.0)/100.0);
                    tl = tl + tl2;
                    bilgi.setSterlinBakiye(sterlin2);
                    bilgi.setTlBakiye(tl);
                    temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+"\nSTERLİN BAKİYENİZ : "+bilgi.getSterlinBakiye();
                    JOptionPane.showMessageDialog(null,temp);
                    guncelle.yaz(bilgi);
                }
                dovizIslem(bilgi);

            }
        }

    }}
