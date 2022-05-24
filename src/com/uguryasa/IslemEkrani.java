package com.uguryasa;

import javax.swing.*;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class IslemEkrani extends Görüntü{
    public void goruntuleme(){
        int uzunluk = 31;
        System.out.println();
        System.out.println();
        serit(36);
        ortala(15, 0);
        System.out.print("--YAPMAK İSTEDİĞİNİZ GİRİŞİ SEÇİNİZ--  ");
        System.out.println();
        serit(36);

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 1-) PARA YATIRMA             |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 2-) PARA ÇEKME               |  ");
        System.out.println();


        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 3-)   HAVALE                 |  ");
        System.out.println();


        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 4-) KREDİ BAŞVURUSU          |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 5-) BORÇ ÖDEMESİ             |  ");
        System.out.println();


        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 6-) BORÇLARI TAKSİTLENDİRME  |  ");
        System.out.println();


        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 7-) DÖVİZ HESABIM            |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 8-) ALTIN HESABIM            |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 9-) ŞİFRE DEĞİŞTİRME         |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 10-) BİLGİLERİMİ GUNCELLE    |  ");
        System.out.println();

        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 11-) BİLGİLERİM              |  ");
        System.out.println();


        serit(uzunluk);
        ortala(15, 1);
        System.out.print(" 12-) BİLGİLERİMİ SİL         |  ");
        System.out.println();
        serit(uzunluk);

        System.out.println();
        System.out.println();

    }
    public void paraIslemleri(Bilgiler bilgi,String miktar,int deger,Guncelle guncelle){
        if (deger==1){//Para arttırma
            double a=bilgi.getTlBakiye();
            double b=Double.valueOf(miktar);
            a=a+b;
            bilgi.setTlBakiye(a);
            guncelle.yaz(bilgi);

        }

        else if (deger==2){//Para azaltma
            double a=bilgi.getTlBakiye();
            double b=Double.valueOf(miktar);
            if (b>a){
                JOptionPane.showMessageDialog(null,"LUTFEN BAKIYENİZİ KONTROL EDİNİZ. TL BAKİYENİZ >>>"+bilgi.getTlBakiye()+" TL");
            }
            else {
                a=a-b;
                bilgi.setTlBakiye(a);
                guncelle.yaz(bilgi);
            }

        }



    }

    public void yonlendirme(String secim,Bilgiler bilgi){
        GirisEkrani2 girisEkrani=new GirisEkrani2();
        Guncelle guncelle=new Guncelle();
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> bankaBilgileri = dosyaIslemleri.getBankaBilgiler();
        Banka banka=new Banka();
        SecimBir secimBir=new SecimBir();
        String miktar;
        double a,b;
        double tlBakiye;
        switch (secim){
            case "PARA YATIRMA":
                paraIslemleri paraIslemleri = new paraIslemleri(bilgi,1,guncelle);
                paraIslemleri.paraYatirma();
                islemEkrani(bilgi);
                break;
            case "PARA ÇEKME":
                paraIslemleri = new paraIslemleri(bilgi,2,guncelle);
                paraIslemleri.paraCekme();
                islemEkrani(bilgi);
                break;
            case "HAVALE":

                String kAdi=JOptionPane.showInputDialog(null, "LÜTFEN HAVALE YAPMAK İSTEDİĞİNİZ HESABIN KULLANICI ADINI GİRİNİZ ?", "");
                tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
                miktar = JOptionPane.showInputDialog(null, "TL BAKİYENİZ"+tlBakiye+"\nLÜTFEN GONDERMEK ISTEDİĞİNİZ MIKTARI YAZINIZ ?", "");
                Bilgiler bilgi2=girisEkrani.bilgiDondur(bankaBilgileri,kAdi,dosyaIslemleri);
                double eskiFİyat= bilgi.getTlBakiye();
                paraIslemleri(bilgi,miktar,2,guncelle);
                if (bilgi.getTlBakiye()==eskiFİyat){
                    JOptionPane.showMessageDialog(null,"HAVALE İSLEMİ YAPILAMADI !");
                }
                else {
                    paraIslemleri(bilgi2,miktar,1,guncelle);
                    guncelle.yaz(bilgi);
                    guncelle.yaz(bilgi2);
                    tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
                    JOptionPane.showMessageDialog(null,"KALAN BAKİYENİZ: "+tlBakiye+" TL");
                }
                islemEkrani(bilgi);
                break;
            case "KREDİ BAŞVURUSU":
                miktar = JOptionPane.showInputDialog(null, "LÜTFEN ÇEKECEGINIZ KREDI MIKTARINI YAZINIZ ?", "");
                b=Double.valueOf(miktar);
                a= bilgi.getBorc();
                a = a+b;
                bilgi.setBorc(a);
                double c=bilgi.getTlBakiye();
                c=c+b;
                bilgi.setTlBakiye(c);
                guncelle.yaz(bilgi);
                islemEkrani(bilgi);
                break;
            case "BORÇ ÖDEMESİ" :
                a= bilgi.getBorc();
                if (a==0){
                    JOptionPane.showMessageDialog(null,"BANKAMIZA BORCUNUZ BULUNMAMAKTADIR");
                    islemEkrani(bilgi);
                    break;
                }
                if (a>0){
                    miktar = JOptionPane.showInputDialog(null, "Borcunuz :"+a+" TL"+"\nLÜTFEN ODEMEK ISTEDİĞİNİZ MIKTARI YAZINIZ ?", "");
                    b=Double.valueOf(miktar);
                    double ü=bilgi.getTlBakiye();
                    if ((a-b<0)||(ü-b<0)){

                        tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
                        JOptionPane.showMessageDialog(null,"KALAN BAKİYENİZ: "+tlBakiye+" TL");
                        JOptionPane.showMessageDialog(null,"LUTFEN GİRDİĞİNİZ DEĞERİ KONTROL EDİN >>> "+miktar);
                        miktar = JOptionPane.showInputDialog(null, "Borcunuz :"+a+" TL"+"\nLÜTFEN ODEMEK ISTEDİĞİNİZ MIKTARI YAZINIZ ?", "");
                        b=Double.valueOf(miktar);
                    }
                    a=a-b;
                    bilgi.setBorc(a);
                    ü=ü-b;
                    bilgi.setTlBakiye(ü);
                    guncelle.yaz(bilgi);
                    JOptionPane.showMessageDialog(null,"KALAN BORCUNUZ >>>"+bilgi.getBorc()+" TL");
                    islemEkrani(bilgi);
                    break;
                }
                miktar = JOptionPane.showInputDialog(null, "Borcunuz :"+a+" TL"+"\nLÜTFEN ODEMEK ISTEDİĞİNİZ MIKTARI YAZINIZ ?", "");
                b=Double.valueOf(miktar);
                islemEkrani(bilgi);
                break;
            case "BORÇLARI TAKSİTLENDİRME":
                a= bilgi.getBorc();
                if (a==0){
                    JOptionPane.showMessageDialog(null,"BANKAMIZA BORCUNUZ BULUNMAMAKTADIR");
                    islemEkrani(bilgi);
                    break;
                }
                String[] dizi = new String[]{"6", "12","18", "24", "30", "36", "42", "48","54","60","66","72"};

                String soru = "Borcunuz >>> "+bilgi.getBorc()+" TL"+"\nBORCUNUZU KAÇ AYA TAKSITLENDIRMEK ISTERSINIZ ?";
                String baslik = "İşlemi Seciniz";
                secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                        JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[9]);
                int sayi=Integer.parseInt(secim);
                a=a/sayi;
                a=(double) (Math.round(a*100.0)/100.0);
                JOptionPane.showMessageDialog(null,"BORCUNUZ "+sayi+" AYLIK KESİME BÖLÜNÜRSE AYLIK ODEMENİZ GEREKEN TUTAR >>>"+a+" TL");
                islemEkrani(bilgi);
                break;
            case "DÖVİZ HESABIM":
                DovizHesabi2 dovizHesabi=new DovizHesabi2();
                dovizHesabi.dovizIslem(bilgi);
                islemEkrani(bilgi);
                break;

            case "ALTIN HESABIM":
                AltinHesabi altinHesabi=new AltinHesabi();
                altinHesabi.altinHesabi(bilgi);
                islemEkrani(bilgi);
                break;
            case "ŞİFRE DEĞİŞTİRME":
                SifremiUnuttum sifremiUnuttum =new SifremiUnuttum();
                sifremiUnuttum.sifremiUnuttum();
                islemEkrani(bilgi);
                break;
            case "BİLGİLERİMİ GUNCELLE":
                guncelle.guncelle(bilgi);
                guncelle.yaz(bilgi);
                islemEkrani(bilgi);
                break;
            case "BİLGİLERİM":
                String kelime="AD : "+bilgi.getAd()+"\nSOYAD : "+bilgi.getSoyad()+"\nYAS : "+bilgi.getYas()+"\nTC NO : "+bilgi.getTcNo()+"\nKULLANICI ADI : "+bilgi.getKullaniciAd()+"\nKULLANICI SİFRESİ : "+bilgi.getKullaniciSifre()+"\nTELEFON NUMARASI : "+bilgi.gettNo()+"\nMAİL: "+bilgi.getMail()+"\nGUVENLİK SORUSU : "+bilgi.getgSorusu()+"\nGUVENLİK CEVABI : "+bilgi.getgCevabi()+"\nGUVENLIK IPUCU: "+bilgi.getgIpucu()+"\nADRES : "+bilgi.getAdres()+"\nAMAC : "+bilgi.getAmac()+"\nTL BAKİYE : "+bilgi.getTlBakiye()+" TL\nDOLAR BAKİYE : "+bilgi.getDolarBakiye()+" $\nEURO BAKİYE : "+bilgi.getEuroBakiye()+" €\nSTERLIN BAKİYE : "+bilgi.getSterlinBakiye()+" £\nALTIN GRAM : "+bilgi.getAltınGram()+" GRAM \nCEYREK ALTIN ADET : "+bilgi.getcAltin()+" ADET\nYARIM ALTIN ADET : "+bilgi.getyAltin()+" ADET\nTAM ALTIN ADET : "+bilgi.gettAltin()+" ADET\nCUMHURİYET ALTIN ADET : "+bilgi.getCumhuriyetAltin()+" ADET\nBORC: "+bilgi.getBorc()+" TL";
                JOptionPane.showMessageDialog(null,kelime);
                islemEkrani(bilgi);
                break;

            case "BİLGİLERİMİ SİL":
                String secenekler2[] = { "EVET", "HAYIR"};
                String soru1 = "--YAPMAK İSTEDİĞİNİZ İŞLEM BUTUN BİLGİLERİNİZİ SİLECEK !! EMİN MİSİNİZ ?-- ";
                String baslik1 = "Bir Soru";
                int n = JOptionPane.showOptionDialog(null, soru1, baslik1,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        secenekler2, secenekler2[0]);
                if (secenekler2[n]=="EVET") {
                    double para = bilgi.getTlBakiye()+bilgi.getDolarBakiye()* banka.dolarKuru+bilgi.getEuroBakiye()* banka.euroKuru+bilgi.getSterlinBakiye()* banka.sterlinKuru+bilgi.getAltınGram()*banka.altingramKuru+bilgi.getcAltin()*banka.ceyrekAltinKuru+bilgi.getyAltin()*banka.yarimAltinKuru+bilgi.gettAltin()*banka.tamAltinKuru+bilgi.getCumhuriyetAltin()*banka.cumhuriyetAltinKuru;
                    para = para - bilgi.getBorc();
                    if (para<0) break;
                    para=(double) (Math.round(para*100.0)/100.0);
                    int indis = girisEkrani.dondur(bankaBilgileri, bilgi.getKullaniciAd());
                    bankaBilgileri.remove(indis);
                    JOptionPane.showMessageDialog(null, "SAYIN " + bilgi.getAd() + " " + bilgi.getSoyad() + " HESABINIZ BANKAMIZDAN KALDIRILMIŞTIR.\n LÜTFEN PARANIZI ALINIZ : "+para+" TL");
                    banka.writeFile3(bankaBilgileri);

                }
                if (secenekler2[n]=="HAYIR"){
                    islemEkrani(bilgi);
                }
                    break;
            case "ÇIKIŞ":
                JOptionPane.showMessageDialog(null,"ÇIKIŞ YAPILDI.");

                break;
        }


    }
    public String islemEkrani(Bilgiler bilgi) {
        Scanner scanner = new Scanner(System.in);

        String[] dizi = new String[]{"PARA YATIRMA", "PARA ÇEKME","HAVALE", "KREDİ BAŞVURUSU", "BORÇ ÖDEMESİ", "BORÇLARI TAKSİTLENDİRME", "DÖVİZ HESABIM","ALTIN HESABIM","ŞİFRE DEĞİŞTİRME","BİLGİLERİMİ GUNCELLE","BİLGİLERİM","BİLGİLERİMİ SİL","ÇIKIŞ" };

        goruntuleme();
        String soru = "TL BAKIYENİZ                        : "+bilgi.getTlBakiye()+" TL\nDOLAR BAKİYE                     : "+bilgi.getDolarBakiye()+" $\nEURO BAKIYE                        : "+bilgi.getEuroBakiye()+" €\nSTERLIN BAKIYE                   : "+bilgi.getSterlinBakiye()+" £\nCUMHURİYET ALTIN             : "+bilgi.getCumhuriyetAltin()+" ADET\nTAM ALTIN                             : "+bilgi.gettAltin()+" ADET\nYARIM ALTIN                         : "+bilgi.getyAltin()+" ADET\nCEYREK ALTIN                      : "+bilgi.getcAltin()+" ADET\nGRAM ALTIN                          : "+bilgi.getAltınGram()+" GRAM\nBORC                                      : "+bilgi.getBorc()+" TL";;
        String soru2 = "\nHangi işlemi yapmak istiyorsunuz ?";
        soru=soru+soru2;
        String baslik = "İşlemi Seciniz";
        String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[9]);
        ortala(15, 0);
        System.out.println(secim);
        yukleniyor(0);
        yonlendirme(secim,bilgi);

        return  secim;
    }
}
