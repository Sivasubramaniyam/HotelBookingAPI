package com.hotel.booking.service;

import org.springframework.stereotype.Service;

import com.hotel.booking.model.BookRoomRequest;
import com.hotel.booking.model.BookRoomResponse;
import com.hotel.booking.model.RoomCheckRequest;
import com.hotel.booking.model.RoomResponse;

@Service
public interface HotelService {

	public RoomResponse getVacantRooms(); 

	public RoomResponse getRoomDetails(Integer roomNum);

	public BookRoomResponse bookRoomForCustomer(BookRoomRequest request); 

	public RoomResponse filterRoom(RoomCheckRequest request);

}
