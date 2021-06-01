package com.hotel.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    private String name;

    private String email;

    @Column(name = "dataOfBirth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataOfBirth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressid", referencedColumnName = "addressid")
    private Address address;

    private String contact;
    
    private String idNumber;
}
