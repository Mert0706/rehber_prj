package com.bilgeadam.rehberprj.vt.test;

import com.bilgeadam.rehberprj.vt.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;


import java.sql.SQLException;

public class KullaniciDAOTest {
    public static void main(String[] args) {
        try{
            KullaniciDTO kullanici = new KullaniciDTO();
            kullanici.setKullaniciAdi("Admin");
            kullanici.setSifre("admin1234");

            boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);

            if (sonuc)
                System.out.println("girişe yetikilidir");
            else
                System.out.println("Girişe yetikisizdir");
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
