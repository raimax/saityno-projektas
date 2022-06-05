package lt.viko.eif.api;

import lt.viko.eif.api.models.User;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.service.HttpTestService;
import org.junit.Assert;

import java.io.IOException;

public class GetUsersTest extends AppTest {
    @When("The user sends GET request to the users endpoint")
    public void theUserSendsGetRequestToTheEndpoint() {
        response = httpTestService.get(API_URL + "/users");
    }

    @Then("The HTTP status of get users OK")
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
