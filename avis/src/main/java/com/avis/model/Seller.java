package com.avis.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "seller")
@Data
public class Seller implements UserDetails {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "user_name", nullable = false)
    private String username;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "sold_cars")
    private String soldCars;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Car> cars;
    @ManyToOne
    @JoinColumn(name = "showroom_id")
    private CarShowroom carShowroom;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    private Collection<? extends GrantedAuthority> getRoles() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }


}
