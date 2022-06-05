package lt.viko.eif.api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.User;
import org.junit.Assert;

import java.io.IOException;

public class GetPostsTest {
    private OkHttpClient client = new OkHttpClient();
    private Response response;
    private final String API_URL = "http://localhost:8080/api";

    @When("The user sends GET request to the posts endpoint")
    public void theUserSendsGetRequestToThePostsEndpoint() {
        try {
            Request request = new Request.Builder().url(API_URL + "/posts").get().build();

            this.response = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println("Unsuccessful endpoint call " + e.getMessage());
        }
    }

    @Then("The HTTP status of posts is OK")
    public void theHTTPStatusOfPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }

    /*@Then("The Response contains a list of users")
    public void theResponseContainsAListOfUsers() throws IOException {
        Gson g = new Gson();
        User[] users = g.fromJson(response.body().string(), User[].class);
        Assert.assertTrue(users.length > 0);
    }*/
}
