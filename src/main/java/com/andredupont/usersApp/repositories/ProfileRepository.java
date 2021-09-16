package com.andredupont.usersApp.repositories;

import com.andredupont.usersApp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p from Profile p WHERE p.user = ?1 AND p.id = ?2")
    Optional<Profile> findByUserIdAndProfileId(Long userId, Long profileId);
}
