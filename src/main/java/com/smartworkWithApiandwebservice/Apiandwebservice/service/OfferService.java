package com.smartworkWithApiandwebservice.Apiandwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartworkWithApiandwebservice.Apiandwebservice.repository.OfferRepository;
import com.smartworkWithApiandwebservice.Apiandwebservice.model.Offer;

@Service
public class OfferService {
    @Autowired
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public void createOffer(Offer offer) {
        offerRepository.save(offer);
    }
}
