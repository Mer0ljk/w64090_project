package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// klasa zawierająca GUI właścicieli

public class OwnerGUI implements ActionListener {

    private JButton Obutton1;
    private JButton Obutton2;
    private JButton Obutton3;
    private JButton Obutton4;
    private JFrame Oframe1;
    private JPanel Opanel1;
    private JLabel Olabel1;
    private JTextField OText1;

    public OwnerGUI(){
        Opanel1 = new JPanel();

        Oframe1 = new JFrame();

        // implementacja pola tekstowego
        OText1 = new JTextField();
        OText1.setColumns(5);
        OText1.setMaximumSize(new Dimension(200, 40));

        // implementacja guzików używanych w tym GUI
        Obutton1 = new JButton("Nazwiska");
        Obutton1.addActionListener(this);

        Obutton2 = new JButton("Samochody");
        Obutton2.addActionListener(this);

        Obutton3 = new JButton("Naleznosc");
        Obutton3.addActionListener(this);

        Obutton4 = new JButton("Cofnij");
        Obutton4.addActionListener(this);

        Olabel1 = new JLabel("Podaj numer rejestracyjny lub nazwisko wlasciciela:");
        Olabel1.setForeground(Color.WHITE);

        // implementacja głównego wyglądu programu
        Opanel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        Opanel1.setLayout(new BoxLayout(Opanel1, BoxLayout.PAGE_AXIS));
        Opanel1.add(Olabel1);
        Opanel1.add(OText1);
        Opanel1.add(Box.createHorizontalStrut(5));
        Opanel1.add(Obutton1);
        Opanel1.add(Obutton2);
        Opanel1.add(Obutton3);
        Opanel1.add(Box.createHorizontalStrut(5));
        Opanel1.add(Obutton4);
        Opanel1.setBackground(Color.BLACK);

        // implementacja głównego wyglądu programu
        Oframe1.pack();
        Oframe1.setSize(400, 400);
        Oframe1.add(Opanel1, BorderLayout.CENTER);
        Oframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Oframe1.setTitle("Wlasciciele");
        Oframe1.setVisible(true);
    }

    // metoda oczekująca na wciśnięcie guzików
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Obutton1) // przycisk 1 "Nazwiska",  wyszukiwanie właściciela samochodu
        {
            String Oinput = OText1.getText(); // zmienna przyjmująca tekst wpisany przez użytkownika

            if(Objects.equals(Oinput, "") || Objects.equals(WriteReadJSON.parking1.getO_name(Oinput), ""))
            {
                JOptionPane.showMessageDialog(null, "Niewlasciwy numer!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wlascicielem jest " + WriteReadJSON.parking1.getO_name(Oinput));
            }
        }
        else if(e.getSource() == Obutton2) // przycisk 2 "Samochody",  wyszukiwanie samochodów danego właściciela
        {
            String Oinput = OText1.getText();

            if(Objects.equals(Oinput, "") || Objects.equals(WriteReadJSON.parking1.getO_cars(Oinput), ""))
            {
                JOptionPane.showMessageDialog(null, "Brak samochodow tej osoby!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Samochody tej osoby to: " + WriteReadJSON.parking1.getO_cars(Oinput));
            }
        }
        else if(e.getSource() == Obutton3) // przycisk 3 "Należność",  wyliczanie należności za wszystkei samochody posiadane przez danego właściciela
        {
            String Oinput = OText1.getText();

            if(Objects.equals(Oinput, "") || Objects.equals(WriteReadJSON.parking1.getO_debt(Oinput), ""))
            {
                JOptionPane.showMessageDialog(null, "Ta osoba nie ma dlugu\nlub podano bledna osobe!");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Dlug tej osoby to: " + WriteReadJSON.parking1.getO_debt(Oinput));
            }
        }
        else if(e.getSource() == Obutton4) // przycisk 4 "Cofnij",  zamykanie OwnerGUI i powrót do MainGUI
        {
            Oframe1.setVisible(false);
            Oframe1.dispose();

            new MainGUI();
        }
    }
}
