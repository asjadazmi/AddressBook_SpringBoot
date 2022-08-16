package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.entity.Contacts;

import java.util.List;

public interface IEAddressBookService {
    public Contacts addAndSave(Contacts contacts);
    public List<Contacts> getAllContacts();

    public Contacts getContactsByid(int id);

    public Contacts edit(int id,Contacts contacts);




}
