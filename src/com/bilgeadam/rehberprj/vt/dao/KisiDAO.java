package com.bilgeadam.rehberprj.vt.dao;

import com.bilgeadam.rehberprj.vt.dto.KisiDTO;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;
import com.bilgeadam.rehberprj.vt.sec.AES;
import com.bilgeadam.rehberprj.vt.util.CevirmeIslemleri;
import com.bilgeadam.rehberprj.vt.util.Sabitler;
import com.bilgeadam.rehberprj.vt.vt.VTBaglanti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KisiDAO {

    public static boolean giriseYetkilimi(KisiDTO kisi) throws SQLException, ClassNotFoundException {


        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "insert into kisi(no, ad, soyad, maas, dogtar, mobil_tel) values(?,?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sorgu);
        ps.setInt(1, kisi.getNo());
        ps.setString(2, kisi.getAd());
        ps.setString(3, kisi.getSoyad());
        ps.setDouble(4, kisi.getMaas());
        ps.setDate(5, CevirmeIslemleri.utilToSqlDate(kisi.getDogtar()));
        ps.setString(6, kisi.getMobil_telefon());

        int sonuc = ps.executeUpdate();
        ps.close();
        VTBaglanti.baglantiKapat(conn);


        if (sonuc > 0)
            return  true;
        else
            return false;


    }

}
