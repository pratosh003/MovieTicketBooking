package com.example.MovieTicketBooking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookingRequest {
    private int showId;
    private List<Integer> selectedShowSeats;
    private User user;

    // Getters and setters
}
