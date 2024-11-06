package Prolab2_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prolab2_1 {

	public static void main(String[] args) {

		int genislik = 1000;
        int yukseklik = genislik - 200;

        JFrame frame1 = new JFrame("Başlangıç Menüsü");

        frame1.setVisible(true);
        frame1.setSize(250, 250);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        // Başlat butonu
        JButton baslat_butonu = new JButton("Başlat");

        // Harita oluşturma butonu
        JButton yeni_harita_olustur_butonu = new JButton("Yeni Harita Oluştur");

        // Butonları panele ekleme
        buttonPanel.add(baslat_butonu);
        buttonPanel.add(Box.createHorizontalStrut(10)); // Butonlar arasına boşluk ekleme
        buttonPanel.add(yeni_harita_olustur_butonu);

        // Paneli frame ekleme
        frame1.add(buttonPanel, BorderLayout.CENTER);

        final JFrame[] frame2 = {null};


        yeni_harita_olustur_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (frame2[0] != null)
                {
                    frame2[0].dispose();
                }

                frame2[0] = new JFrame("Oyun");
                frame2[0].setVisible(true);
                frame2[0].setSize(genislik, yukseklik);
                frame2[0].setLocationRelativeTo(null);
                frame2[0].setResizable(false);
                frame2[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Arayuz arayuz = new Arayuz(genislik, yukseklik);
                frame2[0].add(arayuz);
                frame2[0].pack();
                arayuz.requestFocus();
            }
        });

        baslat_butonu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

	}
}
