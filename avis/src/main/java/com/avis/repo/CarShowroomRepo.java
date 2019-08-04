package com.avis.repo;

import com.avis.model.CarShowroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShowroomRepo extends JpaRepository<CarShowroom, Long> {

}
