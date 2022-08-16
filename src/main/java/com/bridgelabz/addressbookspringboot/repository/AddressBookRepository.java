package com.bridgelabz.addressbookspringboot.repository;

import com.bridgelabz.addressbookspringboot.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Contacts,Integer> {

}
