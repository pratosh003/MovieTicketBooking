package com.example.MovieTicketBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @ResponseBody
    @GetMapping("/getMoviesByCity/{city}")
    public Set<Movie> getMoviesByCity(@PathVariable String city){
        return bookingService.getMoviesByCity(city);
    }
}
