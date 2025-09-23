package com.example.repositories;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Long> {
}