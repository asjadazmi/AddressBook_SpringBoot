package com.bridgelabz.addressbookspringboot.entity;


import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Contacts {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private int personId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String mobileNo;


//    private String address;
//    private String city;
//    private String state;
//    private String zipNo;


    public void updateContacts(AddressBookRequestDto addressBookRequestDto){
        this.firstName=addressBookRequestDto.getFirstName();
        this.lastName=addressBookRequestDto.getLastName();
        this.mobileNo=addressBookRequestDto.getMobileNo();
//        this.address=addressBookRequestDto.getAddress();
//        this.city=addressBookRequestDto.getCity();
//        this.state=addressBookRequestDto.getState();
//        this.zipNo=addressBookRequestDto.getZipNo();

    }
    public Contacts(AddressBookRequestDto addressBookRequestDto) {
        this.firstName=addressBookRequestDto.getFirstName();
        this.lastName=addressBookRequestDto.getLastName();
        this.mobileNo=addressBookRequestDto.getMobileNo();
    }


}
