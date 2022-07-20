package com.tuan.designpattern.builder;

import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

public class HuyndaiCarBuilder implements Builder {
    private int mSeats;
    private CarType mCarType;
    private Engine mEngine;

    @Override
    public Car build() {
        return new Car("Huyndai", mSeats, mCarType, mEngine);
    }

    public int getSeats() {
        return mSeats;
    }

    @Override
    public void setSeats(int mSeats) {
        this.mSeats = mSeats;
    }

    public CarType getCarType() {
        return mCarType;
    }

    @Override
    public void setCarType(CarType mCarType) {
        this.mCarType = mCarType;
    }

    public Engine getEngine() {
        return mEngine;
    }

    @Override
    public void setEngine(Engine mEngine) {
        this.mEngine = mEngine;
    }
}
