package com.uguryasa;

import javax.swing.*;

public class AltinHesabi extends Banka{
        public void altinHesabi(Bilgiler bilgi){
            String a="CUMHURİYET ALTIN   >>>>> "+cumhuriyetAltinKuru+" TL";
            String b="TAM ALTIN   >>>>> "+tamAltinKuru+" TL";
            String c="YARIM ALTIN   >>>>> "+yarimAltinKuru+" TL";
            String d="CEYREK ALTIN   >>>>> "+ceyrekAltinKuru+" TL";
            String e="GRAM ALTIN   >>>>> "+altingramKuru+" TL";
            String[] dizi = new String[]{a,b,c,d,e};
            Guncelle guncelle=new Guncelle();
            String temp;
            int miktar2;
            double tlBakiye= bilgi.getTlBakiye();
            double altinGram= bilgi.getAltınGram();
            int cAltin= bilgi.getcAltin();
            int yAltin=bilgi.getyAltin();
            int tAltin=bilgi.gettAltin();
            int cumhuriyetAltin=bilgi.getCumhuriyetAltin();
            String secenekler[] = { "TL>>>ALTİN", "ALTİN>>>TL","ÇIKIŞ"};
            String soru="TL BAKİYENİZ             : "+tlBakiye+" TL\nCUMHURİYET ALTIN : "+cumhuriyetAltin+" ADET\nTAM ALTIN                 : "+tAltin+" ADET\nYARIM ALTIN             : "+yAltin+" ADET\nCEYREK ALTIN          : "+cAltin+" ADET\nGRAM ALTIN              : "+altinGram+" GRAM";
            String baslik = "                         ALTİN HESABİ";
            int n = JOptionPane.showOptionDialog(null, soru, baslik,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    secenekler, secenekler[0]);

            if (n==0){

                String soru2 = "Hangi işlemi yapmak istiyorsunuz ?";
                String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                        JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[3]);


                if (secim==a){
                    String soru3 = " TL >>> CUMHURİYET ALTINI"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n CUMHURİYET ALTINI BAKİYE>>> "+cumhuriyetAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);

                    if ((miktar*cumhuriyetAltinKuru)>tlBakiye){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+(miktar*cumhuriyetAltinKuru)+"\n TL BAKIYENİZ >>>"+tlBakiye);

                    }
                    else {
                        cumhuriyetAltin+=miktar;
                        bilgi.setCumhuriyetAltin(cumhuriyetAltin);
                        tlBakiye=tlBakiye-(miktar*cumhuriyetAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nCUMHURİYET ALTİN ADEDİ : "+bilgi.getCumhuriyetAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);


                }
                else if (secim==b){
                    String soru3 = " TL >>> TAM ALTIN"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n TAM ALTIN BAKİYE>>> "+tAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if ((miktar*tamAltinKuru)>tlBakiye){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+(miktar*tamAltinKuru)+"\n TL BAKIYENİZ >>>"+tlBakiye);

                    }
                    else {
                        tAltin+=miktar;
                        bilgi.settAltin(tAltin);
                        tlBakiye=tlBakiye-(miktar*tamAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nTAM ALTİN ADEDİ : "+bilgi.gettAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==c){
                    String soru3 = " TL >>> YARIM ALTIN"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n YARIM ALTIN BAKİYE>>> "+yAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if ((miktar*yarimAltinKuru)>tlBakiye){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+(miktar*yarimAltinKuru)+"\n TL BAKIYENİZ >>>"+tlBakiye);

                    }
                    else {
                        yAltin+=miktar;
                        bilgi.setyAltin(yAltin);
                        tlBakiye=tlBakiye-(miktar*yarimAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nYARIM ALTİN ADEDİ : "+bilgi.getyAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==d){
                    String soru3 = " TL >>> CEYREK ALTIN"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n CEYREK ALTIN BAKİYE>>> "+cAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if ((miktar*ceyrekAltinKuru)>tlBakiye){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+(miktar*ceyrekAltinKuru)+"\n TL BAKIYENİZ >>>"+tlBakiye);

                    }
                    else {
                        cAltin+=miktar;
                        bilgi.setcAltin(cAltin);
                        tlBakiye=tlBakiye-(miktar*ceyrekAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nCEYREK ALTİN ADEDİ : "+bilgi.getcAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==e){
                    String soru3 = "TL >>> GRAM ALTIN"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n GRAM ALTIN >>> "+altingramKuru+ " TL\n--CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    Double miktar=Double.parseDouble(o);
                    if (miktar>tlBakiye){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n TL BAKIYENİZ >>>"+tlBakiye);
                        altinHesabi(bilgi);
                    }
                    else {
                        double t=miktar / altingramKuru;
                        double altingram2 = (double) (Math.round(t*100.0)/100.0);
                        altinGram = altinGram+altingram2;
                        double turkLirasi = tlBakiye - miktar;
                        tlBakiye=(double) (Math.round(turkLirasi*100.0)/100.0);
                        bilgi.setAltınGram(altinGram);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nGRAM ALTIN BAKİYENİZ : "+bilgi.getAltınGram()+" GRAM";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }


            }

            else if (n==1){
                String soru2 = "Hangi işlemi yapmak istiyorsunuz ?";
                String secim = (String) JOptionPane.showInputDialog(null, soru, baslik,
                        JOptionPane.PLAIN_MESSAGE, null, dizi,dizi[3]);


                if (secim==a){
                    String soru3 = "CUMHURİYET ALTINI  >>> TL"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n CUMHURİYET ALTINI BAKİYE>>> "+cumhuriyetAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if (miktar>cumhuriyetAltin){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n CUMHURİYET ALTINI BAKİYE >>>"+cumhuriyetAltin);

                    }
                    else {
                        cumhuriyetAltin-=miktar;
                        bilgi.setCumhuriyetAltin(cumhuriyetAltin);
                        tlBakiye=tlBakiye+(miktar*cumhuriyetAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nCUMHURİYET ALTİN ADEDİ : "+bilgi.getCumhuriyetAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);


                }
                else if (secim==b){
                    String soru3 = "TAM ALTIN  >>> TL"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n TAM ALTIN BAKİYE>>> "+tAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if (miktar>tAltin){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n TAM ALTIN BAKİYE >>>"+tAltin);

                    }
                    else {
                        tAltin-=miktar;
                        bilgi.settAltin(tAltin);
                        tlBakiye=tlBakiye+(miktar*tamAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nTAM ALTİN ADEDİ : "+bilgi.gettAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==c){
                    String soru3 = "YARIM ALTIN  >>> TL"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n YARIM ALTIN BAKİYE>>> "+yAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if (miktar>yAltin){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n YARIM ALTIN BAKİYE >>>"+yAltin);

                    }
                    else {
                        yAltin-=miktar;
                        bilgi.setyAltin(yAltin);
                        tlBakiye=tlBakiye+(miktar*yarimAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nYARIM ALTİN ADEDİ : "+bilgi.getyAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==d){
                    String soru3 = "CEYREK ALTIN  >>> TL"+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n CEYREK ALTIN BAKİYE>>> "+cAltin+ " ADET\n--CEVIRMEK ISTEDİGİNİZ ADEDİ YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    int miktar=Integer.parseInt(o);
                    if (miktar>cAltin){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n CEYREK ALTIN BAKİYE >>>"+cAltin);

                    }
                    else {
                        cAltin-=miktar;
                        bilgi.setcAltin(cAltin);
                        tlBakiye=tlBakiye+(miktar*ceyrekAltinKuru);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nCEYREK ALTİN ADEDİ : "+bilgi.getcAltin()+" ADET";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }
                else if (secim==e){
                    String soru3 = "ALTIN GRAM >>> TL "+" \n TL BAKİYENİZ >>> "+tlBakiye+" \n GRAM ALTIN >>> "+altinGram+ " TL\n--CEVIRMEK ISTEDİGİNİZ MİKTARI YAZINIZ--";
                    String o = JOptionPane.showInputDialog(null, soru3, "");
                    Double miktar=Double.parseDouble(o);
                    if (miktar>altinGram){
                        JOptionPane.showMessageDialog(null,"LUTFEN GIRDIGINIZ DEGERI KONTROL EDINIZ >>>"+miktar+"\n GRAM ALTIN BAKIYE >>>"+altinGram);
                        altinHesabi(bilgi);
                    }
                    else {
                        double t=miktar * altingramKuru;
                        double altingram2 = (double) (Math.round(t*100.0)/100.0);
                        altinGram = altinGram-miktar;
                        double turkLirasi = tlBakiye +altingram2;
                        tlBakiye=(double) (Math.round(turkLirasi*100.0)/100.0);
                        bilgi.setAltınGram(altinGram);
                        bilgi.setTlBakiye(tlBakiye);
                        temp="TL BAKİYENİZ : "+bilgi.getTlBakiye()+" TL\nALTIN GRAM BAKİYENİZ : "+bilgi.getAltınGram()+" GRAM";
                        JOptionPane.showMessageDialog(null,temp);
                        guncelle.yaz(bilgi);
                    }
                    altinHesabi(bilgi);

                }


            }

        }
}
