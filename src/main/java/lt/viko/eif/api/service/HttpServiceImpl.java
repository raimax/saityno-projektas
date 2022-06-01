package lt.viko.eif.api.service;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lt.viko.eif.api.models.ReshmushResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpServiceImpl implements HttpService<ReshmushResponse> {
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    @Override
    public ReshmushResponse get(String url) {
        try {
            Request request = new Request.Builder().url(url).get().build();
            Response response = client.newCall(request).execute();
            return gson.fromJson(response.body().string(), ReshmushResponse.class);
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
            return null;
        }
    }
}
