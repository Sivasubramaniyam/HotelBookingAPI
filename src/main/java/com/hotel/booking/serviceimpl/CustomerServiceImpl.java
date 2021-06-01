package com.hotel.booking.serviceimpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.HotelFacility;
import com.hotel.booking.model.CustomerResponse;
import com.hotel.booking.model.FacilitiesResponse;
import com.hotel.booking.repository.CustomerRepository;
import com.hotel.booking.repository.FacilityRepository;
import com.hotel.booking.service.CustomerService;
import com.hotel.booking.util.HBConstants;

@Service
public class CustomerServiceImpl implements CustomerService {

	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FacilityRepository facilityRepo;

	/**
	 * @return CustomerResponse
	 */
	public CustomerResponse retrieveAllCustomers() {
		logger.info(" Retrieving all customer details ");
		CustomerResponse response = new CustomerResponse();

		try {
			List<Customer> custList = new ArrayList();
			customerRepository.findAll().forEach(custList::add);
			response.setStatusCode(HBConstants.SUCCESS_CODE);
			response.setStatusMessage(HBConstants.SUCCESS);
			response.setCustomerList(custList);
			if (!custList.isEmpty()) {
				response.setUserMessage(HBConstants.CUST_SUCESS);
			} else {
				response.setUserMessage(HBConstants.NO_CUST);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}

		return response;
	}

	/**
	 * @return FacilitiesResponse
	 */
	public FacilitiesResponse getFacilities() {
		logger.info(" Retrieving all facilities details ");

		FacilitiesResponse response = new FacilitiesResponse();

		try {
			Map<String, List<String>> facilityMap = new LinkedHashMap<>();
			List<HotelFacility> facilitiesList = facilityRepo.findAll();

			if (facilitiesList.isEmpty()) {
				response.setStatusCode(HBConstants.FAILED_CODE);
				response.setStatusMessage(HBConstants.FAILED);
				response.setUserMessage(HBConstants.DATA_NOT_FOUND);
			} else {
				facilityMap = facilitiesList.stream().collect(Collectors.groupingBy(HotelFacility::getFacilityName,
						Collectors.mapping(HotelFacility::getFacilityValue, Collectors.toList())));
				response.setFacilityMap(facilityMap);
				response.setStatusCode(HBConstants.SUCCESS_CODE);
				response.setStatusMessage(HBConstants.SUCCESS);
				response.setUserMessage(HBConstants.HOTEL_DETAIL_SUCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}

}
