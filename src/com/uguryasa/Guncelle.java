package com.uguryasa;

import javax.swing.*;
import java.nio.file.Path;
import java.util.List;

public class Guncelle extends Görüntü{
    public void yaz(Bilgiler bilgi){
        GirisEkrani2 girisEkrani=new GirisEkrani2();
        Banka banka=new Banka();
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> bankaBilgileri = dosyaIslemleri.getBankaBilgiler();
        int a= girisEkrani.dondur(bankaBilgileri,bilgi.getKullaniciAd());
        Bilgiler degisikBilgi=bankaBilgileri.get(a);
        degisikBilgi.setAd(bilgi.getAd().trim());
        degisikBilgi.setSoyad(bilgi.getSoyad().trim());
        degisikBilgi.setYas(bilgi.getYas());
        degisikBilgi.setTcNo(bilgi.getTcNo().trim());
        degisikBilgi.setKullaniciAd(bilgi.getKullaniciAd().trim());
        degisikBilgi.setKullaniciSifre(bilgi.getKullaniciSifre().trim());
        degisikBilgi.settNo(bilgi.gettNo().trim());
        degisikBilgi.setMail(bilgi.getMail().trim());
        degisikBilgi.setgSorusu(bilgi.getgSorusu().trim());
        degisikBilgi.setgCevabi(bilgi.getgCevabi().trim());
        degisikBilgi.setgIpucu(bilgi.getgIpucu().trim());
        degisikBilgi.setAdres(bilgi.getAdres().trim());
        degisikBilgi.setAmac(bilgi.getAmac().trim());
        double tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
        degisikBilgi.setTlBakiye(tlBakiye);
        degisikBilgi.setDolarBakiye(bilgi.getDolarBakiye());
        degisikBilgi.setEuroBakiye(bilgi.getEuroBakiye());
        degisikBilgi.setSterlinBakiye(bilgi.getSterlinBakiye());
        degisikBilgi.setAltınGram(bilgi.getAltınGram());
        degisikBilgi.setcAltin(bilgi.getcAltin());
        degisikBilgi.setyAltin(bilgi.getyAltin());
        degisikBilgi.setCumhuriyetAltin(bilgi.getCumhuriyetAltin());
        degisikBilgi.settAltin(bilgi.gettAltin());
        degisikBilgi.setBorc(bilgi.getBorc());
        banka.writeFile3(bankaBilgileri);

    }
    public void guncelle(Bilgiler bilgiler){
        int i=0;
        String dizi[] = { "AD", "SOYAD","YAŞ","TC KİMLİK NUMARASI","KULLANICI ADI","KULLANICI SİFRESİ","TELEFON NUMARASI","E - MAİL","GÜVENLİK SORUSU BELİRLEME","GÜVENLİK SORUSU CEVABI","GÜVENLİK SORUSU İPUCU", "ADRES","HESABI KULLANIM AMACINIZ","KAPAT"};
        String soru = "--DEĞİŞTİRMEK İSTEDİĞİNİZ GİRİŞİ SEÇİNİZ-- ";
        String baslik = "                    DEĞİŞTİRME PENCERESİ";

        while(i<13){
            String temp="";
            String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                    JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[13]);
            if (secim!="KAPAT") {
                temp = JOptionPane.showInputDialog(null, secim, "");
            }
            i++;
            switch (secim) {
                case "AD":
                    JOptionPane.showMessageDialog(null,bilgiler.getAd()+">>>"+temp);
                    bilgiler.setAd(temp);
                    break;

                case "SOYAD":
                    JOptionPane.showMessageDialog(null,bilgiler.getSoyad()+">>>"+temp);
                    bilgiler.setSoyad(temp);
                    break;
                case "YAŞ":
                    JOptionPane.showMessageDialog(null,bilgiler.getYas()+">>>"+temp);
                    int yas=Integer.parseInt(temp);
                    bilgiler.setYas(yas);
                    break;
                case "TC KİMLİK NUMARASI":
                    JOptionPane.showMessageDialog(null,bilgiler.getTcNo()+">>>"+temp);
                    bilgiler.setTcNo(temp);
                    break;
                case "KULLANICI ADI":
                    JOptionPane.showMessageDialog(null,bilgiler.getKullaniciAd()+">>>"+temp);
                    bilgiler.setKullaniciAd(temp);
                    break;
                case "KULLANICI SİFRESİ":
                    JOptionPane.showMessageDialog(null,bilgiler.getKullaniciSifre()+">>>"+temp);
                    bilgiler.setKullaniciSifre(temp);
                    break;
                case "TELEFON NUMARASI":
                    JOptionPane.showMessageDialog(null,bilgiler.gettNo()+">>>"+temp);
                    bilgiler.settNo(temp);
                    break;
                case "E - MAİL":
                    JOptionPane.showMessageDialog(null,bilgiler.getMail()+">>>"+temp);
                    bilgiler.setMail(temp);
                    break;
                case "GÜVENLİK SORUSU BELİRLEME":
                    JOptionPane.showMessageDialog(null,bilgiler.getgSorusu()+">>>"+temp);
                    bilgiler.setgSorusu(temp);
                    break;
                case "GÜVENLİK SORUSU CEVABI":
                    JOptionPane.showMessageDialog(null,bilgiler.getgCevabi()+">>>"+temp);
                    bilgiler.setgCevabi(temp);
                    break;
                case "GÜVENLİK SORUSU İPUCU":
                    JOptionPane.showMessageDialog(null,bilgiler.getgIpucu()+">>>"+temp);
                    bilgiler.setgIpucu(temp);
                    break;
                case "ADRES":
                    JOptionPane.showMessageDialog(null,bilgiler.getAdres()+">>>"+temp);
                    bilgiler.setAdres(temp);
                    break;
                case "HESABI KULLANIM AMACINIZ":
                    JOptionPane.showMessageDialog(null,bilgiler.getAmac()+">>>"+temp);
                    bilgiler.setAmac(temp);
                    break;
                case "KAPAT":
                    yukleniyor(2);
                    i = 13;
                    break;
                default:
                    continue;
            }

        }

    }
}
