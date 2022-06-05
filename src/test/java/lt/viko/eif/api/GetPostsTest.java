package lt.viko.eif.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.Post;
import org.junit.Assert;

import java.io.IOException;

public class GetPostsTest extends AppTest {
    @When("The user sends GET request to the posts endpoint")
    public void theUserSendsGetRequestToThePostsEndpoint() {
        response = httpTestService.get(API_URL + "/posts/");
    }

    @Then("The HTTP status of posts is OK")
    public void theHTTPStatusOfPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a list of posts")
    public void theResponseContainsAListOfPosts() throws IOException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Post[] posts = mapper.readValue(response.body().string(), Post[].class);

        Assert.assertTrue(posts.length > 0);
    }
}
