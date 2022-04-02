package com.contact.service;

import com.contact.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    //Fake list of contacts.

    List<Contact>  list=List.of(

            new Contact(1L,"amit@gmail.com","Amit",1311L),
            new Contact(2L,"anurag@gmail.com","Anurag",1311L),
            new Contact(3L,"Rohan@gmail.com","Rohan",1312L),
            new Contact(6L,"Ketan@gmail.com","Ketan",1312L),
            new Contact(7L,"shyam@gmail.com","Shyam",1312L),
            new Contact(4L,"Sameer@gmail.com","Sameer",1313L),
            new Contact(5L,"kunal@gmail.com","Kunal",1314L)

    );


    @Override
    public List<Contact> getContactOfUser(long userId) {
        return list.stream().filter(contact -> contact.getUserid().equals(userId)).collect(Collectors.toList());
    }
}
