package at.ac.fhcampuswien.collections;

import java.util.*;

public class CollectionExamples {
    public static void main(String[] args) {

        List<String> myFruits = new ArrayList<>();  // create an ArrayList

        myFruits.add("banana"); // add items to list
        myFruits.add("pear");
        myFruits.add("apple");

        printStringList(myFruits);

        myFruits.remove("banana");  // remove a specific item from list - removes the first occurrence of banana

        printStringList(myFruits);

        List<String> myVeggies = new ArrayList<>();
        myVeggies.add("cucumber");
        myVeggies.add("carrots");

        myVeggies.addAll(myFruits);     // add a list to another list

        printStringList(myVeggies);

        String[] myFruitArr = {"melon", "grapes"};

        List<String> anotherList = arrayToList(myFruitArr);
        myFruits.addAll(anotherList);

        printStringList(myFruits);


        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Reservoir Dogs", 1992));
        movies.add(new Movie("In Bruges", 2008));

        Movie movie = new Movie("Frozen", 2013);
        movies.add(movie);


        printMovies(movies);

        System.out.println("Movies sorted:");
        sortByTitle(movies);

        sortByYear(movies);

    }

    public static void sortByTitle(List<Movie> movies){
        Collections.sort(movies);   // calls compareTo method implemented in Movie class -> Comparable interface
        printMovies(movies);
    }

    public static void sortByYear(List<Movie> movies){
        // sorting with comparator interface
        Comparator<Movie> byYear = new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m1.year - m2.year;
            }
        };

        movies.sort(byYear);

        printMovies(movies);

        // sorting with lambda expression
        movies.sort( (Movie m1, Movie m2) -> m1.year - m2.year);


    }

    public static List<String> arrayToList(String[] arr){
        return Arrays.asList(arr);
    }

    public static void printStringList(List<String> fruits ){
        System.out.println("Print list:");
        for(String fruit: fruits){
            System.out.println(fruit);
        }
    }


    public static void printMovies(List<Movie> movies){
        System.out.println("Print movies 1:");
        for(Movie m: movies){
            System.out.println(m);
        }

        System.out.println("Print movies 2:");

        for(int i = 0; i < movies.size(); i++){
            System.out.println("index: " + i + " " + movies.get(i));
        }
    }
}
