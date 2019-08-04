package com.avis.service;

import com.avis.domain.SellerDto;
import com.avis.exception.AppException;
import com.avis.model.Role;
import com.avis.model.Seller;
import com.avis.repo.SellerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class SellerService implements UserDetailsService {

    private final SellerRepo sellerRepo;

    public SellerService(SellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }


    public boolean addNewSeller(SellerDto sellerDto) {
        Seller seller = new Seller();

        String username = sellerDto.getUsername();
        String firstName = sellerDto.getFirstName();
        String lastName = sellerDto.getLastName();
        String password = sellerDto.getPassword();

        Optional<Seller> allByLogin = sellerRepo.getAllByUsername(username);
        if (allByLogin.isPresent()) {
            throw new AppException("Seller already exist!!!");
        }
        seller.setRoles(Collections.singleton(Role.USER));
        seller.setUsername(username);
        seller.setFirstName(firstName);
        seller.setLastName(lastName);
        seller.setPassword(password);
        sellerRepo.save(seller);
        return true;
    }

    private Seller getByUserName(String username) {
        Optional<Seller> byNickname = sellerRepo.getAllByUsername(username);
        return byNickname.orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByUserName(username);
    }
}
