package lt.viko.eif.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.models.Post;
import org.junit.Assert;

import java.io.IOException;

public class GetPostsTopLikesTest extends AppTest {
    @When("The user sends GET request to the Top liked posts endpoint")
    public void theUserSendsGetRequestTopLikedPostsEndpoint() {
        response = httpTestService.get(API_URL + "/posts/top/likes");
    }

    @Then("The HTTP status of top liked posts is OK")
    public void theHTTPStatusOfTopLikedPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }

    @Then("The Response contains a list of top liked posts")
    public void theResponseContainsAListOfTopLikedPosts() throws IOException {
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        Post[] posts = mapper.readValue(response.body().string(), Post[].class);

        Assert.assertTrue(posts.length == 3);
    }
}
