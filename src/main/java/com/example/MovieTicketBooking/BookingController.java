package com.example.MovieTicketBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/booking")
public class BookingController {
    BookingService bookingService;
    @Autowired
    public BookingController(@Qualifier("BookingService") BookingService bookingService){
        this.bookingService = bookingService;
    }
    @ResponseBody
    @GetMapping("/getMoviesByCity/{city}")
    public Set<Movie> getMoviesByCity(@PathVariable String city){
        return bookingService.getMoviesByCity(city);
    }

    @ResponseBody
    @GetMapping("/getShowsByMovieAndCity/{city}/{movieId}")
    Map<Theatre, List<ShowResponse>> getShowsByMovieAndCity(@PathVariable String city, @PathVariable int movieId){
        return bookingService.getShowsByMovieAndCity(city, movieId);
    }

    @ResponseBody
    @GetMapping("/getShowSeatsByShow/{showId}")
    List<ShowSeatResponse> getShowSeatsByShow(@PathVariable int showId){
        return bookingService.getShowSeatsByShow(showId);
    }

    @PostMapping("/createBooking")
    @ResponseBody
    BookingResponse createBooking(@RequestBody BookingRequest bookingRequest){
        return bookingService.createBooking(bookingRequest);
    }

    @PutMapping("/cancelBooking")
    @ResponseBody
    BookingResponse cancelBooking(@RequestParam("bookingId") int bookingId){
        return bookingService.cancelBooking(bookingId);
    }

    @PostMapping("/create-payment")
    @ResponseBody
    Payment createPayment(PaymentRequest paymentRequest){
        return bookingService.createPayment(paymentRequest);
    }

}
