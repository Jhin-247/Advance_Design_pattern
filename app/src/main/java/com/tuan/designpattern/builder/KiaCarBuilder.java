package com.tuan.designpattern.builder;

import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

public class KiaCarBuilder implements Builder {

    private int seats;
    private CarType carType;
    private Engine engine;

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getSeats() {
        return seats;
    }

    public CarType getCarType() {
        return carType;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public Car build() {
        return new Car(seats,carType,engine);
    }
}
