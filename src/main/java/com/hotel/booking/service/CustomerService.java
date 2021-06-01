package com.hotel.booking.service;

import org.springframework.stereotype.Service;

import com.hotel.booking.model.CustomerResponse;
import com.hotel.booking.model.FacilitiesResponse;

@Service
public interface CustomerService {

	public CustomerResponse retrieveAllCustomers();

	public FacilitiesResponse getFacilities(); 

}
