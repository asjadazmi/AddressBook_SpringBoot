package com.bridgelabz.addressbookspringboot.controller;

import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import com.bridgelabz.addressbookspringboot.dto.AddressBookResponseDto;
import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.exception.UserNotFound;
import com.bridgelabz.addressbookspringboot.service.AddressBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {
    @Autowired
    private AddressBookServiceImpl addressBookService;

    @PostMapping("/add")

    public ResponseEntity<AddressBookResponseDto> addAddressBook(@Valid @RequestBody AddressBookRequestDto addressBookRequestDto){
        Contacts contacts=addressBookService.addContact(addressBookRequestDto);

        AddressBookResponseDto addressBookResponseDto=new AddressBookResponseDto("Contacts added succesfully",contacts);
        return new ResponseEntity<>(addressBookResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getall")

    public ResponseEntity<List<Contacts>> getAll(){
        return ResponseEntity.ok(addressBookService.getAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Contacts> getByid(@PathVariable int id) throws UserNotFound {
        return ResponseEntity.ok(addressBookService.getAddressBookById(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Contacts> edit(@Valid@PathVariable int id,@RequestBody AddressBookRequestDto addressBookRequestDto) throws UserNotFound {
        return ResponseEntity.ok(addressBookService.edit(id,addressBookRequestDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) throws UserNotFound {
        return ResponseEntity.ok(addressBookService.delete(id));

    }

}
