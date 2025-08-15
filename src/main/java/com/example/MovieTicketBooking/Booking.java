package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Entity
@Table(name = "BOOKING")
public class Booking{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @Column(name = "booked_seats_id")
    private List<Integer> bookedSeatsId;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    public Booking() {}

    public Booking(User user, Show show, List<Integer> bookedSeatsId, BookingStatus bookingStatus) {
        this.user = user;
        this.show = show;
        this.bookedSeatsId = bookedSeatsId;
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

    public List<Integer> getBookedSeats() {
        return bookedSeatsId;
    }

    public void setBookedSeatsId(List<Integer> bookedSeatsId) {
        this.bookedSeatsId = bookedSeatsId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
