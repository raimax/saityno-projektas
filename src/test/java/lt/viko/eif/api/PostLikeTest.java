package lt.viko.eif.api;

import com.squareup.okhttp.Response;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.dtos.LikeDto;
import lt.viko.eif.api.service.HttpTestService;
import org.junit.Assert;

public class PostLikeTest {
    private Response response;
    private final String API_URL = "http://localhost:8080/api";
    private HttpTestService httpTestService = new HttpTestService();

    @When("The user sends POST request to the likes endpoint")
    public void theUserSendsGetRequestToTheEndpoint() {
        LikeDto likeDto = new LikeDto();
        likeDto.setPostId(61);
        likeDto.setUserId(2);
        response = httpTestService.post(API_URL + "/likes", likeDto);
    }

    @Then("The HTTP status of post likes is OK")
    public void theHTTPStatusOfPostsIsOk() {
        Assert.assertEquals(200, response.code());
    }
}
