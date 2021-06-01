package com.hotel.booking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.model.BookRoomRequest;
import com.hotel.booking.model.BookRoomResponse;
import com.hotel.booking.model.CustomerResponse;
import com.hotel.booking.model.FacilitiesResponse;
import com.hotel.booking.model.RoomCheckRequest;
import com.hotel.booking.model.RoomResponse;
import com.hotel.booking.serviceimpl.CustomerServiceImpl;
import com.hotel.booking.serviceimpl.HotelServiceImpl;


@RestController
@RequestMapping("/hotel")
public class HotelController {

    Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelServiceImpl hotelService;
    
    @Autowired
    private CustomerServiceImpl custService;

    @GetMapping("/getCustomers")
    public CustomerResponse getCustomers() {
        logger.info("getCustomers - START");
        CustomerResponse response = custService.retrieveAllCustomers();
        logger.info("getCustomers - END");
        return response;
    }
    
    @GetMapping("/getVacantRooms")
    @PreAuthorize("hasrole('ADMIN')")
    public RoomResponse getVacancy() {
        logger.info("getVacancy - START");
        RoomResponse response = hotelService.getVacantRooms();
        logger.info("getVacancy - END");
        return response;
    }
    
    @GetMapping("/getRoomDetails")
    public RoomResponse getRoomDetails(Integer roomNum) {
        logger.info("getRoomDetails - START");
        RoomResponse response = hotelService.getRoomDetails(roomNum);
        logger.info("getRoomDetails - END");
        return response;
    }
    
    @PostMapping("/bookRoom")
    public BookRoomResponse bookRoom(@RequestBody BookRoomRequest bookingRequest) {
        logger.info("bookRoom - START");
        BookRoomResponse response = hotelService.bookRoomForCustomer(bookingRequest);
        logger.info("bookRoom - END");
        return response;
    }
    
    @PostMapping("/checkRoomWithCriteria")
    public RoomResponse checkAvailability(@RequestBody RoomCheckRequest checkRequest) {
        logger.info("checkAvailability - START");
        RoomResponse response = hotelService.filterRoom(checkRequest);
        logger.info("checkAvailability - END");
        return response;
    }
    
    @GetMapping("/loadFacilities")
    public FacilitiesResponse getFacilities() {
        logger.info("getFacilities - START");
        FacilitiesResponse response = custService.getFacilities();
        logger.info("getFacilities - END");
        return response;
    }
}
