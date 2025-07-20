package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SCREEN")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screenId;

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @OneToMany
    private List<Seat> seatList;

    public Screen() {}

    public int getScreenId() { return screenId; }
    public void setScreenId(int screenId) { this.screenId = screenId; }

    public ScreenType getScreenType() { return screenType; }
    public void setScreenType(ScreenType screenType) { this.screenType = screenType; }

    public List<Seat> getSeatList() { return seatList; }
    public void setSeatList(List<Seat> seatList) { this.seatList = seatList; }
}
