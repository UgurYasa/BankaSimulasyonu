package com.uguryasa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Banka extends  Görüntü{
    private Bilgiler bilgiler;
    private double tlBakiye;
    private double dolarBakiye;
    private double euroBakiye;

    public int altingramKuru=900;
    public float dolarKuru=14.6f;
    public float euroKuru=15.8f;
    public float sterlinKuru=19.16f;

    public int ceyrekAltinKuru=1519;
    public int yarimAltinKuru=3038;
    public int tamAltinKuru=6054;
    public int cumhuriyetAltinKuru=6199;




    private List<Bilgiler> bankaHesabi;

    public Banka() {
    }

    public Banka(Bilgiler bilgiler) {
        bankaHesabi=new ArrayList<>();
    }

    public Bilgiler getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(Bilgiler bilgiler) {
        this.bilgiler = bilgiler;
    }

    public List<Bilgiler> bankayaVerileriEKleme(){
        bankaHesabi.add(bilgiler);
        return bankaHesabi;
    }


    public void readFile(){
        String dosyaYolu="C:\\Users\\uguryasa\\IdeaProjects\\BankaSimulasyonu\\src\\com\\uguryasa\\MusteriBilgileri.txt";
        DosyaIslemleri dosyaIslemleri=new DosyaIslemleri(Path.of(dosyaYolu));
        for (var a:dosyaIslemleri.getBankaBilgiler()){
            System.out.println(a.toString());
        }
        yukleniyor(2);

    }
    public List<Bilgiler> admin(){
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> liste = dosyaIslemleri.getBankaBilgiler();
        double tlToplam=0;double dolarToplam=0;double euroToplam=0;double sterlinToplam=0;double altıngramToplam=0;int cAltinToplam=0;int yAltinToplam=0;int tAltinToplam=0;int cumhuriyetAltinToplam=0;double alacakToplam=0;int sayac=0;
        for (int i=0;i<liste.size();i++){
            Bilgiler a=liste.get(i);
            tlToplam+=a.getTlBakiye();
            dolarToplam+=a.getDolarBakiye();
            euroToplam+=a.getEuroBakiye();
            sterlinToplam+=a.getSterlinBakiye();
            altıngramToplam+=a.getAltınGram();
            cAltinToplam+=a.getcAltin();
            yAltinToplam+=a.getyAltin();
            tAltinToplam+=a.gettAltin();
            cumhuriyetAltinToplam+=a.getCumhuriyetAltin();
            alacakToplam+=a.getBorc();
            sayac+=1;
        }
        tlToplam=(double) (Math.round(tlToplam*100.0)/100.0);
        dolarToplam=(double) (Math.round(dolarToplam*100.0)/100.0);
        euroToplam=(double) (Math.round(euroToplam*100.0)/100.0);
        sterlinToplam=(double) (Math.round(sterlinToplam*100.0)/100.0);
        altıngramToplam=(double) (Math.round(altıngramToplam*100.0)/100.0);
        alacakToplam=(double) (Math.round(alacakToplam*100.0)/100.0);
        String uye=String.valueOf(sayac);
        uye="00000"+uye;

        Bilgiler admin=new Bilgiler("ADMIN","ADMIN",1905,uye,"ADMIN","ADMIN","02124547878","banka@gmail.com","banka kurucusu","uğur","yasa","ISTANBUL","YONETİM",tlToplam,dolarToplam,euroToplam,sterlinToplam,altıngramToplam,cAltinToplam,yAltinToplam,tAltinToplam,cumhuriyetAltinToplam,alacakToplam);
        liste.add(admin);
        writeFile(liste);
        return liste;
    }
    public void adminSil(){
        GirisEkrani2 girisEkrani=new GirisEkrani2();
        DosyaIslemleri dosyaIslemleri = new DosyaIslemleri(Path.of(dosyaYolu));
        List<Bilgiler> bankaBilgileri = dosyaIslemleri.getBankaBilgiler();
        int indis = girisEkrani.dondur(bankaBilgileri, "ADMIN");
        bankaBilgileri.remove(indis);
        writeFile(bankaBilgileri);
    }

    public  void writeFile(  List<Bilgiler> liste){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\uguryasa\\IdeaProjects\\BankaSimulasyonu\\src\\com\\uguryasa\\MusteriBilgileri.txt",false));
            for (int i=0;i<liste.size();i++){
                Bilgiler a=liste.get(i);
                String bilgi =a.toString();
                String[] bilgiler=bilgi.split("-");
                if (i!=0){
                    writer.newLine();
                }


                for (String b:bilgiler){
                    b=b.trim();
                    writer.write(b+"-");
                }


            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public  void writeFile2(Bilgiler bilgiler){
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\uguryasa\\IdeaProjects\\BankaSimulasyonu\\src\\com\\uguryasa\\MusteriBilgileri.txt",true));

            String kelime=bilgiler.toString();
            String[] bilgilerr=kelime.split("-");
            writer.newLine();

            for (String a:bilgilerr){
                a=a.trim();
                writer.write(a+"-");
            }
            writer.close();



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void writeFile3(List<Bilgiler> bilgiler){
        writeFile(bilgiler);
        adminSil();
        admin();
    }
    public void  writeFile4(Bilgiler bilgi){
        adminSil();
        writeFile2(bilgi);
        admin();
    }

}
