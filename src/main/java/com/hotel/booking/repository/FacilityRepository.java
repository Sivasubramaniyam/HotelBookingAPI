package com.hotel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.booking.entity.HotelFacility;


@Repository
public interface FacilityRepository extends JpaRepository<HotelFacility, Integer> {

}
