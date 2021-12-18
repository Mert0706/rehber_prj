package com.bilgeadam.rehberprj.vt.gui;

import com.bilgeadam.rehberprj.vt.dao.KullaniciDAO;
import com.bilgeadam.rehberprj.vt.dto.KullaniciDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JPanel JPanel1;
    private JTextField adTF;
    private JPasswordField sifrePF;
    private JButton girisButon;
    private JLabel kullaniciadiLb;
    private JLabel girisyazisiLB;
    private JLabel sifreLB;
    private JPanel JPanel2;

    public LoginForm(){

    add(JPanel1);


    //Formun çarpısına basınca programdan çıksın
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //Formun büyüklük küçüklüğünü ayarlayabilirsiniz (size ayarlama)
        JPanel1.setBackground(new Color(32,33,36));
      // setUndecorated(true); // Border Kaldırıyor.
        kullaniciadiLb.setForeground(Color.white);
        girisyazisiLB.setForeground(Color.white);
        sifreLB.setForeground(Color.white);
        JPanel2.setBackground(new Color(32,33,36));
        setSize(400,500);
        setTitle("Giriş Ekranı");


    //Ekrana göre ortala
        setLocationRelativeTo(null);

    // Buton Fonksiyonu
        girisButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (adTF.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Kullanıcı adı boş geçilemez");

                    //Aşağıdaki kodları çalıştırmasın diye return yazdık
                    return;
                }
                if (String.valueOf(sifrePF.getPassword()).length() == 0){
                    JOptionPane.showMessageDialog(null, "Şifre alanı boş geçilemez");

                    return;
                }


                    try {
                    KullaniciDTO kullanici = new KullaniciDTO();
                    kullanici.setKullaniciAdi(adTF.getText());
                    kullanici.setSifre(String.valueOf(sifrePF.getPassword()));

                    boolean sonuc = KullaniciDAO.giriseYetkilimi(kullanici);

                    if (sonuc)
                        JOptionPane.showMessageDialog(null, "Girişe Yetkilidir.");
                    else
                        JOptionPane.showMessageDialog(null, "Girişe Yetikili Değildir");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata" +ex.getMessage());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Hata" +ex.getMessage());
                }
                    finally {
                        adTF.setText("");
                        sifrePF.setText("");
                    }
            }
        });
    }
}
