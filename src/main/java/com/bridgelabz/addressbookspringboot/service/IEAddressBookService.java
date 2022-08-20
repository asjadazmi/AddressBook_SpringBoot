package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import com.bridgelabz.addressbookspringboot.entity.Contacts;

import java.util.HashMap;
import java.util.List;

public interface IEAddressBookService {
    public Contacts  addContact(AddressBookRequestDto addressBookRequestDto);

//    public List<Contacts> addListContacts(AddressBookRequestDto addressBookRequestDto);
public List<Contacts> getAll();

public Contacts getAddressBookById(int id);

 public Contacts edit(int id,AddressBookRequestDto addressBookRequestDto);
 public String delete(int id);

}
