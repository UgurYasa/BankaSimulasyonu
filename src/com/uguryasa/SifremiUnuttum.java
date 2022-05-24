package com.uguryasa;

import javax.swing.*;
import java.nio.file.Path;
import java.util.List;

public class SifremiUnuttum extends Banka{
    public void sifremiUnuttum(){
        String ad = JOptionPane.showInputDialog(null, "ADINIZ ?", "");

        String soyad = JOptionPane.showInputDialog(null, "SOYADINIZ ?", "");

        String kullaniciAdi = JOptionPane.showInputDialog(null, "KULLANICI ADINIZ ?");
        serit(22);
        ortala(15, 1);
        System.out.println(" AD                   |  ");
        serit(22);
        ortala(22, 0);
        System.out.println(ad);
        serit(22);
        ortala(15, 1);
        System.out.println(" SOYAD                |  ");
        serit(22);
        ortala(22, 0);
        System.out.println(soyad);
        serit(22);
        ortala(15, 1);
        System.out.println(" KULLANICI ADINIZ     |  ");
        serit(22);
        ortala(22, 0);
        System.out.println(kullaniciAdi);
        serit(22);

        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> bankaBilgileri = dosyaIslemleri.getBankaBilgiler();
        GirisEkrani2 girisEkrani=new GirisEkrani2();
        Guncelle guncelle=new Guncelle();

        Bilgiler bilgi=girisEkrani.bilgiDondur( bankaBilgileri,kullaniciAdi,dosyaIslemleri);

        if (bilgi.getAd().equalsIgnoreCase(ad)){
            if (bilgi.getSoyad().equalsIgnoreCase(soyad)){
             if (bilgi.getKullaniciAd().equals(kullaniciAdi)){
                 String gSorusu=bilgi.getgSorusu();
                 String gCevap=bilgi.getgCevabi();
                 String gIpucu=bilgi.getgIpucu();
                 gIpucu=gIpucu.toUpperCase();
                 String musteriCevap = JOptionPane.showInputDialog(null, gSorusu, "");
                 if (musteriCevap.equalsIgnoreCase(gCevap)){
                     String yeniSifre = JOptionPane.showInputDialog(null, "YENİ ŞİFRE BELİRKEYİNİZ : ", "");
                     bilgi.setKullaniciSifre(yeniSifre);
                     dosyaIslemleri.writeFile(bankaBilgileri);
                     JOptionPane.showMessageDialog(null,"ŞİFRENİZ BAŞARIYLA YENİLENDİ.\n\t"+yeniSifre);
                     guncelle.yaz(bilgi);
                 }
                 else {
                     String İpucuCevap = JOptionPane.showInputDialog(null, "CEVABINI HATIRLAMANIZ İÇİN UFAK BİR İPUCU \""+gIpucu+"\"", "");
                     if (İpucuCevap.equalsIgnoreCase(gCevap)) {
                         String yeniSifre = JOptionPane.showInputDialog(null, "YENİ ŞİFRE BELİRKEYİNİZ : ", "");
                         bilgi.setKullaniciSifre(yeniSifre);
                         dosyaIslemleri.writeFile(bankaBilgileri);
                         JOptionPane.showMessageDialog(null,"ŞİFRENİZ BAŞARIYLA YENİLENDİ.\n\t"+yeniSifre);
                     }
                     else {
                         JOptionPane.showMessageDialog(null,"LUTFEN DAHA SONRA TEKRAR DENEYİN");
                     }

                 }

             }
            }
            else {
                String bildirim = soyad + " SOYADINA SAHIP BIR HESAP YOK LÜTFEN DOĞRU YAZDIĞINIZDAN EMIN OLUNUZ VE TEKRAR DENEYINIZ .";
                JOptionPane.showMessageDialog(null,bildirim);
            }

        }
        else {
                String bildirim = ad + " ADINDA BIR HESAP YOK LÜTFEN DOĞRU YAZDIĞINIZDAN EMIN OLUNUZ VE TEKRAR DENEYINIZ .";
                JOptionPane.showMessageDialog(null,bildirim);
            }
        }
    }

