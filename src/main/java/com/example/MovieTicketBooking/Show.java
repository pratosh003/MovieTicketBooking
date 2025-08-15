package com.example.MovieTicketBooking;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MOVIE_SHOW")
@Builder
public class Show{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    @ManyToOne
    private Theatre theatre;

    @ManyToOne
    private Movie movie;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatStatusList;


    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    public Show() {}

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public Theatre getTheatre() { return theatre; }
    public void setTheatre(Theatre theatre) { this.theatre = theatre; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }

    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public List<ShowSeat> getShowSeatList() { return showSeatStatusList; }
    public void setShowSeatList(List<ShowSeat> showSeatStatusList) { this.showSeatStatusList = showSeatStatusList; }

    public int getMovieId(){
        return this.movie.getMovieId();
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen(){
        return screen;
    }
}
