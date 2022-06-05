package lt.viko.eif.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import com.squareup.okhttp.*;

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
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();

        try {
            String data = mapper.writeValueAsString(o);
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(JSON, data);

            Request request = new Request.Builder().url(url).post(body).build();
            return client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
        }

        return null;
    }
}
