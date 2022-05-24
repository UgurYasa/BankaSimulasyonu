package com.uguryasa;

import javax.swing.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GirisEkrani2 extends Görüntü {
    public String hata(String[] dizi, int sayi) {
        return dizi[sayi] + " Tuşuna iki kez dokunulamaz.";
    }

    public int dondur(List<Bilgiler> bilgi, String kullanıcıAd) {
        for (int j = 0; j < bilgi.size(); j++) {
            if ((bilgi.get(j).getKullaniciAd().equals(kullanıcıAd))) {
                return j;
            }
        }
        return -1;
    }

    public Bilgiler bilgiDondur(List<Bilgiler> bankaBilgileri, String kullanıcıAd, DosyaIslemleri dosyaIslemleri) {
        int sira = dondur(bankaBilgileri, kullanıcıAd);
        var bilgi = dosyaIslemleri.parseEt(bankaBilgileri.get(sira).toString());
        return bilgi;
    }

    public Bilgiler girisEkrani() {
        Random random = new Random();
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> bankaBilgileri = dosyaIslemleri.getBankaBilgiler();
        String secenekler2[] = {"Sifremi Unuttum ", "KULLANICI ADINIZ", "KULLANICI SİFRENİZ", "TELEFON NUMARASI", "ÇIKIŞ"};
        String secenekler[] = {"KULLANICI SİFRENİZ", "ÇIKIŞ"};
        String soru = "--YAPMAK İSTEDİĞİNİZ GİRİŞİ SEÇİNİZ-- ";
        String baslik = "Bir Soru";
        String kullanıcıAd = "";
        String kullanıcıSifre = "";
        String telNo = "";
        String smsKod = "";
        String sms = "";
        boolean kontrol = true;//Kullanıc sifre kısmındaki hata için
        boolean kontrol2 = true;//Kullanıcı adı kısmındaki hata için
        boolean devam = true;
        int uzunluk = 22;
        int secenek;
        int i = 0;
        SifremiUnuttum sifremiUnuttum = new SifremiUnuttum();
        while (i < 3) {
            int n = JOptionPane.showOptionDialog(null, soru, baslik,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    secenekler2, secenekler2[0]);


            if (n == 0) {

                sifremiUnuttum.sifremiUnuttum();
                devam = false;
                kontrol2 = false;
                return null;
            }
            if (n == 1) {
                if (kullanıcıAd == "") {
                    kullanıcıAd = JOptionPane.showInputDialog(null, "KULLANICI ADINIZ ?", "");
                    serit(22);
                    ortala(15, 1);
                    System.out.println(" KULLANICI ADINIZ    |  ");
                    serit(uzunluk);
                    ortala(22, 0);
                    System.out.println(kullanıcıAd);
                } else {
                    JOptionPane.showMessageDialog(null, hata(secenekler2, 1));
                    continue;
                }
            }
            if (n == 2) {
                if (kullanıcıSifre == "") {
                    kullanıcıSifre = JOptionPane.showInputDialog(null, "KULLANICI SİFRENİZ ?", "");
                    serit(22);
                    ortala(15, 1);
                    System.out.println(" KULLANICI SİFRENİZ   |  ");
                    serit(uzunluk);
                    ortala(22, 0);
                    System.out.println(kullanıcıSifre);
                } else {
                    JOptionPane.showMessageDialog(null, hata(secenekler2, 2));
                    continue;
                }
                serit(uzunluk);
                String admin = "ADMINADMIN";
                String admin2 = kullanıcıAd + kullanıcıSifre;

                if (admin.equals(admin2)) {
                    Bilgiler bilgi =bilgiDondur(bankaBilgileri, kullanıcıAd, dosyaIslemleri);
                    String kelime="AD : "+bilgi.getAd()+"\nSOYAD : "+bilgi.getSoyad()+"\nYAS : "+bilgi.getYas()+"\nMÜŞTERİ SAYISI : "+bilgi.getTcNo()+"\nKULLANICI ADI : "+bilgi.getKullaniciAd()+"\nKULLANICI SİFRESİ : "+bilgi.getKullaniciSifre()+"\nTELEFON NUMARASI : "+bilgi.gettNo()+"\nMAİL: "+bilgi.getMail()+"\nGUVENLİK SORUSU : "+bilgi.getgSorusu()+"\nGUVENLİK CEVABI : "+bilgi.getgCevabi()+"\nGUVENLIK IPUCU: "+bilgi.getgIpucu()+"\nADRES : "+bilgi.getAdres()+"\nAMAC : "+bilgi.getAmac()+"\nTL BAKİYE : "+bilgi.getTlBakiye()+" TL\nDOLAR BAKİYE : "+bilgi.getDolarBakiye()+" $\nEURO BAKİYE : "+bilgi.getEuroBakiye()+" €\nSTERLIN BAKİYE : "+bilgi.getSterlinBakiye()+" £\nALTIN GRAM : "+bilgi.getAltınGram()+" GRAM \nCEYREK ALTIN ADET : "+bilgi.getcAltin()+" ADET\nYARIM ALTIN ADET : "+bilgi.getyAltin()+" ADET\nTAM ALTIN ADET : "+bilgi.gettAltin()+" ADET\nCUMHURİYET ALTIN ADET : "+bilgi.getCumhuriyetAltin()+" ADET\nBORC: "+bilgi.getBorc()+" TL";
                    JOptionPane.showMessageDialog(null,kelime);
                    Banka banka = new Banka();
                    banka.readFile();
                    yukleniyor(2);
                    yukleniyor(2);
                    devam = !devam;
                    return null;
                }
            }
            if (n == 3) {
                if (telNo == "") {
                    //random değer ata ve joptionla bastır
                    telNo = JOptionPane.showInputDialog(null, "TELEFON NUMARANIZ ?", "");
                    try {
                        long telefonNo = Long.parseLong(telNo);
                        ortala(15, 1);
                        System.out.println(" KULLANICI SİFRENİZ   |  ");
                        serit(uzunluk);
                        ortala(22, 0);
                        System.out.println(kullanıcıSifre);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "LUTFEN GİRDİĞİNİZ TELEFON NUMARASINI KONTROL EDİNİZ. >>>" + telNo);
                        telNo = "";
                        continue;
                    }

                }
                serit(uzunluk);
            }
            if (n == 4) {
                JOptionPane.showMessageDialog(null, "Çıkış yapıldı");
                devam = !devam;

                i = 13;
                return null;
            }
            i++;
        }
        ////////////////////////////////////////////////////////////////////////////////////


        if (devam) {
            int a = 3;
            for (int j = 0; j < bankaBilgileri.size(); j++) {
                if ((bankaBilgileri.get(j).getKullaniciAd().equals(kullanıcıAd))) {

                    for (; a > 0; a--) {
                        if ((bankaBilgileri.get(j).getKullaniciSifre().equals(kullanıcıSifre))) {
                            if ((bankaBilgileri.get(j).gettNo().equals(telNo))) {
                                for (int sayac = 0; sayac < 2; sayac++) {
                                    var deger = 100000 + random.nextInt(899999);
                                    sms = String.valueOf(deger);
                                    JOptionPane.showMessageDialog(null, sms);
                                    smsKod = JOptionPane.showInputDialog(null, "SMS GÜVENLİK KODU ?", "");

                                    if (sms.equals(smsKod)) {
                                        String bildirim = "HOSGELDİN " + bankaBilgileri.get(j).getAd() + " " + bankaBilgileri.get(j).getSoyad();
                                        JOptionPane.showMessageDialog(null, bildirim);
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "FALSE");
                                        continue;

                                    }
                                }
                                j = bankaBilgileri.size();
                                System.out.println("BURAYA GİRDİ");
                                kontrol2 = false;
                                kontrol = false;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "LUTFEN GİRDİĞİNİZ TELEFON NUMARASINI KONTROL EDİNİZ. >>>" + telNo + "\nTEKRAR GİRİS YAPMAYI DENEYİNİZ.");
                                telNo = "";
                                telNo = JOptionPane.showInputDialog(null, "TELEFON NUMARANIZ ?", "");
                                ++a;
                                continue;
                            }


                        } else {
                            String bildirim = "Kullanıcı şifreniz yanlış " + (a) + " Hakkınız kaldı .";
                            JOptionPane.showMessageDialog(null, bildirim);
                            int x = JOptionPane.showOptionDialog(null, soru, baslik,
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null,
                                    secenekler, secenekler[0]);
                            if (x == 0) {
                                kullanıcıSifre = JOptionPane.showInputDialog(null, "KULLANICI SİFRENİZ ?", "");
                            }
                            if (x == 1) {
                                JOptionPane.showMessageDialog(null, "Çıkış yapıldı");
                                j = bankaBilgileri.size();
                                kontrol = false;
                                kontrol2 = false;
                                break;

                            }

                        }
                    }
                    if (kontrol) {
                        String bildirim = bankaBilgileri.get(j).getKullaniciAd() + " Kullanıcı adlı hesap sifresi devre dışıdır.Hesabı aktif etmek istiyorsanız  \"SİFREMİ UNUTTUM SECENEGİNİ SECİNİZ\" bolumunden yeni sifre secebilirsiniz.";
                        JOptionPane.showMessageDialog(null, bildirim);
                        bankaBilgileri.get(j).setKullaniciSifre("\0");
                        dosyaIslemleri.writeFile(bankaBilgileri);
                        kontrol = false;
                        yeniEkranaGec(1, 2);
                        girisEkrani();


                    }
                }
            }
            if (kontrol2) {
                String bildirim = kullanıcıAd + "ADINDA BIR HESAP YOK LÜTFEN DOĞRU YAZDIĞINIZDAN EMIN OLUNUZ VE TEKRAR DENEYINIZ .";
                JOptionPane.showMessageDialog(null, bildirim);

                return null;
            }

        }
        return bilgiDondur(bankaBilgileri, kullanıcıAd, dosyaIslemleri);

    }

    }
