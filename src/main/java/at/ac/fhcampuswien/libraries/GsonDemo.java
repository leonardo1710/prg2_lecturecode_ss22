package at.ac.fhcampuswien.libraries;

import com.google.gson.Gson;

public class GsonDemo {
    public static void main(String[] args) {
        String serializedObject = serialize();

        deserializeMovie(serializedObject);

    }

    /**
     * Serialization is a mechanism of converting the state of an object into a byte stream
     *
     * Use Cases:
     *  to save state of an object (database)
     *  to send object over a network (api)
     */
    public static String serialize(){
        Gson gson = new Gson();

        gson.toJson(1);
        gson.toJson("abcd");
        int[] myArr = {1, 2, 3, 4};
        gson.toJson(myArr);

        System.out.println(gson.toJson(myArr));

        Movie object = new Movie("Reservoir Dogs");

        String serializedObject = gson.toJson(object);
        System.out.println(serializedObject);

        return serializedObject;
    }

    /**
     * Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory
     */
    public static void deserializeMovie(String movieJSON){
        Gson gson = new Gson();

        Movie movie = gson.fromJson(movieJSON, Movie.class);    // deserialize json string to movie object

        Movie movie1 = gson.fromJson("{\"year\":1992, \"title\":\"Reservoir Dogs\"}", Movie.class);
        System.out.println(movie1); // Reservoir Dogs 1992

        Movie movie2 = gson.fromJson("{\"title\":\"Reservoir Dogs\", \"year\":1992}", Movie.class);
        System.out.println(movie2);  // Reservoir Dogs 1992

        Movie movie3 = gson.fromJson("{\"title\":\"Reservoir Dogs\"}", Movie.class);
        System.out.println(movie3);  // Reservoir Dogs 0

        Movie movie4 = gson.fromJson("{\"year\":1992}", Movie.class);
        System.out.println(movie4);  // null 1992

    }
}
