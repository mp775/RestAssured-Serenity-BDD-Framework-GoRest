package com.gorest.userinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UsersPojo;
import com.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps {
    static String token = "f8f231911770bd29394ba6350b92e3e88b00d7f482a4b763d244d3d42f395d19";
    int Id=4278761;
    @Step("Creating User with Name : {0}, , gender : {2}, status : {3} ")
    public ValidatableResponse createUser(String Name, String email, String gender,
                                          String status) {
        email = TestUtils.getRandomValue() + "prime@gmail.com";
        UsersPojo userpojo = new UsersPojo();
        userpojo.setName(Name);
        userpojo.setEmail(email);
        userpojo.setGender(gender);
        userpojo.setStatus(status);

        return SerenityRest.given()
            //    .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json",new Object[]{"Authorization", "Bearer " + token})
                .when()
                .body(userpojo)
                .post()
                .then();
    }

@Step("This will get all user")
      public ValidatableResponse getAllUsers() {
        ValidatableResponse response = SerenityRest.given()
                .when()
                .get().then();

        response.statusCode(200);
        response.log().all();
        return response;
    }


    @Step("This will Update a new User")

  public ValidatableResponse updateUser(String Name, String email, String gender,
                                            String status) {

        String email1 = TestUtils.getRandomValue() + "prime@gmail.com";
        UsersPojo userpojo = new UsersPojo();
        userpojo.setName(Name);
        userpojo.setEmail(email1);
        userpojo.setGender(gender);

        userpojo.setStatus(status);
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json",new Object[]{"Authorization", "Bearer " + token})
               .pathParams("id", Id)
                .when()
                .body(userpojo)
                .put(EndPoints.UPDATE_User_BY_ID)
                .then().log().all().statusCode(200);

    }

    @Step("Deleting user information with Id: {0}")
    public ValidatableResponse deleteUser(int Id) {
        return SerenityRest.given()
                .pathParam("id", Id)
                .when()
                .delete(EndPoints.DELETE_User_BY_ID)
                .then();
    }

    @Step("Getting User information with Id : {0}")
    public ValidatableResponse getUserById(int Id) {
        return SerenityRest.given()
                .pathParam("id", Id)
                .when()
                .get(EndPoints.GET_SINGLE_User_BY_ID)
                .then();
    }

    @Step("Getting User information with Id : {0}")
    public ValidatableResponse getUserByEmail(String email) {
        return SerenityRest.given()
                .queryParam("email", email)
                .when()
                .get(EndPoints.GET_ALL_Data)
                .then();
    }


}
