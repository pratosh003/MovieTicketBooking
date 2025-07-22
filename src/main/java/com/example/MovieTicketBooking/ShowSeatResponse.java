package com.example.MovieTicketBooking;

import lombok.Data;

@Data
public class ShowSeatResponse {
    private int showSeatId;
    private Double price;
    private int showId;
    private int seatId;
    private String seatNumber;
    private ShowSeatStatus showSeatStatus;
    private SeatType seatType;

    public ShowSeatResponse(int showSeatId, Double price, int showId, int seatId, ShowSeatStatus showSeatStatus, String seatNumber, SeatType seatType) {
        this.showSeatId = showSeatId;
        this.price = price;
        this.showId = showId;
        this.seatId = seatId;
        this.showSeatStatus = showSeatStatus;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }
}
