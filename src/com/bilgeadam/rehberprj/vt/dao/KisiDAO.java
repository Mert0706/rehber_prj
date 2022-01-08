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
import java.util.ArrayList;
import java.util.List;

public class KisiDAO {


    //kişi ekleme
    public static boolean ekle(KisiDTO kisi) throws SQLException, ClassNotFoundException {


        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "insert into kisi(no, ad, soyad, maas, dogtar, mobil_telefon) values(?,?,?,?,?,?)";

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

    //Kişi silme
    public static boolean sil(int no) throws SQLException, ClassNotFoundException {
        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu =" delete from kisi where no=?";

        PreparedStatement ps = conn.prepareStatement(sorgu);
        ps.setInt(1, no);

        int sonuc = ps.executeUpdate();

        ps.close();
        VTBaglanti.baglantiKapat(conn);


        if (sonuc > 0)
            return  true;
        else
            return false;
    }

    //Kişi güncelleme
    public static boolean guncelle(KisiDTO kisi) throws SQLException, ClassNotFoundException {


        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "update kisi set ad=?, soyad=?, maas=?, dogtar=?, mobil_telefon=? where no = ?";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ps.setString(1, kisi.getAd());
        ps.setString(2, kisi.getSoyad());
        ps.setDouble(3, kisi.getMaas());

        if (kisi.getDogtar()== null)
            ps.setDate(4,null);
        else
            ps.setDate(4, CevirmeIslemleri.utilToSqlDate(kisi.getDogtar()));

        ps.setString(5, kisi.getMobil_telefon());
        ps.setInt(6, kisi.getNo());

        int sonuc = ps.executeUpdate();
        ps.close();
        VTBaglanti.baglantiKapat(conn);


        if (sonuc > 0)
            return  true;
        else
            return false;
    }

    //Kişileri listeler
    public static List<KisiDTO> listele() throws SQLException, ClassNotFoundException{
        List<KisiDTO> kisiListele = new ArrayList<>();

        Connection conn = VTBaglanti.baglantiGetir();

        String sorgu = "select no,ad,soyad,maas,dogtar,mobil_telefon from kisi";

        PreparedStatement ps = conn.prepareStatement(sorgu);

        ResultSet rs = ps.executeQuery();
        while (rs.next()){

            KisiDTO kisi = new KisiDTO();
            kisi.setNo(rs.getInt("no"));
            kisi.setAd(rs.getString("ad"));
            kisi.setSoyad(rs.getString("soyad"));
            kisi.setMaas(rs.getDouble("maas"));
            kisi.setDogtar(CevirmeIslemleri.sqlToUtilDate(rs.getDate("dogtar")));
            kisi.setMobil_telefon(rs.getString("mobil_telefon"));

            kisiListele.add(kisi);

        }
        rs.close();
        ps.close();
        VTBaglanti.baglantiKapat(conn);

        return  kisiListele;
    }
}
