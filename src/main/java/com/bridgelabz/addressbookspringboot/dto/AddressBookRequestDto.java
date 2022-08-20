package com.bridgelabz.addressbookspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressBookRequestDto {
    @Column(name = "first_name")
    @Pattern(regexp="^[A-Z]{1}[a-z]{2,}",message = "please enter valid name")
    private String firstName;
    @Column(name = "last_name")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "please enter the correct last name")
    private String lastName;
    private String mobileNo;
//    private String address;
//    private String city;
//    private String state;
//    private String zipNo;
}
