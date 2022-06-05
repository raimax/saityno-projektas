package lt.viko.eif.api.service;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import lt.viko.eif.api.models.ReshmushResponse;
import lt.viko.eif.api.service.HttpService;

import java.io.IOException;

public class HttpTestService implements HttpService<Response> {
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    @Override
    public Response get(String url) {
        try {
            Request request = new Request.Builder().url(url).get().build();
            return client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
            return null;
        }
    }

    @Override
    public Response post(String url, Object o) {
        Gson g = new Gson();
        String likeDtoJSON =  g.toJson(o);

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, likeDtoJSON);

        try {
            Request request = new Request.Builder().url(url).post(body).build();

            return client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
        }

        return null;
    }
}
