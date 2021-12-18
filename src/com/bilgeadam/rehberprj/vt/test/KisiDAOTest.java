package com.bilgeadam.rehberprj.vt.test;

import com.bilgeadam.rehberprj.vt.dao.KisiDAO;
import com.bilgeadam.rehberprj.vt.dto.KisiDTO;
import com.bilgeadam.rehberprj.vt.util.CevirmeIslemleri;

import java.sql.SQLException;
import java.text.ParseException;

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

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {

        KisiDAOTest kdt = new KisiDAOTest();
        kdt.ekleTest();


    }


}
