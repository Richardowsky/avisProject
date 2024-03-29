package com.avis.repo;

import com.avis.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Long> {
    Optional<Seller> getAllByUsername(String username);


}
