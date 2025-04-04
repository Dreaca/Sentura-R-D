import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;

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
    public String sendPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer "+APIKey)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return response.body().string();
        }
    }
    public String sendPatchRequest(String url,String uid, String json) throws IOException {
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));
        Request request = new Request.Builder()
                .url(url+"/"+uid)
                .header("Authorization", "Bearer "+APIKey)
                .patch(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return response.body().string();
        }
    }
    public String sendDeleteRequest(String url,String uid) throws IOException {
        Request request = new Request.Builder()
                .url(url+"/"+uid)
                .header("Authorization", "Bearer "+APIKey)
                .delete()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            assert response.body() != null;
            return response.body().string();
        }
    }
}