package lt.viko.eif.api;

import com.squareup.okhttp.Response;
import lt.viko.eif.api.service.HttpTestService;

public class AppTest {
    protected Response response;
    protected final String API_URL = "http://localhost:8080/api";
    protected HttpTestService httpTestService = new HttpTestService();
}
