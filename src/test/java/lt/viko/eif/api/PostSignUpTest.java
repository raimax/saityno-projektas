package lt.viko.eif.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.dtos.SignUpDto;
import lt.viko.eif.api.service.AzureStorageService;
import org.junit.Assert;

public class PostSignUpTest extends AppTest {
    @When("The user sends POST request to the signup endpoint")
    public void theUserSendsGetRequestToTheSignUpEndpoint() {
        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setUsername(AzureStorageService.generateUUID());
        signUpDto.setPassword(AzureStorageService.generateUUID());
        response = httpTestService.post(API_URL + "/auth/signup", signUpDto);
    }

    @Then("The HTTP status of signup is OK")
    public void theHTTPStatusOfSignUpIsOk() {
        Assert.assertEquals(200, response.code());
    }
}
