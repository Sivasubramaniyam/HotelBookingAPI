package com.hotel.booking.model;

import java.util.List;

import com.hotel.booking.entity.Customer;

import lombok.Data;

@Data
public class CustomerResponse {

    private Long statusCode;

    private String statusMessage;
    
    private String userMessage;
    
    private List<Customer> customerList;

}
