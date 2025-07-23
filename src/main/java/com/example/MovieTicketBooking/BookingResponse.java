package com.example.MovieTicketBooking;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookingResponse {
    private int bookingId;
    private String theatre;
    private String screen;
    private Movie movie;
    private List<String> seats;
    private BookingStatus bookingStatus;
}
