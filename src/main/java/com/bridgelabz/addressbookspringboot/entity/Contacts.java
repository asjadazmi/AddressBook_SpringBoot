package com.bridgelabz.addressbookspringboot.entity;


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
    private String address;
    private String city;
    private String state;
    private String zipNo;


    public void updateContacts(Contacts contacts){
        this.firstName=contacts.getFirstName();
        this.lastName=contacts.getLastName();
        this.mobileNo=contacts.getMobileNo();
        this.address=contacts.getAddress();
        this.city=contacts.getCity();
        this.state=contacts.getState();
        this.zipNo=contacts.getZipNo();

    }


}
