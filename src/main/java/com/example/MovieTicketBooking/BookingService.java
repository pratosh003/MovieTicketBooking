package com.example.MovieTicketBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class BookingService {

    @Autowired
    ShowRepo showRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    MovieRepo movieRepo;

    Set<Movie> getMoviesByCity(String city){
        List<Theatre> theatreByCity = getTheatreByCity(city);
        List<Integer> theatreId = new ArrayList<>();
        for(Theatre theatre: theatreByCity){
            theatreId.add(theatre.getTheatreId());
        }
        List<Show> showsByTheatre = getShowsByTheatre(theatreId);
        List<Integer> movieId = new ArrayList<>();
        for(Show show: showsByTheatre){
           movieId.add(show.getMovieId());
        }
        return new HashSet<>(getMoviesById(movieId));
    }

    List<Show> getShowsByTheatre(List<Integer> theatreList){
        return showRepo.findAllByTheatre_TheatreIdIn(theatreList);
    }

    List<Theatre> getTheatreByCity(String city){
        return theatreRepo.findAllByCity(city);
    }

    List<Movie> getMoviesById(List<Integer> movieId){
        return movieRepo.findAllById(movieId);
    }

    List<Show> getShowsByMovie(int movieId){
        return showRepo.findByMovie_MovieId(movieId);
    }
   
}
