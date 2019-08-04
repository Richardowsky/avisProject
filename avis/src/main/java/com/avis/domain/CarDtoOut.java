package com.avis.domain;

import com.avis.model.Car;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CarDtoOut {


    @JsonProperty(value = "brand")
    private String brand;
    @JsonProperty(value = "model")
    private String model;
    @JsonProperty(value = "year")
    private int year;
    @JsonProperty(value = "mileage")
    private int mileage;
    @JsonProperty(value = "price")
    private double price;

    public CarDtoOut(Car car) {
        this.brand = car.getBrand();
        this.model = car.getModel();
        this.year = car.getYear();
        this.mileage = car.getMileage();
        this.price = car.getPrice();
    }
}
