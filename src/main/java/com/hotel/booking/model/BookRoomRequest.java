package com.hotel.booking.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class BookRoomRequest {
      
	private Integer customerId;
	
	private Integer roomId;
	
	private BigDecimal amount;

}
