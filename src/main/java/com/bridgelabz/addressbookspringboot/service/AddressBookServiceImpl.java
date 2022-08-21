package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.dto.AddressBookRequestDto;
import com.bridgelabz.addressbookspringboot.entity.Contacts;
import com.bridgelabz.addressbookspringboot.exception.UserNotFound;
import com.bridgelabz.addressbookspringboot.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressBookServiceImpl implements IEAddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;


    @Override
    public Contacts addContact(AddressBookRequestDto addressBookRequestDto) {
        Contacts contacts=new Contacts(addressBookRequestDto);
        return addressBookRepository.save(contacts);

    }

//    public List<AddressBookRequestDto> addListOfContacts(List<AddressBookRequestDto> addressBookRequestDtos){
//        return addressBookRepository.saveAll(addressBookRequestDtos);
    @Override
    public List<Contacts> getAll()
    {
        return addressBookRepository.findAll();
    }

    @Override
    public Contacts getAddressBookById(int id) throws UserNotFound {
        Contacts contacts= addressBookRepository.findById(id).orElse(null);
        if(contacts!=null){
            return contacts;
        }else{
            throw new UserNotFound("USER NOT FOUND FOR THIS ID "+id);
        }
    }

    @Override
    public Contacts edit(int id, AddressBookRequestDto addressBookRequestDto) throws UserNotFound {
        Contacts contacts=this.getAddressBookById(id);
        contacts.updateContacts(addressBookRequestDto);
        return addressBookRepository.save(contacts);
    }

    @Override
    public String delete(int id) throws UserNotFound {
        Contacts contacts=this.getAddressBookById(id);

         addressBookRepository.deleteById(contacts.getPersonId());
         return "Contacts deleted successfully";
    }

}
