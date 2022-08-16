package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookServiceImpl implements IEAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;
    @Override
    public Contacts addAndSave(Contacts contacts) {
        return addressBookRepository.save(contacts);
    }

    @Override
    public List<Contacts> getAllContacts() {
        return addressBookRepository.findAll();
    }

    @Override
    public Contacts getContactsByid(int id) {
        return addressBookRepository.findById(id).orElse(null);
    }

    @Override
    public Contacts edit(int id, Contacts contacts) {
        Contacts contacts1=addressBookRepository.getReferenceById(id);
        contacts1.updateContacts(contacts);
        return contacts;
    }



}
