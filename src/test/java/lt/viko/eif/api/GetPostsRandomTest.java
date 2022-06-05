package lt.viko.eif.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.Post;
import org.junit.Assert;

import java.io.IOException;

public class GetPostsRandomTest extends AppTest {
    @When("The user sends GET request to the random posts endpoint")
    public void theUserSendsGetRequestRandomPostsEndpoint() {
        response = httpTestService.get(API_URL + "/posts/random");
    }

    @Then("The HTTP status of random posts is OK")
    public void theHTTPStatusOfRandomPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a list of random posts")
    public void theResponseContainsAListOfRandomPosts() throws IOException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Post post = mapper.readValue(response.body().string(), Post.class);

    }
}
