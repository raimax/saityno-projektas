package lt.viko.eif.api;

import com.squareup.okhttp.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.service.HttpTestService;
import org.junit.Assert;

public class GetPostsTest {
    private Response response;
    private final String API_URL = "http://localhost:8080/api";
    private HttpTestService httpTestService = new HttpTestService();

    @When("The user sends GET request to the posts endpoint")
    public void theUserSendsGetRequestToThePostsEndpoint() {
        response = httpTestService.get(API_URL + "/posts");
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
