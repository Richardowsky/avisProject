package com.avis.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "year", nullable = false)
    private int year;
    @Column(name = "mileage", nullable = false)
    private int mileage;
    @Column(name = "price", nullable = false)
    private double price;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;





}