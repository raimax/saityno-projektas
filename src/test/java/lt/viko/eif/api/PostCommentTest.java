package lt.viko.eif.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.dtos.CommentDto;
import lt.viko.eif.api.models.Post;
import lt.viko.eif.api.models.User;
import org.junit.Assert;


    public class PostCommentTest  extends AppTest {
        @When("The user sends POST request to the comments endpoint")
        public void theUserSendsGetRequestToTheEndpoint() {
            CommentDto commentDto = new CommentDto();
            commentDto.setContent("Lab Dien");
            User user = new User();
            user.setId(133);
            commentDto.setUser(user);
            Post post = new Post();
            post.setId(63);
            commentDto.setPost(post);
            response = httpTestService.post(API_URL + "/comments", commentDto);
        }

        @Then("The HTTP status of post comments is OK")
        public void theHTTPStatusOfPostsIsOk() {
            Assert.assertEquals(200, response.code());
        }
    }

