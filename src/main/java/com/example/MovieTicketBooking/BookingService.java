package com.example.MovieTicketBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    Map<Theatre, List<ShowResponse>> getShowsByMovieAndCity(String city, int movieId){
        Map<Theatre, List<ShowResponse>> theatreListMap = new HashMap<>();
        List<Show> showListByMovie = getShowsByMovie(movieId);
        Set<Theatre> theatreSet = new HashSet<>(getTheatreByCity(city));
        for(Show show: showListByMovie){
            ShowResponse showResponse = new ShowResponse(show.getShowId(), show.getTheatre(), show.getMovie(), show.getStartTime(), show.getEndTime());
            Theatre curTheatre = show.getTheatre();
            if(!theatreSet.contains(curTheatre)){
                continue;
            }
            if(!theatreListMap.containsKey(curTheatre)){
                theatreListMap.put(curTheatre, new ArrayList<>());
            }
            theatreListMap.get(curTheatre).add(showResponse);
        }
        return theatreListMap;
    }

    List<Show> getShowsByTheatre(List<Integer> theatreList){
        return showRepo.findAllByTheatre_TheatreIdIn(theatreList);
    }

    List<Show> getShowByTheatre(int theatreId){
        return showRepo.findAllByTheatre_TheatreId(theatreId);
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

    Show getShowById(int showId){
        return showRepo.findById(showId).get();
    }

    List<ShowSeatResponse> getShowSeatsByShow(int showId){
        Show show = getShowById(showId);
        if(show == null){
            return new ArrayList<>();
        }
        List<ShowSeat> showSeats = show.getShowSeatList();
        List<ShowSeatResponse> showSeatResponses = new ArrayList<>();
        for(ShowSeat showSeat: showSeats){
            showSeatResponses.add(new ShowSeatResponse(showSeat.getShowSeatId(), showSeat.getPrice(),
                    showSeat.getShow().getShowId(), showSeat.getSeat().getSeatId(), showSeat.getShowSeatStatus(), showSeat.getSeat().getNumber(), showSeat.getSeat().getSeatType()));
        }
        return showSeatResponses;
    }

    Booking createBooking(BookingRequest bookingRequest){
        int showId = bookingRequest.getShowId();
        List<Integer> selectedShowSeats = bookingRequest.getSelectedShowSeats();
        return null;
    }
}
