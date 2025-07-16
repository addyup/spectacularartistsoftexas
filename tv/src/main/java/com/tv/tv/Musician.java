package com.tv.tv;

// Musician.java
public class Musician {
    private String name;
    private String venue;
    private String genre;

    // Constructors, getters, setters
    public Musician(String name, String venue, String genre) {
        this.name = name;
        this.venue = venue;
        this.genre = genre;
    }

    public String getName() { return name; }
    public String getVenue() { return venue; }
    public String getGenre() { return genre; }

    public void setName(String name) { this.name = name; }
    public void setVenue(String venue) { this.venue = venue; }
    public void setGenre(String genre) { this.genre = genre; }
}

