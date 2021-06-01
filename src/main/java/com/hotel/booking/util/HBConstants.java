package com.hotel.booking.util;

public class HBConstants {
	
    public static final String SUCCESS ="SUCCESS";
    public static final Long SUCCESS_CODE = 200L;
    
    public static final String FAILED ="FAILED";
    public static final Long FAILED_CODE = 500L;
    
    public static final String CUST_SUCESS = "Customer Details retrieved succesfully"; 
    public static final String NO_CUST = "No customer found in the system"; 
    
    public static final String ROOMLIST_SUCESS = "Vacant room retrieved succesfully"; 
    public static final String NO_ROOM = "All Full! No rooms found in the system"; 

    public static final String ROOM_DETAIL_SUCESS = "Room details fetched successfully"; 
    public static final String ROOM_NOT_FOUND = "No rooms found"; 
    public static final String HOTEL_DETAIL_SUCESS = "Hotel facility details fetched successfully"; 
    public static final String DATA_NOT_FOUND = "No data found";
    public static final String ROOMID_NOT_VALID = "Room number not valid!";
    public static final String ROOM_FULL = "Occupied room"; 
    public static final String ROOM_VACANT = "Vacant room"; 
    
    public static final String ROOMID_ERR = "Invalid Room number! Please enter valid room number for booking";
    public static final String CUST_EXSIS = "Given room has been booked already! Please enter available Room number to book";
    public static final String PAYMENT_ERR = "Payment amount is not matching. Invalid transaction";
    public static final String ROOM_BOOKED = "Room booked successfully!"; 
}
