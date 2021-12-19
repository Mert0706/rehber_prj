package com.bilgeadam.rehberprj.vt.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForm extends JFrame{
    private JPanel MenuPanel;
    private JButton ekleButton;
    private JPanel MenuPanelDis;
    private JLabel MenuLabelText;

    public MenuForm(){
        add(MenuPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Menü Ekranı");
        setSize(400,500);
        setLocationRelativeTo(null);
        MenuLabelText.setForeground(Color.white);

        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EkleForm ekle = new EkleForm();
                ekle.setVisible(true);
            }
        });
    }

    }
