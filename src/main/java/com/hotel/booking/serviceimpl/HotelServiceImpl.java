package com.hotel.booking.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.entity.Room;
import com.hotel.booking.model.BookRoomRequest;
import com.hotel.booking.model.BookRoomResponse;
import com.hotel.booking.model.RoomCheckRequest;
import com.hotel.booking.model.RoomResponse;
import com.hotel.booking.repository.RoomRepository;
import com.hotel.booking.service.HotelService;
import com.hotel.booking.util.HBConstants;

@Service
public class HotelServiceImpl implements HotelService {

	Logger logger = LoggerFactory.getLogger(HotelServiceImpl.class);

	@Autowired
	private RoomRepository roomRepository;

	/**
	 * @return RoomResponse
	 */
	public RoomResponse getVacantRooms() {
		logger.info(" Retrieving vacant room details ");
		RoomResponse response = new RoomResponse();

		try {
			List<Room> vacantRoomList = new ArrayList();
			roomRepository.findVacantRooms().forEach(vacantRoomList::add);
			response.setStatusCode(HBConstants.SUCCESS_CODE);
			response.setStatusMessage(HBConstants.SUCCESS);
			response.setRoomList(vacantRoomList);
			if (!vacantRoomList.isEmpty()) {
				response.setUserMessage(HBConstants.ROOMLIST_SUCESS);
				response.setTotalVacancy(vacantRoomList.size());
			} else {
				response.setUserMessage(HBConstants.NO_ROOM);
				response.setTotalVacancy(0);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}

		return response;
	}

	/**
	 * @param roomNum
	 * @return RoomResponse
	 */
	public RoomResponse getRoomDetails(Integer roomNum) {
		logger.info(" Retrieving room details for room number " + roomNum);
		RoomResponse response = new RoomResponse();

		try {
			Room roomDetails = roomRepository.findById(roomNum).get();
			if (Objects.nonNull(roomDetails)) {
				response.setStatusCode(HBConstants.SUCCESS_CODE);
				response.setStatusMessage(HBConstants.SUCCESS);
				response.setUserMessage(HBConstants.ROOM_DETAIL_SUCESS);
				response.setRoomDetails(roomDetails);
				if (Objects.isNull(roomDetails.getCust())) {
					response.setRoomStatus(HBConstants.ROOM_VACANT);
				} else {
					response.setRoomStatus(HBConstants.ROOM_FULL);
				}
			} else {
				response.setStatusCode(HBConstants.FAILED_CODE);
				response.setStatusMessage(HBConstants.FAILED);
				response.setUserMessage(HBConstants.ROOMID_NOT_VALID);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}

		return response;
	}

	public BookRoomResponse bookRoomForCustomer(BookRoomRequest request) {
		logger.info(" Retrieving vacant room details " + request);
		BookRoomResponse response = new BookRoomResponse();
		Room roomDetails = null;
		try {
			RoomResponse roomResp = getRoomDetails(request.getRoomId());
			if (Objects.nonNull(roomResp.getRoomDetails())) {
				roomDetails = roomResp.getRoomDetails();
			}

			if (Objects.nonNull(roomDetails)) {
				if (roomDetails.getCust() != null) {
					response.setStatusCode(HBConstants.FAILED_CODE);
					response.setStatusMessage(HBConstants.FAILED);
					response.setUserMessage(HBConstants.CUST_EXSIS);
				} else {
					if (roomDetails.getPrice().equals(request.getAmount())) {
						roomRepository.updateCustomerForRoom(request.getRoomId(), request.getCustomerId());
						response.setStatusCode(HBConstants.SUCCESS_CODE);
						response.setStatusMessage(HBConstants.SUCCESS);
						response.setUserMessage(HBConstants.ROOM_BOOKED);
					} else {
						response.setStatusCode(HBConstants.FAILED_CODE);
						response.setStatusMessage(HBConstants.FAILED);
						response.setUserMessage(HBConstants.PAYMENT_ERR);
					}
				}
			} else {
				response.setStatusCode(HBConstants.FAILED_CODE);
				response.setStatusMessage(HBConstants.FAILED);
				response.setUserMessage(HBConstants.ROOMID_ERR);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}

	public RoomResponse filterRoom(RoomCheckRequest request) {
		logger.info(" Retrieving vacant room details " + request);

		RoomResponse response = new RoomResponse();
		List<Room> roomList = new ArrayList<>();

		try {
			if (Objects.nonNull(request.getOccupancy()) && Objects.nonNull(request.isAcFacility())) {
				roomList = roomRepository.getRoomsWithCriteria(request.getOccupancy(), request.isAcFacility());
			}
			response.setRoomList(roomList);
			if (roomList.isEmpty()) {
				response.setStatusCode(HBConstants.FAILED_CODE);
				response.setStatusMessage(HBConstants.FAILED);
				response.setUserMessage(HBConstants.ROOM_NOT_FOUND);
			} else {
				response.setTotalVacancy(roomList.size());
				response.setStatusCode(HBConstants.SUCCESS_CODE);
				response.setStatusMessage(HBConstants.SUCCESS);
				response.setUserMessage(HBConstants.ROOM_DETAIL_SUCESS);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatusCode(HBConstants.FAILED_CODE);
			response.setStatusMessage(e.getMessage());
		}
		return response;
	}
	
}
