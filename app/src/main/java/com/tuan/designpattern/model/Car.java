package com.tuan.designpattern.model;

public class Car {
    private int seats;
    private CarType carType;
    private Engine engine;

    public Car(int seats, CarType carType, Engine engine) {
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
