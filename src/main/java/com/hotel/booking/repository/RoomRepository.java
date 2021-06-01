package com.hotel.booking.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.booking.entity.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {


	@Query(value = "SELECT * FROM ROOM WHERE CUSTOMER_ID IS NULL", nativeQuery = true)
    List<Room> findVacantRooms();
	
//	@Query(value = "SELECT CUST_ID FROM ROOM WHERE ROOM_ID = ?1", nativeQuery = true)
//  Integer getCustomerIdForRoom(Integer roomId);
	
	@Transactional
    @Modifying
	@Query(value = "UPDATE ROOM SET CUSTOMER_ID = ?2 WHERE ROOM_ID = ?1", nativeQuery = true)
    void updateCustomerForRoom(Integer roomId, Integer custId);
	
	@Query(value = "SELECT * FROM ROOM WHERE CUSTOMER_ID IS NULL AND OCCUPANCY_TYPE = ?1 AND AC_FACILITY = ?2", nativeQuery = true)
	List<Room> getRoomsWithCriteria(String type, boolean acReq);
}
