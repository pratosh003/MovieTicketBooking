package com.example.MovieTicketBooking;

import com.example.MovieTicketBooking.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class ShowResponse {
    private int showId;
    private Theatre theatre;
    private Movie movie;
    private Date startTime;
    private Date endTime;

    public ShowResponse(int showId, Theatre theatre, Movie movie, Date startTime, Date endTime) {
        this.showId = showId;
        this.theatre = theatre;
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}