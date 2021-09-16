package com.andredupont.usersApp.services;

import com.andredupont.usersApp.entities.Address;
import com.andredupont.usersApp.repositories.AddressRepository;
import com.andredupont.usersApp.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Address> findAddressesByProfileAndUserId(Long userId, Long profileId) {
        return addressRepository.findByProfileAndUserId(userId, profileId);
    }
}
