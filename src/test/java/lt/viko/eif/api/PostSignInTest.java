package lt.viko.eif.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lt.viko.eif.api.dtos.LoginDto;
import lt.viko.eif.api.service.AzureStorageService;
import org.junit.Assert;

public class PostSignInTest extends AppTest {
    @When("The user sends POST request to the signin endpoint")
    public void theUserSendsGetRequestToTheSignUpEndpoint() {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername(AzureStorageService.generateUUID());
        loginDto.setPassword(AzureStorageService.generateUUID());
        response = httpTestService.post(API_URL + "/auth/signup", loginDto);
    }

    @Then("The HTTP status of signin is OK")
    public void theHTTPStatusOfSignUpIsOk() {
        Assert.assertEquals(200, response.code());
    }
}
