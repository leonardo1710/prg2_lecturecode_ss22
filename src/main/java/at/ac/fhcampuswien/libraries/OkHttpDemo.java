package at.ac.fhcampuswien.libraries;

import okhttp3.*;

import java.io.IOException;

public class OkHttpDemo {
    public static void main(String[] args) {
        System.out.println(getNews());
    }

    public static String getNews(){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://newsapi.org/v2/top-headlines?country=us&apiKey=e2fec2d3216d412a8b1dabc23b6fcaaf").build();


        try (Response response = client.newCall(request).execute()) {   // synchronous call with okhttp
            return response.body().string();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return "";
    }
}
