package com.example.MovieTicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {

    List<Theatre> findAllByCity(String city);
}