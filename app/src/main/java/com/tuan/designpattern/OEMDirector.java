package com.tuan.designpattern;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;

public class OEMDirector {
    public void createSUVCar(Builder builder){
        builder.setCarType(CarType.SUV);
    }

    public void createSPORTCar(Builder builder){
        builder.setCarType(CarType.SPORT);
    }

    public void createTRUCKCar(Builder builder){
        builder.setCarType(CarType.TRUCK);
    }

    public Car process(Builder builder){
        return builder.build();
    }
}
