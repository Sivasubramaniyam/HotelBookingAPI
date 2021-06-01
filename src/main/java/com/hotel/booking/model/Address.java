package com.hotel.booking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Address {

    @NotNull(message = "line1 cannot be null")
    @NotBlank(message = "line1 cannot be blank")
    @JsonProperty("lineNumber1")
    private String lineNumber1;

    @JsonProperty("lineNumber2")
    private String lineNumber2;

    @NotNull(message = "city cannot be null")
    @NotBlank(message = "city cannot be blank")
    @JsonProperty("city")
    private String city;

    @NotNull(message = "state cannot be null")
    @NotBlank(message = "state cannot be blank")
    @JsonProperty("state")
    private String state;

    @NotNull(message = "country cannot be null")
    @NotBlank(message = "country cannot be blank")
    @JsonProperty("country")
    private String country;

    @NotNull(message = "pincode cannot be null")
    @NotBlank(message = "pincode cannot be blank")
    @JsonProperty("pincode")
    private String pincode;
}
