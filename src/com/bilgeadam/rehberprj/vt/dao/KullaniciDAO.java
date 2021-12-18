package com.bilgeadam.rehberprj.vt.dao;

import com.bilgeadam.rehberprj.vt.sec.AES;
import com.bilgeadam.rehberprj.vt.util.Sabitler;
import com.bilgeadam.rehberprj.vt.vt.VTBaglanti;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;

import java.sql.*;

public class KullaniciDAO {

    public static boolean giriseYetkilimi(KullaniciDTO kullanici) throws SQLException, ClassNotFoundException {

        String vtsifre = null;

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "select sifre from kullanici where kullanici_adi=? and aktif=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);
        ps.setString(1, kullanici.getKullaniciAdi());
        ps.setInt(2, kullanici.getAktif());

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            vtsifre = rs.getString("sifre");

        }
        rs.close();

        ps.close();
        VTBaglanti.baglantiKapat(conn);

        String cozulmus_sifre = null;

        if (vtsifre != null) {
            cozulmus_sifre = AES.decrypt(vtsifre, Sabitler.SECRET_KEY);
        } else {
            //Vtsifre null ise aşağıdaki eşitliği kontrol etmeye gerek yok.
            //Buradan metod sonucunu false olarak döndürüyorum.
            return false;
        }
        if (kullanici.getSifre().equals(cozulmus_sifre))
            return true;
        else
            return false;

    }

}
