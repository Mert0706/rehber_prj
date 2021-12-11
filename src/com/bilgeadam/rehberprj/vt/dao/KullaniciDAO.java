package com.bilgeadam.rehberprj.vt.dao;

import com.bilgeadam.rehberprj.vt.VTBaglanti;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KullaniciDAO {

    public static boolean giriseYetkilimi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtsifre = "";

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "select sifre from kullanici where kullanici_adi=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);
        ps.setString(1,kullanici.getKullaniciAdi());

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            vtsifre = rs.getString("sifre");

        }
        rs.close();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        if (kullanici.getSifre().equals(vtsifre))
            return true;
        else
            return false;
    }

}
