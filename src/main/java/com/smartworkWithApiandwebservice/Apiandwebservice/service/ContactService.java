package com.smartworkWithApiandwebservice.Apiandwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Contact;
import com.smartworkWithApiandwebservice.Apiandwebservice.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public void savefeedback(Contact contact){
        contactRepository.save(contact);
    }
}
