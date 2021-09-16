package com.andredupont.usersApp.controllers;

import com.andredupont.usersApp.entities.Address;
import com.andredupont.usersApp.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{usersId}/profiles/{profileId}/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> findAddressesByProfileAndUserId(@PathVariable("userId") Long userId, @PathVariable("profileId") Long profileId){
        return new ResponseEntity<List<Address>>(addressService.findAddressesByProfileAndUserId(userId, profileId), HttpStatus.OK);
    }
}
