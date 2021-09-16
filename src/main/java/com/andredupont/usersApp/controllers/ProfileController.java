package com.andredupont.usersApp.controllers;

import com.andredupont.usersApp.entities.Profile;
import com.andredupont.usersApp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users/{userId}/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping(value = "/{profileId}")
    public ResponseEntity<Profile> getById(@PathVariable("userId") Long userId, @PathVariable("profileId") Long profileId){
        return new ResponseEntity<Profile>(profileService.getByUserIdAndProfileId(userId, profileId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@PathVariable("userId") Long userId, @RequestBody Profile profile){
        return new ResponseEntity<Profile>(profileService.create(userId, profile), HttpStatus.CREATED) ;
    }
}
