package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// klasa zawierająca GUI parkingu

public class ParkingGUI implements ActionListener {

    private JButton Pbutton1;
    private JButton Pbutton2;
    private JButton Pbutton3;
    private JButton Pbutton4;
    private JButton Pbutton5;
    private JButton Pbutton6;
    private JButton Pbutton7;
    private JFrame Pframe1;
    private JPanel Ppanel1;
    private JLabel Plabel1;
    private JLabel Plabel2;
    private JLabel Plabel3;
    private JLabel Plabel4;
    private JLabel Plabel5;
    private JLabel Plabel6;
    private HintTextField PText1;
    private HintTextField PText2;
    private HintTextField PText3;
    private HintTextField PText4;

    short opcja = 0; // zmienna używana w calu poprawnego działania guzika "Zatwierdź"

    public ParkingGUI(){
        Ppanel1 = new JPanel();

        Pframe1 = new JFrame();

        // implementacja pól tekstowych z podpowiedzią (więcej w klasie HintTextField)
        PText1 = new HintTextField("Numer rejestracyjny");
        PText1.setColumns(5);
        PText1.setMaximumSize(new Dimension(300, 40));
        PText1.setVisible(false);

        PText2 = new HintTextField("Marka");
        PText2.setColumns(5);
        PText2.setMaximumSize(new Dimension(300, 40));
        PText2.setVisible(false);

        PText3 = new HintTextField("Wlasciwosc");
        PText3.setColumns(5);
        PText3.setMaximumSize(new Dimension(300, 40));
        PText3.setVisible(false);

        PText4 = new HintTextField("Wlasciwosc");
        PText4.setColumns(5);
        PText4.setMaximumSize(new Dimension(300, 40));
        PText4.setVisible(false);

        // implementacja guzików używanych w tym GUI
        Pbutton1 = new JButton("Informacje o samochodzie");
        Pbutton1.addActionListener(this);

        Pbutton2 = new JButton("Informacje o marce");
        Pbutton2.addActionListener(this);

        Pbutton3 = new JButton("Wlasciwosci");
        Pbutton3.addActionListener(this);

        Pbutton4 = new JButton("Wszystkie samochody");
        Pbutton4.addActionListener(this);

        Pbutton5 = new JButton("Zatwierdz");
        Pbutton5.addActionListener(this);
        Pbutton5.setVisible(false);

        Pbutton6 = new JButton("Anuluj");
        Pbutton6.addActionListener(this);
        Pbutton6.setVisible(false);

        Pbutton7 = new JButton("Cofnij");
        Pbutton7.addActionListener(this);

        Plabel1 = new JLabel("Wybierz czynnosc:");
        Plabel1.setForeground(Color.WHITE);

        Plabel2 = new JLabel("Podaj wlasciwosc (Nazwisko, Marka, RokProdukcji, Pojemnosc, Typ)");
        Plabel2.setVisible(false);
        Plabel2.setForeground(Color.WHITE);

        Plabel3 = new JLabel("Podaj po czym posortowac:");
        Plabel3.setVisible(false);
        Plabel3.setForeground(Color.WHITE);

        Plabel4 = new JLabel("(Nazwisko, Marka, RokProdukcji, Pojemnosc, Typ)");
        Plabel4.setVisible(false);
        Plabel4.setForeground(Color.WHITE);

        Plabel5 = new JLabel(" ");
        Plabel5.setVisible(false);

        Plabel6 = new JLabel(" ");
        Plabel6.setVisible(false);

        // implementacja głównego wyglądu programu
        Ppanel1.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        Ppanel1.setLayout(new BoxLayout(Ppanel1, BoxLayout.PAGE_AXIS));
        Ppanel1.add(Plabel1);
        Ppanel1.add(Pbutton1);
        Ppanel1.add(Plabel5);
        Ppanel1.add(PText1);
        Ppanel1.add(Pbutton2);
        Ppanel1.add(Plabel6);
        Ppanel1.add(PText2);
        Ppanel1.add(Pbutton3);
        Ppanel1.add(Plabel2);
        Ppanel1.add(PText3);
        Ppanel1.add(Pbutton4);
        Ppanel1.add(Plabel3);
        Ppanel1.add(Plabel4);
        Ppanel1.add(PText4);
        Ppanel1.add(Box.createHorizontalStrut(5));
        Ppanel1.add(Pbutton5);
        Ppanel1.add(Pbutton6);
        Ppanel1.add(Box.createHorizontalStrut(2));
        Ppanel1.add(Pbutton7);
        Ppanel1.setBackground(Color.BLACK);
        Ppanel1.setFocusable(true);
        Ppanel1.requestFocus();

        // implementacja głównego wyglądu programu
        Pframe1.pack();
        Pframe1.setSize(500, 300);
        Pframe1.add(Ppanel1, BorderLayout.CENTER);
        Pframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pframe1.setTitle("Parking");
        Pframe1.setVisible(true);
    }

    // metoda oczekująca na wciśnięcie guzików
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Pbutton1) // przycisk 1 "Informacje o samochodzie",  pokazanie/ukrycie odpowiednich elementów GUI i ustawienie opcji na 1
        {
            opcja = 1;

            Pbutton1.setVisible(false);
            Pbutton2.setVisible(false);
            Pbutton3.setVisible(false);
            Pbutton4.setVisible(false);

            PText1.setVisible(true);

            Plabel5.setVisible(true);

            ZALVis();
        }
        else if(e.getSource() == Pbutton2) // przycisk 2 "Informacje o marce",  pokazanie/ukrycie odpowiednich elementów GUI i ustawienie opcji na 2
        {
            opcja = 2;

            Pbutton1.setVisible(false);
            Pbutton2.setVisible(false);
            Pbutton3.setVisible(false);
            Pbutton4.setVisible(false);

            PText2.setVisible(true);

            Plabel6.setVisible(true);

            ZALVis();
        }
        else if(e.getSource() == Pbutton3) // przycisk 3 "Właściwości",  pokazanie/ukrycie odpowiednich elementów GUI i ustawienie opcji na 3
        {
            opcja = 3;

            Pbutton1.setVisible(false);
            Pbutton2.setVisible(false);
            Pbutton3.setVisible(false);
            Pbutton4.setVisible(false);

            Plabel2.setVisible(true);

            PText3.setVisible(true);

            ZALVis();
        }
        else if(e.getSource() == Pbutton4) // przycisk 4 "Wszystkie samochody",  pokazanie/ukrycie odpowiednich elementów GUI i ustawienie opcji na 4
        {
            opcja = 4;

            Pbutton1.setVisible(false);
            Pbutton2.setVisible(false);
            Pbutton3.setVisible(false);
            Pbutton4.setVisible(false);

            ZALVis();

            Plabel3.setVisible(true);
            Plabel4.setVisible(true);

            PText4.setVisible(true);
        }
        else if(e.getSource() == Pbutton5) // przycisk 5 "Zatwierdź",  wykonanie konkretnych metod na podstawie wartości zmiennej "opcja"
        {
            if(opcja == 1) // wypisanie informacji o danym samochodzie
            {
                String input = "";

                input = PText1.getText();

                JOptionPane.showMessageDialog(null, WriteReadJSON.parking1.getCarInfo(input));
            }
            else if(opcja == 2) // wypisanie informacji o samochodach danej marki
            {
                String input = "";

                input = PText2.getText();

                JOptionPane.showMessageDialog(null, WriteReadJSON.parking1.getBrandInfo(input));
            }
            else if(opcja == 3) // wypisanie informacji o samochodach posiadających konkretną wartość danego atrybutu
            {
                String input = "";

                input = PText3.getText();

                JOptionPane.showMessageDialog(null, WriteReadJSON.parking1.getCarsByProperty(input));
            }
            else if(opcja == 4) // wypisanie wszystkich informacji o wszystkich samochodach w kolejności posortowanej na podstawie atrybutu podanego przez użytkownika
            {
                String input = "";

                input = PText4.getText();

                WriteReadJSON.parking1.ListSort(input);

                JOptionPane.showMessageDialog(null, WriteReadJSON.parking1.getAllCarsInfo());
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wybierz poprawna opcje!");
            }
        }
        else if(e.getSource() == Pbutton6) // przycisk 6 "Anuluj",  cofnięcie programu do wersji przed wciśnięciem pozostałych guzików
        {
            Pbutton1.setVisible(true);
            Pbutton2.setVisible(true);
            Pbutton3.setVisible(true);
            Pbutton4.setVisible(true);

            ZALVis();

            Plabel2.setVisible(false);
            Plabel3.setVisible(false);
            Plabel4.setVisible(false);
            Plabel5.setVisible(false);
            Plabel6.setVisible(false);

            PText1.setVisible(false);
            PText1.setText(PText1.hint);
            PText2.setVisible(false);
            PText2.setText(PText2.hint);
            PText3.setVisible(false);
            PText3.setText(PText3.hint);
            PText4.setVisible(false);
            PText4.setText(PText4.hint);
        }
        else if(e.getSource() == Pbutton7) // przycisk 7 "Cofnij",  zamknięcie ParkingGUI i powrót do MainGUI
        {
            Pframe1.setVisible(false);
            Pframe1.dispose();

            new MainGUI();
        }
    }

    // metoda ustawiająca poprawną widoczność konkretnych guzików i tekstu (ZALVis = "Zatwierdź" "Anuluj" "Label" Visibility)
    public void ZALVis(){
        Plabel1.setVisible(!Plabel1.isVisible());

        Pbutton5.setVisible(!Pbutton5.isVisible());
        Pbutton6.setVisible(!Pbutton6.isVisible());
    }
}
