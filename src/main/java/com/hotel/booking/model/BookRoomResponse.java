package com.hotel.booking.model;

import com.hotel.booking.entity.Room;

import lombok.Data;

@Data
public class BookRoomResponse {

    private Long statusCode;

    private String statusMessage;
    
    private String userMessage;
       
    private Room room;

}
