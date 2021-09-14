package com.andredupont.usersApp.repositories;

import com.andredupont.usersApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    // Esto no es SQL sino JPQL
    @Query("SELECT u.username FROM User u")
    public Page<String> findUsernames(Pageable pageable);
}
