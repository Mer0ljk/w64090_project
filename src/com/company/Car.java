package com.company;

// klasa służąca do tworzenia obiektów (samochodów) dziedzicząca z klasy CarType

public class Car extends CarType{

    String OLastName, CBrand, RegNr, ProductionDate, EngineCapacity, ParkDate;

    public Car( String OLastName, String CBrand, String RegNr, String ProductionDate, String EngineCapacity, String CarType, String ParkDate) {
        this.OLastName = OLastName;
        this.CBrand = CBrand;
        this.RegNr = RegNr;
        this.ProductionDate = ProductionDate;
        this.EngineCapacity = EngineCapacity;
        this.CarType = CarType;
        this.ParkDate = ParkDate;
    }

    // metoda wypisująca typ samochodu (osobowy, sportowy itd.)
    @Override
    public String getType() {
        return CarType;
    }

    // metoda wypisujaca właściwości samochodu
    @Override
    public String toString() {
        return "Car{" +
                "  Registration Number=" + RegNr +
                ", Production Date=" + ProductionDate +
                ", Engine Capacity=" + EngineCapacity +
                ", Owner Last Name='" + OLastName + '\'' +
                ", Car Brand='" + CBrand + '\'' +
                ", Car Type='" + getType() + '\'' +
                ", Parking date='" + ParkDate + '\'' +
                '}' + "\n";
    }
}
