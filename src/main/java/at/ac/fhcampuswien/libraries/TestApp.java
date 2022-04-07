package at.ac.fhcampuswien.libraries;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TestApp {
    public static void main(String[] args) {

        try {
            System.out.println(run("https://newsapi.org/v2/everything?q=bitcoin&apiKey=e2fec2d3216d412a8b1dabc23b6fcaaf"));
        } catch (IOException e){
            // do something
        }


    }

    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
