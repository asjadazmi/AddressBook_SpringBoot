package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import com.bridgelabz.addressbookspringboot.dto.AddressBookResponseDto;
import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressBookServiceImpl addressBookService;

    @PostMapping("/add")

    public ResponseEntity<AddressBookResponseDto> addAddressBook(@RequestBody AddressBookRequestDto addressBookRequestDto){
        Contacts contacts=addressBookService.addContact(addressBookRequestDto);

        AddressBookResponseDto addressBookResponseDto=new AddressBookResponseDto("Contacts added succesfully",contacts);
        return new ResponseEntity<>(addressBookResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getall")

    public ResponseEntity<List<Contacts>> getAll(){
        return ResponseEntity.ok(addressBookService.getAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Contacts> getByid(@PathVariable int id){
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Contacts> edit(@PathVariable int id,@RequestBody AddressBookRequestDto addressBookRequestDto){
        return ResponseEntity.ok(addressBookService.edit(id,addressBookRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return ResponseEntity.ok(addressBookService.delete(id));

    }



}
