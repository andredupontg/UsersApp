package com.andredupont.usersApp.controllers;

import com.andredupont.usersApp.entities.Address;
import com.andredupont.usersApp.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Address> createAddress(@PathVariable("userId") Long userId, @PathVariable("profileId") Long profileId, @RequestBody Address address){
        return new ResponseEntity<Address>(addressService.createAddress(userId, profileId, address), HttpStatus.CREATED);
    }
}
