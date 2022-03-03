package at.ac.fhcampuswien.collections;

public class Movie implements Comparable<Movie> {
    public String title;
    public int year;

    public Movie(String title, int year){
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie: " + this.title + " year: " + this.year;
    }

    @Override
    public int compareTo(Movie o) {
        return title.compareTo(o.title);    // sort by title
    }
}
