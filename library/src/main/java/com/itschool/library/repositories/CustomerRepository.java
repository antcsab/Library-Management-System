package com.itschool.library.repositories;


import com.itschool.library.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

     Customer findByEmail(String email);
}
