package com.avis.domain;

import com.avis.model.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SellerDtoOut {
    @JsonProperty(value = "firstName")
    private String firstName;
    @JsonProperty(value = "lastName")
    private String lastName;

    public SellerDtoOut(Seller seller){
        this.firstName = seller.getFirstName();
        this.lastName = seller.getLastName();
    }
}
