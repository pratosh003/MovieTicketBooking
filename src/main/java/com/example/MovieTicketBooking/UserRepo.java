package com.example.MovieTicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
    // You can add custom query methods here if needed
}