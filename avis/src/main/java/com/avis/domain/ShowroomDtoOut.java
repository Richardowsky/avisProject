package com.avis.domain;

import com.avis.model.CarShowroom;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShowroomDtoOut {
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "city")
    private String city;

    public ShowroomDtoOut(CarShowroom carShowroom){
        this.name = carShowroom.getName();
        this.city = carShowroom.getCity();
    }
}
