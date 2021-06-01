package com.hotel.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.hotel.booking.entity.Address;

import java.util.List;


public interface AddressRepository extends CrudRepository<Address, Integer> {

    List<Address> findByAddressid(Integer addressid);

}
