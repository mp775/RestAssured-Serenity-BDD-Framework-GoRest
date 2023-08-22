package com.gorest.userpojoinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UsersPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.RestRequests;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Test;

public class UserCURDTest extends TestBase {

    static String token = "f8f231911770bd29394ba6350b92e3e88b00d7f482a4b763d244d3d42f395d19";

    public static int Id=4278756;

    @Title("This will get all user")
    @Test
    public void getAllStudents() {
        Response response = SerenityRest.given()
                .when()
                .get();
        response.then().statusCode(200);
        response.then().log().all();
    }
    @Title("This will create a new User")
    @Test
    public void verifyUserCreatedSuccessfully() {
        String email = TestUtils.getRandomValue() + "prime@gmail.com";
        UsersPojo userpojo = new UsersPojo();
        userpojo.setName("Prime");
        userpojo.setEmail(email);
        userpojo.setGender("male");
        userpojo.setStatus("active");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json", new Object[]{"Authorization", "Bearer " + token})
                .when()
                .body(userpojo)
                .post()
                .then().log().all().statusCode(201);


    }

    @Title("This will Update a new User")
    @Test
    public void verifyUserUpdatedSuccessfully() {

        String email = TestUtils.getRandomValue() + "prime@gmail.com";
        UsersPojo userpojo = new UsersPojo();
        userpojo.setName("Prime");
        userpojo.setEmail(email);
        userpojo.setGender("male");

        userpojo.setStatus("active");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .headers("Content-Type", "application/json",new Object[]{"Authorization", "Bearer " + token})
                .pathParams("id", Id)
                .when()
                .body(userpojo)
                .put(EndPoints.UPDATE_User_BY_ID)
                .then().log().all().statusCode(200);

    }

    @Title("This will Delete User by ID")
    @Test

    public void deleteUser() {
        RestRequests.given()
                .headers("Content-Type", "application/json",new Object[]{"Authorization", "Bearer " + token})

                .pathParam("id", Id)
                .when()
                .delete(EndPoints.DELETE_User_BY_ID)
                .then()
                .statusCode(204);

        RestRequests.given()
                .pathParam("id", Id)
                .when()
                .get(EndPoints.DELETE_User_BY_ID)
                .then().statusCode(404);


    }
}