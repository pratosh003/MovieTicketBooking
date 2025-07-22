package com.example.MovieTicketBooking;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    private String name;
    private String language;
    private String genre;
    private String runTime;
    private String details;

    public Movie() {}

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getRunTime() { return runTime; }
    public void setRunTime(String runTime) { this.runTime = runTime; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId == movie.movieId && Objects.equals(name, movie.name) && Objects.equals(language, movie.language) && Objects.equals(genre, movie.genre) && Objects.equals(runTime, movie.runTime) && Objects.equals(details, movie.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, name, language, genre, runTime, details);
    }
}
