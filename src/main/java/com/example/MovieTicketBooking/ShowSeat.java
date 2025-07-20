package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SHOW_SEAT")
public class ShowSeat{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;

    private Double price;

    @ManyToOne
    private Show show;

    @OneToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;

    public ShowSeat() {}

    public int getShowSeatId() { return showSeatId; }
    public void setShowSeatId(int showSeatId) { this.showSeatId = showSeatId; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Show getShow() { return show; }
    public void setShow(Show show) { this.show = show; }

    public ShowSeatStatus getShowSeatStatus() { return showSeatStatus; }
    public void setShowSeatStatus(ShowSeatStatus showSeatStatus) { this.showSeatStatus = showSeatStatus; }
}
