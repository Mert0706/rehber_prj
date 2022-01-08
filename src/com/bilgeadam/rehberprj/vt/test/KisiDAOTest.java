package com.bilgeadam.rehberprj.vt.test;

import com.bilgeadam.rehberprj.vt.dao.KisiDAO;
import com.bilgeadam.rehberprj.vt.dto.KisiDTO;
import com.bilgeadam.rehberprj.vt.util.CevirmeIslemleri;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class KisiDAOTest {

    public void ekleTest() throws ParseException, SQLException, ClassNotFoundException {

        KisiDTO kisi = new KisiDTO();
        kisi.setNo(1);
        kisi.setAd("Mert");
        kisi.setSoyad("Başkaya");
        kisi.setMaas(4567.85);
        kisi.setDogtar(CevirmeIslemleri.strToUtilDate("07/06/1992"));
        kisi.setMobil_telefon("+905388626030");

        boolean sonuc = KisiDAO.ekle(kisi);

        if (sonuc)
            System.out.println("Başarıyla Eklendi");
        else
            System.out.println("Eklenemedi !!!");

    }

    public void guncelleTest() throws ParseException, SQLException, ClassNotFoundException {

        KisiDTO kisi = new KisiDTO();
        kisi.setNo(1);
        kisi.setAd("Mert");
        kisi.setSoyad("birnumara");
        kisi.setMaas(1000);
        kisi.setDogtar(CevirmeIslemleri.strToUtilDate("01/01/2000"));
        kisi.setMobil_telefon("+905388626030");

        boolean sonuc = KisiDAO.guncelle(kisi);

        if (sonuc)
            System.out.println("Başarıyla Güncellendir");
        else
            System.out.println("Güncellenemedi...!");

    }

    //listele test
    public void listeleTest() throws SQLException, ClassNotFoundException{
        List<KisiDTO> kisiler = KisiDAO.listele();

        for (KisiDTO kisi: kisiler){
            System.out.println(kisi);
        }
    }
    //sil test
    public void silTest() throws SQLException, ClassNotFoundException {
        boolean sonuc = KisiDAO.sil(1);

        if (sonuc)
            System.out.println("Başarıyla Silindi");
        else
            System.out.println("Başarıyla Silinemedi");
    }



    public static void main(String[] args) {
        try{
            KisiDAOTest kdt = new KisiDAOTest();
            //kdt.ekleTest();
            //kdt.listeleTest();
            //kdt.silTest();
            kdt.guncelleTest();

        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
