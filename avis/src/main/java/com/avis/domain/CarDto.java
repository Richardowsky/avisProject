package com.avis.domain;

import lombok.Data;

@Data
public class CarDto {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private double price;
}
