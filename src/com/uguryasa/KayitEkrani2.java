package com.uguryasa;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class KayitEkrani2 extends Görüntü{

        public void goruntule(Bilgiler bilgiler){
            int uzunluk=26;

            serit(uzunluk);
            ortala(15,1);
            System.out.println("          ADINIZ        |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getAd());
            serit(uzunluk);
            ortala(15,1);
            System.out.println("        SOYADINIZ        |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getSoyad());

            serit(uzunluk);
            ortala(15,1);
            System.out.println("           YAŞ           |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getYas());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" TC KİMLİK NUMARANIZ     |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getTcNo());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" KULLANICI ADINIZ        |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getKullaniciAd());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" KULLANICI SİFRENİZ      |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getKullaniciSifre());



            serit(uzunluk);
            ortala(15,1);
            System.out.println(" TELEFON NUMARANIZ       |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.gettNo());



            serit(uzunluk);
            ortala(15,1);
            System.out.println("      E - MAİL           |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getMail());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" GÜVENLİK SORUSU BELİRLE |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getgSorusu());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" GÜVENLİK SORUSU CEVABI  |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getgCevabi());

            serit(uzunluk);
            ortala(15,1);
            System.out.println(" GÜVENLİK SORUSU İPUCU   |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getgIpucu());

            serit(uzunluk);
            ortala(15,1);
            System.out.println("          ADRES          |  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getAdres());

            serit(uzunluk);
            serit(uzunluk);
            ortala(15,1);
            System.out.println(" HESABI KULLANIM AMACINIZ|  ");
            serit(uzunluk);
            ortala(25,0);
            System.out.println(bilgiler.getAmac());
            serit(uzunluk);
        }

        public  void kayitEkrani2(){
            Scanner scanner=new Scanner(System.in);
            // BURADA KULLANICI BİLGİLERİ ALINIYOR
            String ad = JOptionPane.showInputDialog(null, "ADINIZ ?", "");
            String soyad = JOptionPane.showInputDialog(null, "SOYADINIZ ?", "");
            String yas1 = JOptionPane.showInputDialog(null, "YAŞINIZ ?  (LÜTFEN SAYI GİRİNİZ !)", "");
            int yas=Integer.parseInt(yas1);
            if (yas<18){
                JOptionPane.showMessageDialog(null,"BANKAMIZA ÜYE OLMAK İÇİN YAŞINIZIN 18 DEN BÜYÜK OLMASI GEREKMEKTEDIR.");
                SecimBir secimBir=new SecimBir();
                secimBir.giris();
                return;
            }
            String tcNo = JOptionPane.showInputDialog(null, "TC KİMLİK NUMARANIZ  ?", "");
            try {
                long tcNo2 = Long.parseLong(tcNo);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"TC NUMARANIZDA KARAKTER BULUNMAMALI");
                 tcNo = JOptionPane.showInputDialog(null, "TC KİMLİK NUMARANIZ  (SAYILARDAN OLUSMAKTADIR.)?", "");
            }
            String kullaniciAd = JOptionPane.showInputDialog(null, "KULLANICI ADINIZ ?", "");
            String kullaniciSifre = JOptionPane.showInputDialog(null, "KULLANICI SİFRENİZ ?", "");
            String tNo = JOptionPane.showInputDialog(null, "TELEFON NUMARANIZ  ?  (LÜTFEN SAYI GİRİNİZ !)", "");
            String mail= JOptionPane.showInputDialog(null, "E - MAİL ?", "");
            String gSorusu = JOptionPane.showInputDialog(null, "GÜVENLİK SORUSU BELİRLE ?", "");
            String gCevabi = JOptionPane.showInputDialog(null, "GÜVENLİK SORUSU CEVABI ?", "");
            String gIpucu = JOptionPane.showInputDialog(null, "GÜVENLİK SORUSU İPUCU ?", "");
            String adres = JOptionPane.showInputDialog(null, "ADRES ?", "");
            String amac = JOptionPane.showInputDialog(null, "HESABI KULLANIM AMACINIZ ?", "");// Bunun seceneklerini arastır ekle
            ad=ad.toUpperCase();
            soyad=soyad.toUpperCase();
            Bilgiler bilgiler=new Bilgiler(ad,soyad,yas,tcNo,kullaniciAd,kullaniciSifre,tNo,mail,gSorusu,gCevabi,gIpucu,adres,amac,0,0,0,0,0,0,0,0,0,0);
            goruntule(bilgiler);
            String secenekler2[] = { "EVET ", "HAYIR"};
            String soru = "BİLGİLERİNİZİN DOĞRU OLDUĞUNDAN EMİN MİSİNİZ ? ";
            String baslik = "                                   KONTROL";
            int n = JOptionPane.showOptionDialog(null, soru, baslik,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    secenekler2, secenekler2[0]);

            if (secenekler2[n].equals("HAYIR")){
                Guncelle guncelle =new Guncelle();
                guncelle.guncelle(bilgiler);
                yeniEkranaGec(1,1);
                goruntule(bilgiler);
            }
            else{
                yukleniyor(2);
            }
            String mesaj="ARAMIZA HOŞGELDİN "+bilgiler.getAd().toUpperCase()+" "+bilgiler.getSoyad().toUpperCase();
            JOptionPane.showMessageDialog(null,mesaj);
            Banka banka=new Banka(bilgiler);
            banka.writeFile4(bilgiler);






        }

    }


