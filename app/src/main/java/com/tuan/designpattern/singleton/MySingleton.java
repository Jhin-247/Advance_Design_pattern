package com.tuan.designpattern.singleton;

import com.tuan.designpattern.builder.Builder;
import com.tuan.designpattern.model.Car;

public class MySingleton {
    private static MySingleton instance;
    private Car car;

    public void setCar(Car car){
        this.car = car;
    }

    public Car getCar(){
        return car;
    }


    private MySingleton(){

    }

    public static synchronized MySingleton getInstance(){
        if(instance == null){
            instance = new MySingleton();
        }
        return instance;
    }
}
