package com.example.MovieTicketBooking;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    ShowRepo showRepo;
    TheatreRepo theatreRepo;
    MovieRepo movieRepo;
    ShowSeatRepo showSeatRepo;
    BookingRepo bookingRepo;
    UserRepo userRepo;

    public BookingService(ShowRepo showRepo,
                          TheatreRepo theatreRepo,
                          MovieRepo movieRepo,
                          ShowSeatRepo showSeatRepo,
                          BookingRepo bookingRepo,
                          UserRepo userRepo) {
        this.showRepo = showRepo;
        this.theatreRepo = theatreRepo;
        this.movieRepo = movieRepo;
        this.showSeatRepo = showSeatRepo;
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
    }

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

    ShowSeat getShowSeatById(int showSeatId){
        return showSeatRepo.findById(showSeatId).get();
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



    BookingResponse createBooking(BookingRequest bookingRequest){
        BookingResponse bookingResponse;
        try {
            int showId = bookingRequest.getShowId();
            List<Integer> selectedShowSeats = bookingRequest.getSelectedShowSeats();
            User user = bookingRequest.getUser();

            userRepo.save(user);

            List<ShowSeat> showSeats = new ArrayList<>();
            for (int showSeatId : selectedShowSeats) {
                showSeats.add(getShowSeatById(showSeatId));
            }

            Booking booking = new Booking(user, getShowById(showId), selectedShowSeats, BookingStatus.BOOKED);
            bookingRepo.save(booking);

            List<String> seatNums = new ArrayList<>();
            for (ShowSeat showSeat : showSeats) {
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeatRepo.save(showSeat);
                seatNums.add(String.valueOf(showSeat.getShowSeatId()));
            }

            bookingResponse = new BookingResponse(
                    booking.getBookingId(), booking.getShow().getTheatre().getName(),
                    String.valueOf(booking.getShow().getScreen().getScreenId()), booking.getShow().getMovie(),
                    seatNums, booking.getBookingStatus()
            );
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

        return bookingResponse;
    }

    BookingResponse cancelBooking(int bookingId){
        Booking booking = bookingRepo.findById(bookingId).get();

        List<String> seatNums = new ArrayList<>();
        for(int showSeatId: booking.getBookedSeats()){
            ShowSeat showSeatToCancel = getShowSeatById(showSeatId);
            showSeatToCancel.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeatRepo.save(showSeatToCancel);
            seatNums.add(String.valueOf(showSeatToCancel.getShowSeatId()));
        }

        booking.setBookingStatus(BookingStatus.CANCELED);
        bookingRepo.save(booking);

        BookingResponse bookingResponse = new BookingResponse(
                booking.getBookingId(), booking.getShow().getTheatre().getName(),
                String.valueOf(booking.getShow().getScreen().getScreenId()), booking.getShow().getMovie(),
                seatNums, booking.getBookingStatus()
        );

        return bookingResponse;
    }
}
