package com.bilgeadam.rehberprj.vt.gui;

import com.bilgeadam.rehberprj.vt.dao.KisiDAO;
import com.bilgeadam.rehberprj.vt.dto.KisiDTO;
import com.bilgeadam.rehberprj.vt.util.CevirmeIslemleri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

public class EkleForm extends JFrame {
    private JPanel JPanel1;
    private JTextField noTF;
    private JTextField adTF;
    private JTextField soyadTF;
    private JTextField maasTF;
    private JTextField dogTF;
    private JTextField telefonTF;
    private JButton ekleButton;
    private JPanel Jpanel2;
    private JLabel noLabel;
    private JLabel adLabel;


    public EkleForm() {
        add(JPanel1);
        setTitle("Kişi Ekle Ekranı");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        JPanel1.setBackground(new Color(32, 33, 36));
        Jpanel2.setBackground(new Color(32, 33, 36));

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    KisiDTO kisi = new KisiDTO();

                    kisi.setNo(Integer.parseInt(noTF.getText()));
                    kisi.setAd(adTF.getText());
                    kisi.setSoyad(soyadTF.getText());
                    kisi.setMaas(Double.parseDouble(maasTF.getText()));
                    kisi.setMobil_telefon(telefonTF.getText());
                    kisi.setDogtar(CevirmeIslemleri.strToUtilDate(dogTF.getText()));


                    boolean sonuc = KisiDAO.ekle(kisi);

                    if (sonuc) {
                        JOptionPane.showMessageDialog(null, "Kişi başarıyla eklendi");
                        temizle();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kişi ekleme başarısız!!!");
                    }

                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata:" + ex.getMessage());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata:" + ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata:" + ex.getMessage());
                }

            }
        });
    }


    public void temizle() {
        noTF.setText("");
        adTF.setText("");
        soyadTF.setText("");
        maasTF.setText("");
        dogTF.setText("");
        telefonTF.setText("");
    }


    // public static void main(String[] args) {
    // EkleForm ef = new EkleForm();
    //ef.setVisible(true);
    //}

}
