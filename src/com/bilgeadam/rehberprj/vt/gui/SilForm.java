package com.bilgeadam.rehberprj.vt.gui;

import com.bilgeadam.rehberprj.vt.dao.KisiDAO;
import com.bilgeadam.rehberprj.vt.dao.KisiDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SilForm extends JFrame{
    private JTextField silTF;
    private JButton silButton;
    private JPanel jPanel1;

    public SilForm(){

        add(jPanel1);

        setTitle("Kişi Silme Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(100, 150);
        setLocationRelativeTo(null);

        silButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int secim = JOptionPane.showConfirmDialog(null,
                            "Silmek istediğinize emin misiniz?",
                            "Silme Onayı",
                            JOptionPane.YES_NO_OPTION);

                    if (secim == JOptionPane.YES_OPTION)
                    {
                        boolean sonuc = KisiDAO.sil(Integer.parseInt(silTF.getText()));

                        if(sonuc)
                        {
                            JOptionPane.showMessageDialog(null, "Başarıyla silindi");
                            setVisible(false);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Silinemedi!!!");
                        }


                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Demek silmiyorsun :)");
                        setVisible(false);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

//    public static void main(String[] args) {
//        SilForm sf = new SilForm();
//        sf.setVisible(true);
//    }

}