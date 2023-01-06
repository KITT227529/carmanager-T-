package com.example.carmanager.Model;

public class Customer {
    private String name;
    private String email;
    private String phone;
    private Integer postalCode;
    private String address;
    private Car car;

    public Customer(String name, String email, String phone, Integer postalCode, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Customer(String name, String email, String phone, Integer postalCode, String address, Car car) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
        this.car = car;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car){
        this.car = car;
    }
}
