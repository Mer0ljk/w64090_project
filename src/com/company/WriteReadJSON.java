package com.company;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class WriteReadJSON {

    // klasa służąca do zapisu i odczytu informacji z pliku

    static Parking parking1 = new Parking(); // stała globalna zawierająca wszystkie informacje o parkingu

    public static void JWrite(){

        Gson w_gson = new Gson();

        String w_json = w_gson.toJson(parking1);

        File file = new File("Project_data.txt");

        try {
            FileWriter writer = new FileWriter("Project_data.txt");
            writer.write(w_json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // metoda służąca do zapisywania i nadpisywania w pliku informacji o samochodach na parkingu

    public static void JRead() {

        Gson r_gson = new Gson();

        try {
            Scanner read = new Scanner(new File("Project_data.txt"));

            String r_json = read.nextLine();

            parking1 = r_gson.fromJson(r_json, Parking.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    } // metoda służąca odczytywania z pliku informacji o samochodach na parkingu
}
