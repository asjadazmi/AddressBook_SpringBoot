package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressBookServiceImpl addressBookService;


    @PostMapping("/addcontacts")
    public Contacts addAddressBook(@RequestBody Contacts contacts){
        return addressBookService.addAndSave(contacts);
    }

    @GetMapping("/getallcontacts")
    public List<Contacts> getAll(){
        return addressBookService.getAllContacts();
    }

    @GetMapping("/getbyid/{id}")
    public Contacts getContByid(@PathVariable int id){
        return addressBookService.getContactsByid(id);
    }

    @PutMapping("/update/{id}")
    public Contacts editByidAndContacts(@PathVariable int id,@RequestBody Contacts contacts){
        return addressBookService.edit(id,contacts);
    }



}
