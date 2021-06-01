package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.booking.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
