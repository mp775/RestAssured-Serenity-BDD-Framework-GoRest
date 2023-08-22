package com.gorest.cucumber.steps;

import com.gorest.userinfo.UserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {

    @Steps
    UserSteps userSteps;

    static ValidatableResponse response;
    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response=userSteps.getAllUsers();
    }

    @Then("^User must get back a valid status code (\\d+)$")
    public void userMustGetBackAValidStatusCode(int arg0) {
        response.statusCode(arg0);
    }


    @When("^I create a new user by providing the information name \"([^\"]*)\" email \"([^\"]*)\" gender \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationNameEmailGenderStatus(String name, String email, String gender, String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userSteps.createUser(name,email,gender,status);
    }

    @Then("^I verify that the user with \"([^\"]*)\" is created$")
    public void iVerifyThatTheUserWithIsCreated(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        userSteps.getUserByEmail(email);
    }
}
