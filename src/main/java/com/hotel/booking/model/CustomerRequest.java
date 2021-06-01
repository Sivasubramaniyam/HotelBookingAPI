package com.hotel.booking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
public class CustomerRequest {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "User ID cannot be null")
    @NotBlank(message = "User ID cannot be blank")
    private String userid;

    @NotNull(message = "email cannot be null")
    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotNull(message = "password cannot be null")
    @NotBlank(message = "password cannot be blank")
    private String password;

    @JsonProperty("dataOfBirth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataOfBirth;

    @JsonProperty("address")
    private Address address;

    @NotNull(message = "contact cannot be null")
    @NotBlank(message = "contact cannot be blank")
    @JsonProperty("contact")
    private String contact;

}
