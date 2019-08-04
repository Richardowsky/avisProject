package com.avis.domain;

import com.avis.model.Car;
import com.avis.model.CarShowroom;
import com.avis.model.History;
import com.avis.model.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoryDtoOut {
    @JsonProperty(value = "saleDate")
    private LocalDate date;
    @JsonProperty(value = "showroom")
    private CarShowroom carShowroom;
    @JsonProperty(value = "seller")
    private Seller seller;
    @JsonProperty(value = "car")
    private Car car;

    public HistoryDtoOut(History history){
        this.date = history.getSellDate();
        Car car = history.getCar();
        this.car = car;
        Seller seller = car.getSeller();
        this.seller = seller;
        this.carShowroom = seller.getCarShowroom();
    }

}
