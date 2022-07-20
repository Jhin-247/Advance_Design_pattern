package com.tuan.designpattern;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

public class OEMDirector {
    public void createSUVCar(Builder builder){
        builder.setCarType(CarType.SUV);
        Engine engine = new Engine();
        engine.setHorsePower(1000);
        builder.setEngine(engine);
    }

    public void createSPORTCar(Builder builder){
        builder.setCarType(CarType.SPORT);
        Engine engine = new Engine();
        engine.setHorsePower(2000);
        builder.setEngine(engine);
    }

    public void createTRUCKCar(Builder builder){
        builder.setCarType(CarType.TRUCK);
        Engine engine = new Engine();
        engine.setHorsePower(3000);
        builder.setEngine(engine);
    }

    public Car process(Builder builder){
        return builder.build();
    }
}
