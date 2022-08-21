package com.bridgelabz.addressbookspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @Pattern(regexp = "^(91|0)?[7-9]{1}+[0-9]{9}$",message = "please enter the correct mobile no")
    private String mobileNo;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @Pattern(regexp = "[0-9]{6}",message = "please enter the 6 digit zip no")
    private String zipNo;
}
