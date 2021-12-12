package com.bilgeadam.rehberprj.vt.dao;

import com.bilgeadam.rehberprj.vt.vt.VTBaglanti;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;

import java.sql.*;

public class KullaniciDAO {

    public static boolean giriseYetkilimi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtsifre = null;

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
