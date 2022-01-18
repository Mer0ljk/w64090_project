package com.company;

// klasa abstrakcyjna zawierająca pola i metody słuzące do otrzymywania informacji o właścicielach

public abstract class Owner {

    float debt = 0; // zmienna na należność danego właściciela

    // ciała metod znajdują się w klasie "Parking"
    public abstract String getO_name(String regNr);

    public abstract String getO_cars(String OLastName);

    public abstract String getO_debt(String OLastName);
}
