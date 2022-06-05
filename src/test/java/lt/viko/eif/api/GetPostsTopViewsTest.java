package lt.viko.eif.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.Post;
import org.junit.Assert;

import java.io.IOException;

public class GetPostsTopViewsTest extends AppTest {
    @When("The user sends GET request to the Top rated posts endpoint")
    public void theUserSendsGetRequestTopRatedPostsEndpoint() {
        response = httpTestService.get(API_URL + "/posts/top/views");
    }

    @Then("The HTTP status of top rated posts is OK")
    public void theHTTPStatusOfTopRatedPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a list of top rated posts")
    public void theResponseContainsAListOfTopRatedPosts() throws IOException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Post[] posts = mapper.readValue(response.body().string(), Post[].class);

        Assert.assertTrue(posts.length == 3);
    }
}
