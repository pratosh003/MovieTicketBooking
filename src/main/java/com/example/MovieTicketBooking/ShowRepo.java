package com.example.MovieTicketBooking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> {

    List<Show> findAllByTheatre_TheatreIdIn(List<Integer> theatreIdList);

    List<Show> findAllByTheatre_TheatreId(int theatreId);

    List<Show> findByMovie_MovieId(int movieId);
}