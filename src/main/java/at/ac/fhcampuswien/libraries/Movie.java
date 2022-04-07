package at.ac.fhcampuswien.libraries;

public class Movie {
    private String title;
    private int year;

    public Movie(String title){
        this.title = title;
        this.year = 2000;
    }

    public Movie(String title, int year){
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.title + " " + this.year;
    }
}
