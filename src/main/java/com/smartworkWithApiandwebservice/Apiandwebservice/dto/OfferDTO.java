package com.smartworkWithApiandwebservice.Apiandwebservice.dto;

import java.time.LocalDate;
public class OfferDTO {
    private Long id;
    private String title;
    private String description;
    private Double discount;
    private LocalDate startDate;
    private LocalDate endDate;

    // Empty constructor (needed for JSON deserialization)
    public OfferDTO() { }

    // All-args constructor (optional, useful for mapping)
    public OfferDTO(Long id, String title, String description, Double discount, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getDiscount() { return discount; }
    public void setDiscount(Double discount) { this.discount = discount; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
