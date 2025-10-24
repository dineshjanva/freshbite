package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartworkWithApiandwebservice.Apiandwebservice.model.Contact;

public interface ContactRepository extends JpaRepository<Contact ,Long> {
}
