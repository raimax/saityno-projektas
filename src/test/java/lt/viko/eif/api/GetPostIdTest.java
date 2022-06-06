package lt.viko.eif.api;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.Post;
import org.junit.Assert;

import java.io.IOException;

public class GetPostIdTest extends AppTest {
    @When("The user sends GET request to the post endpoint")
    public void theUserSendsGetRequestToThePostIdEndpoint() {
        response = httpTestService.get(API_URL + "/posts/63");
    }

    @Then("The HTTP status of post is OK")
    public void theHTTPStatusOfPostIdIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a post with specified ID")
    public void theResponseContainsPostWithId() throws IOException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Post posts = mapper.readValue(response.body().string(), Post.class);

        Assert.assertTrue(posts.getId() == 63);
    }
}
