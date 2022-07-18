package com.tuan.designpattern;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.builder.HuyndaiCarBuilder;
import com.tuan.designpattern.builder.KiaCarBuilder;
import com.tuan.designpattern.model.Car;
import com.tuan.designpattern.model.CarType;
import com.tuan.designpattern.model.Engine;

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
        if(builder instanceof HuyndaiCarBuilder){
            builder.setSeats(4);
            Engine engine = new Engine();
            switch (((HuyndaiCarBuilder) builder).getCarType()){
                case SUV:
                    engine.setHorsePower(1000);
                    break;
                case TRUCK:
                    engine.setHorsePower(2000);
                    break;
                case SPORT:
                    engine.setHorsePower(3000);
                    break;
            }
            builder.setEngine(engine);
        } else if (builder instanceof KiaCarBuilder){
            builder.setSeats(8);
            Engine engine = new Engine();
            switch (((KiaCarBuilder) builder).getCarType()){
                case SUV:
                    engine.setHorsePower(1000);
                    break;
                case TRUCK:
                    engine.setHorsePower(2000);
                    break;
                case SPORT:
                    engine.setHorsePower(3000);
                    break;
            }
            builder.setEngine(engine);
        }
        return builder.build();
    }
}
