package com.andredupont.usersApp.repositories;

import com.andredupont.usersApp.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address WHERE a.profile.user.id=?1 AND a.profile.id=?2")
    public List<Address> findByProfileAndUserId(Long userId, Long profileId);
}
