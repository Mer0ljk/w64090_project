package com.company;

// klasa główna opowoedzialna za działanie programu

public class Main {

    public static void main(String[] args) {

        WriteReadJSON.JRead(); // odczyt danych z pliku

        new MainGUI(); // inicjowanie głównego GUI

    }
}
