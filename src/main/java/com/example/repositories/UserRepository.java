package com.example.repositories;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByUsernameEqualsAndPasswordEquals(String username, String password);
}