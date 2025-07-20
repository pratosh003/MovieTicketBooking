package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> bookedSeats;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    public Booking() {}

    public Booking(User user, Show show, List<ShowSeat> bookedSeats, BookingStatus bookingStatus) {
        this.user = user;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingStatus = bookingStatus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<ShowSeat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
