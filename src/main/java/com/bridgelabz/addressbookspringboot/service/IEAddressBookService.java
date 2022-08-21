package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.exception.UserNotFound;

import java.util.HashMap;
import java.util.List;

public interface IEAddressBookService {
    public Contacts  addContact(AddressBookRequestDto addressBookRequestDto);

//    public List<Contacts> addListContacts(AddressBookRequestDto addressBookRequestDto);
public List<Contacts> getAll();

public Contacts getAddressBookById(int id) throws UserNotFound;

 public Contacts edit(int id,AddressBookRequestDto addressBookRequestDto) throws UserNotFound;
 public String delete(int id) throws UserNotFound;

}
