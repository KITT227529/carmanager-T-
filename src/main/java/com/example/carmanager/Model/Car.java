package com.example.carmanager.Model;

import java.time.LocalDate;

public class Car {
    private String make;
    private String model;
    private Integer price;
    private Integer first_registration;
    private Integer mileage;
    private CarFuelEnum fuel;
    private CarBodytypeEnum bodytype;
    private LocalDate dop;

    public Car() {}

    public Car(String make,
               String model,
               Integer price,
               Integer first_registration,
               Integer mileage,
               CarFuelEnum fuel,
               CarBodytypeEnum bodytype,
               LocalDate dop) {
        this.make = make;
        this.model = model;
        this.price = price;
        this.first_registration = first_registration;
        this.mileage = mileage;
        this.fuel = fuel;
        this.bodytype = bodytype;
        this.dop = dop;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFirst_registration() {
        return first_registration;
    }

    public void setFirst_registration(Integer first_registration) {
        this.first_registration = first_registration;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public CarFuelEnum getFuel() {
        return fuel;
    }

    public void setFuel(CarFuelEnum fuel) {
        this.fuel = fuel;
    }

    public CarBodytypeEnum getBodytype() {
        return bodytype;
    }

    public void setBodytype(CarBodytypeEnum bodytype) {
        this.bodytype = bodytype;
    }

    public LocalDate getDop() {
        return dop;
    }

    public void setDop(LocalDate dop) {
        this.dop = dop;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", first_registration=" + first_registration +
                ", mileage=" + mileage +
                ", fuel=" + fuel +
                ", bodytype=" + bodytype +
                ", dop=" + dop +
                '}';
    }
}
