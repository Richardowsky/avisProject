package com.avis.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "history")
@Data
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sell_date", nullable = false)
    private LocalDate sellDate;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
