package com.uguryasa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri extends  Banka {
    private Path dosyaYolu;
    private List<Bilgiler> bankaBilgiler;
    public   DosyaIslemleri(Path dosyaYolu) {
        this.dosyaYolu=dosyaYolu;
        bankaBilgiler= new ArrayList<>();
        try{
            var satirlar = Files.readAllLines(dosyaYolu);
            for(var satir:satirlar){
                Bilgiler o = parseEt(satir);
                bankaBilgiler.add(o);
            }


        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public List<Bilgiler> getBankaBilgiler() {
        return bankaBilgiler;
    }


    public  Bilgiler parseEt(String satir){
        var parcalar = satir.split("-");
        return new Bilgiler(parcalar[0],parcalar[1],parcalar[2],parcalar[3],parcalar[4],parcalar[5],parcalar[6],parcalar[7],parcalar[8],parcalar[9],parcalar[10],parcalar[11],parcalar[12],parcalar[13],parcalar[14],parcalar[15],parcalar[16],parcalar[17],parcalar[18],parcalar[19],parcalar[20],parcalar[21],parcalar[22]);
    }


}
