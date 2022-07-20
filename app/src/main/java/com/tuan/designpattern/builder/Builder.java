package com.tuan.designpattern.builder;

import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

public interface Builder {
    void setSeats(int mSeats);
    void setEngine(Engine mEngine);
    void setCarType(CarType mCarType);
    Car build();
}
