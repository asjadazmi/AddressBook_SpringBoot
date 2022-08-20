package com.bridgelabz.addressbookspringboot.service;

import com.bridgelabz.addressbookspringboot.entity.Contacts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressBookServiceImpl implements IEAddressBookService {

    Map<Integer,Contacts> integerContactsMap=new HashMap<>();
    ArrayList<Contacts> contactsArrayList=new ArrayList<>();
    @Override
    public Contacts addAndSave(Contacts contacts) {
        integerContactsMap.put(contacts.getPersonId(),contacts);
        System.out.println(integerContactsMap);
        return contacts;

     }

     public List<Contacts> getContacts(){
        return integerContactsMap.entrySet().stream().map(a->a.getValue()).toList();

     }

    @Override
    public Contacts getById(int id) {
        return integerContactsMap.get(id);
    }

    @Override
    public Contacts edit(int id, Contacts contacts) {
        Contacts contacts1=integerContactsMap.get(id);
        contacts1.updateContacts(contacts);
        return contacts1;

    }

    @Override
    public Contacts deleteByid(int id) {
        return integerContactsMap.remove(id);
    }


}
