package com.avis.repo;

import com.avis.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
    public Car findById(long id);
}
