package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "THEATRE")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;

    private String name;
    private String city;

    @OneToMany
    private List<Screen> screenList;

    public Theatre() {}

    public int getTheatreId() { return theatreId; }
    public void setTheatreId(int theatreId) { this.theatreId = theatreId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<Screen> getScreenList() { return screenList; }
    public void setScreenList(List<Screen> screenList) { this.screenList = screenList; }
}
