package com.smartworkWithApiandwebservice.Apiandwebservice.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id; 

    @NotBlank(message = "Must reqired name field")
    @Size(min=3,message = "Name must be at least 3 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email")
    private String email;


    @NotBlank(message = "Subject is required")
    
    @Size(min = 10,max = 2000, message = "Subject must be at least 10 characters")
    private String subject;

    @NotBlank(message = "Description is required")
    @Size(min = 30, message = "Description must be at least 30 characters")
    private String description;
    
    private LocalDate entryDate = LocalDate.now();

    // ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Subject
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // Entry Date
    public LocalDate getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }
}
