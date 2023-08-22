package com.gorest.userpojoinfo;

import com.gorest.constants.EndPoints;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

public class FirstSerenityTest extends TestBase {

    @Test
    public void getAllUsers() {
        Response response = SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_Data);
        response.then().statusCode(200);
        response.then().log().all();
    }
}
