package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

// klasa zawierająca GUI dodawania i usuwania samochodów

public class AddRemoveGUI implements ActionListener  {

    private JButton Abutton1;
    private JButton Abutton2;
    private JButton Abutton3;
    private JButton Abutton4;
    private JButton Abutton5;
    private JFrame Aframe1;
    private JPanel Apanel1;
    private JLabel Alabel1;
    private HintTextField AText1;
    private HintTextField AText2;
    private HintTextField AText3;
    private HintTextField AText4;
    private HintTextField AText5;
    private HintTextField AText6;
    private HintTextField AText7;

    Boolean dodawanie = true; // zmienna używana w calu poprawnego działania guzika "Zatwierdź"


    public AddRemoveGUI(){
        Apanel1 = new JPanel();

        Aframe1 = new JFrame();

        // implementacja guzików używanych w tym GUI
        Abutton1 = new JButton("Dodaj");
        Abutton1.addActionListener(this);

        Abutton2 = new JButton("Usun");
        Abutton2.addActionListener(this);

        Abutton3 = new JButton("Zatwierdz");
        Abutton3.addActionListener(this);
        Abutton3.setVisible(false);

        Abutton4 = new JButton("Anuluj");
        Abutton4.addActionListener(this);
        Abutton4.setVisible(false);

        Abutton5 = new JButton("Cofnij");
        Abutton5.addActionListener(this);

        Alabel1 = new JLabel("Wybierz dodawanie lub usuwanie:");
        Alabel1.setForeground(Color.WHITE);

        // implementacja pól tekstowych z podpowiedzią (więcej w klasie HintTextField)
        AText1 = new HintTextField("Nazwisko");
        AText1.setColumns(5);
        AText1.setVisible(false);
        AText1.setMaximumSize(new Dimension(300, 300));

        AText2 = new HintTextField("Marka");
        AText2.setColumns(5);
        AText2.setVisible(false);
        AText2.setMaximumSize(new Dimension(300, 300));

        AText3 = new HintTextField("Nr Rejestracyjny");
        AText3.setColumns(5);
        AText3.setVisible(false);
        AText3.setMaximumSize(new Dimension(300, 300));

        AText4 = new HintTextField("Data produkcji");
        AText4.setColumns(5);
        AText4.setVisible(false);
        AText4.setMaximumSize(new Dimension(300, 300));

        AText5 = new HintTextField("Pojemność silnika");
        AText5.setColumns(5);
        AText5.setVisible(false);
        AText5.setMaximumSize(new Dimension(300, 300));

        AText6 = new HintTextField("Typ samochodu");
        AText6.setColumns(5);
        AText6.setVisible(false);
        AText6.setMaximumSize(new Dimension(300, 300));

        AText7 = new HintTextField("Data parkowania");
        AText7.setColumns(5);
        AText7.setVisible(false);
        AText7.setMaximumSize(new Dimension(300, 300));

        // implementacja głównego wyglądu programu
        Apanel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        Apanel1.setLayout(new BoxLayout(Apanel1, BoxLayout.PAGE_AXIS));
        Apanel1.add(Alabel1);
        Apanel1.add(Abutton1);
        Apanel1.add(Abutton2);
        Apanel1.add(Box.createHorizontalStrut(5));
        Apanel1.add(AText1);
        Apanel1.add(AText2);
        Apanel1.add(AText3);
        Apanel1.add(AText4);
        Apanel1.add(AText5);
        Apanel1.add(AText6);
        Apanel1.add(AText7);
        Apanel1.add(Box.createHorizontalStrut(5));
        Apanel1.add(Abutton3);
        Apanel1.add(Abutton4);
        Apanel1.add(Box.createHorizontalStrut(5));
        Apanel1.add(Abutton5);
        Apanel1.setBackground(Color.BLACK);
        Apanel1.setFocusable(true);
        Apanel1.requestFocus();

        // implementacja głównego wyglądu programu
        Aframe1.pack();
        Aframe1.setSize(330, 400);
        Aframe1.add(Apanel1, BorderLayout.CENTER);
        Aframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Aframe1.setTitle("Dodaj/usun samochody");
        Aframe1.setVisible(true);
    }

    // metoda oczekująca na wciśnięcie guzików
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Abutton1) // przycisk 1 "Dodaj",  wejście w okno dodawania samochodów
        {
            dodawanie = true;

            Abutton2.setVisible(false);
            Abutton3.setVisible(true);
            Abutton4.setVisible(true);

            AText1.setVisible(true);
            AText2.setVisible(true);
            AText3.setVisible(true);
            AText4.setVisible(true);
            AText5.setVisible(true);
            AText6.setVisible(true);
            AText7.setVisible(true);
            // wyświetlanie/chowanie odpowiednich elementów
        }
        else if(e.getSource() == Abutton2) // przycisk 2 "Usuń", wejście w okno usuwania samochodów
        {
            dodawanie = false;

            Abutton1.setVisible(false);
            Abutton3.setVisible(true);
            Abutton4.setVisible(true);

            AText3.setVisible(true);
            // wyświetlanie/chowanie odpowiednich elementów
        }
        else if(e.getSource() == Abutton3) // przycisk 3 "Zatwierdź", zatwierdzanie akcji po sprawdzeniu jaką wykonać
        {
            String OInput, CbInput, RInput, ProdInput, EInput, CrInput, ParkInput;

            if(dodawanie) // sprawdzenie czy wybrany został guzik dodawania czy usuwania
            {
                if(loopNotEH()) // wykonanie metody loopNotEH() (więcej na dole pliku)
                {
                    OInput = AText1.getText();
                    CbInput = AText2.getText();
                    RInput = AText3.getText();
                    ProdInput = AText4.getText();
                    EInput = AText5.getText();
                    CrInput = AText6.getText();
                    ParkInput = AText7.getText();

                    WriteReadJSON.parking1.addCars(new Car(OInput, CbInput, RInput, ProdInput, EInput, CrInput, ParkInput));
                    // dodawanie nowego samochodu i jego zapis do pliku

                    JOptionPane.showMessageDialog(null, "Pomyslnie dodano samochod!");
                }
            }
            else // wykonuje sie w przypadku wciśnięcia guzika "Usuń"
            {
                if(Objects.equals(AText3.getText(), AText3.hint)) // sprawdzenie czy pole nie jest puste / podpowiedzią
                {
                    JOptionPane.showMessageDialog(null, "Podaj wartosc");
                }
                else
                {
                    RInput = AText3.getText();

                    WriteReadJSON.parking1.removeCars(RInput);
                    // usuwanie samochodu oraz aktualizowanie pliku zawierającego wszystkie dane

                    JOptionPane.showMessageDialog(null, "Pomyslnie usunieto!");
                }
            }
        }
        else if(e.getSource() == Abutton4) // przycisk 4 "Anuluj", cofnięcie programu do wersji przed wciśnięciem guzika "Dodaj" lub "Usuń"
        {
            Abutton1.setVisible(true);
            Abutton2.setVisible(true);
            Abutton3.setVisible(false);
            Abutton4.setVisible(false);

            AText1.setVisible(false);
            AText1.setText(AText1.hint);
            AText2.setVisible(false);
            AText2.setText(AText2.hint);
            AText3.setVisible(false);
            AText3.setText(AText3.hint);
            AText4.setVisible(false);
            AText4.setText(AText4.hint);
            AText5.setVisible(false);
            AText5.setText(AText5.hint);
            AText6.setVisible(false);
            AText6.setText(AText6.hint);
            AText7.setVisible(false);
            AText7.setText(AText7.hint);
            // pokazywanie/chowanie odpowiednich przycisków

        }
        else if(e.getSource() == Abutton5) // przycisk 5 "Cofnij", zamykanie AddRemoveGUI i powrót do MainGUI
        {
            Aframe1.setVisible(false);
            Aframe1.dispose();

            new MainGUI();
        }
    }

    // metoda sprawdzająca czy w danym polu tekstowym została wpisana wartość i czy nie jest to podpowiedź pola (is not Empty/Hint)
    public Boolean isNotEH(HintTextField h){
        if(Objects.equals(h.getText(), h.hint) || Objects.equals(h.getText(), ""))
        {
            return false; // jeśli pole jest puste lub zawiera treść podpowiedzi metoda zwraca false
        }
        else
        {
            return true; // jeśli pole jest poprawnie wypełnione metoda zwraca true
        }
    }

    // metoda wykonująca metodę isNotEH dla wszystkich pól tekstowych dostępnych dla użytkownika
    public Boolean loopNotEH(){
        if(isNotEH(AText1) && isNotEH(AText2) && isNotEH(AText3) && isNotEH(AText4) && isNotEH(AText5) && isNotEH(AText6) && isNotEH(AText7))
        {
            return true;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Podaj wszystkie wartosci");
            return false;
        }
    }
}
