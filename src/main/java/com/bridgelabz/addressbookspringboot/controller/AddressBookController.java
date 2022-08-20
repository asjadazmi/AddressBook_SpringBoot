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
    @GetMapping("/get")
    public List<Contacts> getContacts(){
        return addressBookService.getContacts();
    }

    @GetMapping("/getid/{id}")
    public Contacts getContacts(@PathVariable int id){
        return addressBookService.getById(id);
    }
    @PutMapping("/update/{id}")
    public Contacts updateByid(@PathVariable int id, @RequestBody Contacts contacts){
        return addressBookService.edit(id,contacts);
    }
    @DeleteMapping("/del/{id}")
    public String deleteByid(@PathVariable int id){
        addressBookService.deleteByid(id);
        return "Contacts deleted Successfully";
    }
}
