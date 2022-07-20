package com.tuan.designpattern.model;

public class Car {
    private String brand;
    private int seats;
    private CarType carType;
    private Engine engine;

    private int airbags;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public Car(String brand, int seats, CarType carType, Engine engine) {
        this.brand = brand;
        this.seats = seats;
        this.carType = carType;
        this.engine = engine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
