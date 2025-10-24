package com.smartworkWithApiandwebservice.Apiandwebservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String tag; 

    @Column(length = 2000,columnDefinition = "TEXT")
    private String description;
    private String image;
    @Transient
    private MultipartFile file;

    private double rating; 
    private int stock; 
    private double price; 
    // private double discountPrice;
    private boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    public Product orElseThrow(Object object) {
        
        throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }

    // Getters and Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getTitle() { return title; }
//     public void setTitle(String title) { this.title = title; }

//     public String getTag() { return tag; }
//     public void setTag(String tag) { this.tag = tag; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public String getImage() { return image; }
//     public void setImage(String image) { this.image = image; }

    
// public MultipartFile getFile() { return file; }
// public void setFile(MultipartFile file) { this.file = file; }

//     public double getRating() { return rating; }
//     public void setRating(double rating) { this.rating = rating; }

//     public int getStock() { return stock; }
//     public void setStock(int stock) { this.stock = stock; }

//     public double getPrice() { return price; }
//     public void setPrice(double price) { this.price = price; }

//     public double getDiscountPrice() { return discountPrice; }
//     public void setDiscountPrice(double discountPrice) { this.discountPrice = discountPrice; }

//     public boolean isActive() { return active; }
//     public void setActive(boolean active) { this.active = active; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
//     public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

//     public LocalDateTime getUpdatedAt() { return updatedAt; }
//     public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
