package com.hotel.booking.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class FacilitiesResponse {

    private Long statusCode;

    private String statusMessage;
    
    private String userMessage;
       
    private Map<String, List<String>> facilityMap;

}
