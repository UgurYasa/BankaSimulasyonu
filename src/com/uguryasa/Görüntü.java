package com.uguryasa;

import javax.swing.*;

public class Görüntü {
    public  String dosyaYolu="C:\\Users\\uguryasa\\IdeaProjects\\BankaSimulasyonu\\src\\com\\uguryasa\\MusteriBilgileri.txt";
    public  static void duzCizgi(int sayi){
        for (int i=0;i<=sayi;i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public static void ortala(int sayi,int karar){
        for (int i=0;i<=sayi;i++){
            System.out.print(" ");
        }
        if (karar==1){
            System.out.print("|");
        }
    }
    public  void sharp(int adet){
        for (int j=0;j<=adet;j++){
            System.out.print("#");
        }
    }
    public void yeniEkranaGec(int sayi,int tekrar)  {
        System.out.println();
        sharp(125);
        System.out.println();
        for (int i=0;i<40;i++){
            if (sayi==0){
                System.out.println();
            }
            else {
                 if (i>38){
                     if (tekrar==0){
                         ortala(14, 0);
                         System.out.println(" ... ");
                     }
                     else {yukleniyor(1);}
                }
                else {
                    ortala(14, 0);
                    System.out.println(" ... ");
                }
            }
            }
        sharp(125);
        System.out.println();
    }

    public static void serit(int sayi){
        ortala(15,0);
        duzCizgi(sayi);
    }
    public void yukleniyor(int sayi)   {

        try {

                System.out.println();
                ortala(14,0);
                if (sayi==0){System.out.print(" İşlemi yükleniyor");}
                else if(sayi==1) { System.out.print("İşlem yükleniyor");}
                else {
                    System.out.print(".");
                }
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.println(".");

        }
        catch (Exception e) {

            // catching the exception
            System.out.println(e);
        }

    }
}


