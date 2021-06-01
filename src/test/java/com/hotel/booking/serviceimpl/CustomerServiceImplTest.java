package com.hotel.booking.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.HotelFacility;
import com.hotel.booking.model.CustomerResponse;
import com.hotel.booking.model.FacilitiesResponse;
import com.hotel.booking.repository.CustomerRepository;
import com.hotel.booking.repository.FacilityRepository;
import com.hotel.booking.util.HBConstants;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @InjectMocks
    CustomerServiceImpl custService;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private FacilityRepository facilityRepo;

    @Test
    public void testRetrieveAllCustomers() {

    	List<Customer> custList = new ArrayList();
        Mockito.when(customerRepository.findAll()).thenReturn(custList);
        CustomerResponse custResponse = custService.retrieveAllCustomers();
        Assert.assertNotNull(custResponse);
        Assert.assertEquals(HBConstants.SUCCESS, custResponse.getStatusMessage());
    }
    
    @Test
    public void testGetFacilities() {

    	List<HotelFacility> facilityList = new ArrayList();
        Mockito.when(facilityRepo.findAll()).thenReturn(facilityList);
        FacilitiesResponse facResponse = custService.getFacilities();
        Assert.assertNotNull(facResponse);
        Assert.assertEquals(HBConstants.FAILED, facResponse.getStatusMessage());
    }
}
