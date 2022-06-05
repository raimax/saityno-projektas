package lt.viko.eif.api.service;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import lt.viko.eif.api.models.ReshmushResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * This class implements HttpService
 */
@Service
public class HttpServiceImpl implements HttpService<ReshmushResponse> {
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    /**
     * This method //todo
     */
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

    @Override
    public ReshmushResponse post(String url, Object data) {
        return null;
    }
}
