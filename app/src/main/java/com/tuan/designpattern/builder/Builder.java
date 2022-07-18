package com.tuan.designpattern.builder;

import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

public interface Builder {
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setCarType(CarType carType);
    Car build();
}
