package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

// klasa dziedziąca z klasy Owner służąca do zarządzania parkingiem (informacje o samochodach/ dodawanie i usuwanie samochodów)

public class Parking extends Owner {

    public List<Car> listCars = new ArrayList<>(); // lista zawierająca wszystkie informacje programu

    // metoda otrzymująca wszystkie informacje o samochodzie o danym numerze rejestracyjnym
    public String getCarInfo(String regNr){
        for( Car car: listCars)
        {
            if(Objects.equals(car.RegNr, regNr))
            {
                return car.toString();
            }
        }

        return "Nie znaleziono samochodu!";
    }

    // metoda zwracająca informacje o samochodach danej marki
    public String getBrandInfo(String cbrand){
        String BrandInfo = "";

        for( Car car: listCars)
        {
            if(Objects.equals(car.CBrand, cbrand))
            {
                BrandInfo += car.toString();
            }
        }

        if(Objects.equals(BrandInfo, ""))
        {
            return "Nie znaleziono marki!";
        }
        else
        {
            return BrandInfo;
        }
    }

    // metoda otrzymująca wszystkie informacje o wszystkich samochodach
    public String getAllCarsInfo(){
        String allCarsInfo = "";

        for( Car car: listCars)
        {
            allCarsInfo += car.toString() + "\n";
        }

        if(Objects.equals(allCarsInfo, ""))
        {
            return "Parking pusty!";
        }
        else
        {
            return allCarsInfo;
        }
    }

    // metoda otrzymująca informacje szukaną przez użytkownika dla wszystkich samochodów
    public String getCarsByProperty(String input){
        String output = "";

        switch (input){
            case "Nazwisko":
                for( Car car: listCars)
                {
                    output += car.RegNr + " " + car.OLastName + "\n";
                }
                break;
            case "Marka":
                for( Car car: listCars)
                {
                    output += car.RegNr + " " + car.CBrand + "\n";
                }
                break;
            case "RokProdukcji":
                for( Car car: listCars)
                {
                    output += car.RegNr + " " + car.ProductionDate + "\n";
                }
                break;
            case "Pojemnosc":
                for( Car car: listCars)
                {
                    output += car.RegNr + " " + car.EngineCapacity + "\n";
                }
                break;
            case "Typ":
                for( Car car: listCars)
                {
                    output += car.RegNr + " " + car.CarType + "\n";
                }
                break;
            default:
                output += "Bledny wpis!";
                break;
        }

        return output;
    }

    // metoda tworząca nowy obiekt samochód i dołączająca go do pliku
    public void addCars(Car car){
        listCars.add(car);
        WriteReadJSON.JWrite();
    }

    // metoda usuwające konkretny obiekt samochód i usuwająca go z pliku
    public void removeCars(String regNr){
        listCars.removeIf(car -> Objects.equals(car.RegNr, regNr));
        WriteReadJSON.JWrite();
    }

    // metoda sortujaca parking na podstawie atrybutu wybranego przez użytkownika
    public void ListSort(String input){

        switch (input){
            case "Nazwisko":
                listCars.sort(Comparator.comparing(o -> o.OLastName));
                break;
            case "Marka":
                listCars.sort(Comparator.comparing(o -> o.CBrand));
                break;
            case "RokProdukcji":
                listCars.sort(Comparator.comparing(o -> Integer.valueOf(o.ProductionDate)));
                break;
            case "Pojemnosc":
                listCars.sort(Comparator.comparing(o -> Integer.valueOf(o.EngineCapacity)));
                break;
            case "Typ":
                listCars.sort(Comparator.comparing(o -> o.CarType));
                break;
            default:
                listCars.sort(Comparator.comparing(o -> o.RegNr));
                break;
        }
    }

    // metoda klasy Owner wypisująca nazwisko właściciela danego samochodu
    @Override
    public String getO_name(String regNr) {
        for( Car car: listCars)
        {
            if(Objects.equals(car.RegNr, regNr))
            {
                return car.OLastName;
            }
        }
        return "";
    }

    // metoda klasy Owner wypisująca samochody danego właściciela
    @Override
    public String getO_cars(String OLastName) {

        String zwrotny = "";

        for( Car car: listCars)
        {
            if(Objects.equals(car.OLastName, OLastName))
            {
                zwrotny += "\n" + car.RegNr;
            }
        }

        if(zwrotny.equals(""))
        {
            return "";
        }
        return zwrotny;
    }

    // metoda klasy Owner wypisująca należność danego właściciela
    @Override
    public String getO_debt(String OLastName) {
        debt = 0;

        for( Car car: listCars)
        {
            if(Objects.equals(car.OLastName, OLastName))
            {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date nowDate = new Date();
                Date date1 = null;

                try{
                    date1 = sdf.parse(car.ParkDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                long diffInMillis = Math.abs(nowDate.getTime() - date1.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

                debt += diff * 24; // 1 zl za godzine, platnosc za caly dzien
            }
        }

        if(debt == 0)
        {
            return "";
        }
        else
        {
            return String.valueOf(debt);
        }
    }

}
