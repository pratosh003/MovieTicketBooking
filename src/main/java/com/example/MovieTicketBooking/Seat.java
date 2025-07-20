package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @Column(name = "seat_number")
    private String number;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn(name = "screen_id") // FK to SCREEN table
    private Screen screen;
    public Seat() {}

    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

}
