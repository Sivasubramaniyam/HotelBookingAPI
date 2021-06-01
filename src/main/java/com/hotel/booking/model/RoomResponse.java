package com.hotel.booking.model;

import java.util.List;

import com.hotel.booking.entity.Room;

import lombok.Data;

@Data
public class RoomResponse {

    private Long statusCode;

    private String statusMessage;
    
    private String userMessage;
   
    private Integer totalVacancy;
    
    private List<Room> roomList;
    
    private Room roomDetails;
    
    private String roomStatus;
    
}
