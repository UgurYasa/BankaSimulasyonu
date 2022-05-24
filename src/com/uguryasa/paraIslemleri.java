package com.uguryasa;

import javax.swing.*;

public class paraIslemleri {
    Bilgiler bilgi;
    String miktar;
    int deger;
    Guncelle guncelle;
    public paraIslemleri(Bilgiler bilgi, int deger, Guncelle guncelle) {
        this.bilgi = bilgi;
        this.deger = deger;
        this.guncelle = guncelle;
    }

    public paraIslemleri(Bilgiler bilgi, String miktar, int deger, Guncelle guncelle){
        this.bilgi=bilgi;
        this.miktar=miktar;
        this.deger=deger;
        this.guncelle=guncelle;
    }
    public void paraIslemleri(){
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

    public void paraYatirma(){
        miktar = JOptionPane.showInputDialog(null, "LÜTFEN YATIRACAGINIZ MIKTARI YAZINIZ ?", "");
        paraIslemleri();
        double tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
        JOptionPane.showMessageDialog(null,"LÜTFEN PARANIZI YERLEŞTİRİNİZ."+"\nBAKİYENİZ: "+tlBakiye+" TL");
    }

    public void paraCekme(){
        double tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
        miktar= JOptionPane.showInputDialog(null, "BAKİYENİZ: "+tlBakiye+"\nLÜTFEN ÇEKECEGINIZ MIKTARI YAZINIZ ?", "");
        paraIslemleri();
        tlBakiye=(double) (Math.round(bilgi.getTlBakiye()*100.0)/100.0);
        JOptionPane.showMessageDialog(null,"LÜTFEN PARANIZI ALINIZ."+"\nBAKİYENİZ: "+tlBakiye+" TL");
    }

}
