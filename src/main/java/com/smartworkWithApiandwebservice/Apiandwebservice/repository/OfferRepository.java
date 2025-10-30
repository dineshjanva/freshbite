package com.smartworkWithApiandwebservice.Apiandwebservice.repository;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface OfferRepository  extends JpaRepository<Offer,Long>{
    // Custom query methods (if needed) can be defined here

    @Query("SELECT o FROM Offer o WHERE :today BETWEEN o.startDate AND o.endDate")
List<Offer> findActiveOffers(@Param("today") LocalDate today);

} 
