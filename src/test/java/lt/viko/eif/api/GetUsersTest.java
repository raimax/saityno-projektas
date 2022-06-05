package lt.viko.eif.api;

import lt.viko.eif.api.models.User;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class GetUsersTest {
    private OkHttpClient client = new OkHttpClient();
    private Response response;
    private final String API_URL = "http://localhost:8080/api";

    @When("The user sends GET request to the endpoint")
    public void theUserSendsGetRequestToTheEndpoint() {
        try {
            Request request = new Request.Builder().url(API_URL + "/users").get().build();

            this.response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
        }
    }

    @Then("The HTTP status is OK")
    public void theHTTPStatusIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a list of users")
    public void theResponseContainsAListOfUsers() throws IOException {
        Gson g = new Gson();
        User[] users = g.fromJson(response.body().string(), User[].class);
        Assert.assertTrue(users.length > 0);
    }
}
