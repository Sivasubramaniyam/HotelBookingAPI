package com.hotel.booking.serviceimpl;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hotel.booking.entity.Room;
import com.hotel.booking.model.BookRoomRequest;
import com.hotel.booking.model.BookRoomResponse;
import com.hotel.booking.model.RoomResponse;
import com.hotel.booking.repository.RoomRepository;
import com.hotel.booking.util.HBConstants;


@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {

    @InjectMocks
    HotelServiceImpl hotelService;

	@Mock
	private RoomRepository roomRepository;

    @Test
    public void testGetVacantRooms() {
    	List<Room> vacantRoomList = new ArrayList();
        Mockito.when(roomRepository.findVacantRooms()).thenReturn(vacantRoomList);
        RoomResponse roomResponse = hotelService.getVacantRooms();
        Assert.assertNotNull(roomResponse);
        Assert.assertEquals(HBConstants.SUCCESS, roomResponse.getStatusMessage());
    }
    
    @Test
    public void testgetRoomDetails() {
    	Room room = new Room();
    	room.setRoomId(101);
    	room.setAcFacility(false);
    	room.setOccupancyType("SINGLE");
        Mockito.when(roomRepository.findById(Mockito.any())).thenReturn(Optional.of(room));
        RoomResponse roomResponse = hotelService.getRoomDetails(101);
        Assert.assertNotNull(roomResponse);
        Assert.assertEquals(HBConstants.SUCCESS, roomResponse.getStatusMessage());
    }
    
    @Test
    public void testbookRoomForCustomer() {
    	Room room = new Room();
    	room.setRoomId(101);
    	room.setAcFacility(false);
    	room.setOccupancyType("SINGLE");
    	room.setPrice(BigDecimal.valueOf(1000.00));
        Mockito.when(roomRepository.findById(Mockito.any())).thenReturn(Optional.of(room));
        RoomResponse roomResponse = hotelService.getRoomDetails(101);
        Mockito.doNothing().when(roomRepository).updateCustomerForRoom(Mockito.any(), Mockito.any());
        BookRoomRequest req = new BookRoomRequest();
        req.setRoomId(101);
        req.setCustomerId(1);
        req.setAmount(BigDecimal.valueOf(1000.00));
        BookRoomResponse bookRoomResponse = hotelService.bookRoomForCustomer(req);
        Assert.assertNotNull(roomResponse);
        Assert.assertEquals(HBConstants.SUCCESS, roomResponse.getStatusMessage());
    }
    
}
