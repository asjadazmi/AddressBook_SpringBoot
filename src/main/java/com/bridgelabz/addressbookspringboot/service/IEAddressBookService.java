package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.entity.Contacts;

import java.util.HashMap;
import java.util.List;

public interface IEAddressBookService {
    public Contacts addAndSave(Contacts contacts);
    public List<Contacts> getContacts();

    public Contacts getById(int id);

    public Contacts edit(int id,Contacts contacts);

    public Contacts deleteByid(int id);


}
