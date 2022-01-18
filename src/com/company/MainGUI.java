package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// klasa zawierająca główne GUI

public class MainGUI implements ActionListener {

    private JButton Mbutton1;
    private JButton Mbutton2;
    private JButton Mbutton3;
    private JFrame Mframe1;
    private JPanel Mpanel1;
    private JLabel Mlabel1;

    public MainGUI(){

        Mpanel1 = new JPanel();

        Mframe1 = new JFrame();

        // implementacja guzików używanych w tym GUI
        Mbutton1 = new JButton("Wlasciciele");
        Mbutton1.addActionListener(this);

        Mbutton2 = new JButton("Dodaj/Usun samochod");
        Mbutton2.addActionListener(this);

        Mbutton3 = new JButton("Informacje o parkingu");
        Mbutton3.addActionListener(this);

        Mlabel1 = new JLabel("Wybierz program:");
        Mlabel1.setForeground(Color.WHITE);

        // implementacja głównego wyglądu programu
        Mpanel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        Mpanel1.setLayout(new BoxLayout(Mpanel1, BoxLayout.PAGE_AXIS));
        Mpanel1.add(Mlabel1);
        Mpanel1.add(Box.createHorizontalStrut(2));
        Mpanel1.add(Mbutton1);
        Mpanel1.add(Box.createHorizontalStrut(5));
        Mpanel1.add(Mbutton2);
        Mpanel1.add(Box.createHorizontalStrut(5));
        Mpanel1.add(Mbutton3);
        Mpanel1.setBackground(Color.BLACK);
        Mpanel1.setFocusable(true);
        Mpanel1.requestFocus();

        // implementacja głównego wyglądu programu
        Mframe1.pack();
        Mframe1.setSize(300, 300);
        Mframe1.add(Mpanel1, BorderLayout.CENTER);
        Mframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mframe1.setTitle("ParkingAPP");
        Mframe1.setVisible(true);

    }

    // metoda oczekująca na wciśnięcie guzików
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Mbutton1) // przycisk 1 "Wlasciciele", zamykający główne GUI i otwierający OwnerGUI
        {
            Mframe1.setVisible(false);
            Mframe1.dispose();

            new OwnerGUI();
        }
        else if(e.getSource() == Mbutton2) // przycisk 2 "Dodaj/Usun samochod", zamykający główne GUI i otwierający AddRemoveGUI
        {
            Mframe1.setVisible(false);
            Mframe1.dispose();

            new AddRemoveGUI();
        }
        else // przycisk 3 "Informacje o parkingu", zamykający główne GUI i otwierający ParkingGUI
        {
            Mframe1.setVisible(false);
            Mframe1.dispose();

            new ParkingGUI();
        }
    }
}
