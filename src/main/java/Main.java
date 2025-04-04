import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static final String WeavyURL = "https://8015b5dbc0724d38882ac90397c27649.weavy.io/api/users";
    public static final String APIKey = "wys_hMWpXdekxcn9Gc8Ioah3azOllzUZ7l3HN9yB";

    private final OkHttpClient client = new OkHttpClient();

    public String sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer "+APIKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            // Return the response body as a string
            assert response.body() != null;
            return response.body().string();
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        System.out.println(main.sendGetRequest(WeavyURL));
    }
}