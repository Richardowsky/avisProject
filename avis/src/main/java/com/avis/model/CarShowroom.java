package com.avis.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "showroom")
@Data
public class CarShowroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "address", nullable = false)
    private String address;
    @OneToMany(mappedBy = "carShowroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Seller> sellers;
}
