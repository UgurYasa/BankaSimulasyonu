package com.uguryasa;

import javax.swing.*;
import java.util.Scanner;

public class SecimBir extends Görüntü {

    public  String bankaHosgeldiniz(){
        String secenekler2[] = { "GİRİŞ YAPMAK İSTİYORUM ", "ÜYE OLMAK İSTİYORUM","ÇIKIŞ"};
        String soru = "--YAPMAK İSTEDİĞİNİZ GİRİŞİ SEÇİNİZ-- ";
        String baslik = "Bir Soru";
        sharp(125);
        System.out.println();
        Scanner scanner=new Scanner(System.in);
        for(int i=0;i<=20;i++){
            System.out.print("//");
        }
        System.out.print(" B A N K A M I Z A   H O Ş G E L D İ N İ Z ");
        for(int i=0;i<=40;i++){
            System.out.print("\\");
        }
        System.out.println();
        sharp(125);
        System.out.println();
        sharp(125);
        System.out.println();
        System.out.println();
        serit(36);
        ortala(15,0);
        System.out.print("--YAPMAK İSTEDİĞİNİZ GİRİŞİ SEÇİNİZ--  ");
        System.out.println();
        serit(36);
        ortala(15,1);
        System.out.print(" 1 - ) GİRİŞ YAPMAK İSTİYORUM      |  ");
        System.out.println();
        serit(36);
        ortala(15,1);
        System.out.print(" 2 - ) ÜYE OLMAK İSTİYORUM         |  ");
        System.out.println();
        serit(36);
        ortala(15,1);
        System.out.print(" 3 - ) ÇIKIŞ                       |  ");
        System.out.println();
        serit(36);

        baslik = "                                   BANKAMIZA HOSGELDİNİZ";
        int n = JOptionPane.showOptionDialog(null, soru, baslik,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                secenekler2, secenekler2[0]);

        return secenekler2[n];

    }

    public  void giris(){
        GirisEkrani2 girisEkrani=new GirisEkrani2();
        KayitEkrani2 kayitEkrani2=new KayitEkrani2();

        int i=0;
        IslemEkrani islemEkrani=new IslemEkrani();// bu degerden sonra gelen yeni ekrana geç ikinci var 0 ver!!
        SecimBir s1=new SecimBir();
        //girisEkrani.yeniEkranaGec(0,1);
        String secenek1 = s1.bankaHosgeldiniz();
        girisEkrani.yukleniyor(2);
        switch (secenek1){
            case "GİRİŞ YAPMAK İSTİYORUM ":
                girisEkrani.yeniEkranaGec(1,1);
                GirisEkrani2 girisEkrani2=new GirisEkrani2();
                Bilgiler bilgi= girisEkrani2.girisEkrani();
                girisEkrani.yeniEkranaGec(1,1);
                if (bilgi==null){
                    giris();
                    break;}
                String secim=islemEkrani.islemEkrani(bilgi);
                islemEkrani.yeniEkranaGec(1,0);
                giris();
                break;
            case "ÜYE OLMAK İSTİYORUM":
                girisEkrani.yeniEkranaGec(1,1);
                kayitEkrani2.kayitEkrani2();
                giris();
                break;

            case "ÇIKIŞ":
                JOptionPane.showMessageDialog(null,"IYI GUNLER DİLERİZ. :)");
                break;

        }

    }
}


