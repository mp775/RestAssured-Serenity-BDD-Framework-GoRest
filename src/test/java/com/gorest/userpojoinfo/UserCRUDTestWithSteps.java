package com.gorest.userpojoinfo;

import com.gorest.userinfo.*;
import com.gorest.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class UserCRUDTestWithSteps extends TestBase {

    @Steps
    UserSteps usersteps;

    @Title("get all User Data")
    @Test
    public void test001() {
        usersteps.getAllUsers();

    }

    @Title("This will create a new user")
    @Test
    public void test002() {

        usersteps.createUser("shweta", "prime1234_23121@gmail.com", "male", "active").statusCode(201);


    }

    @Title("This will update  user")
    @Test
    public void test003() {

        usersteps.updateUser("Shweta1","prime12345_23121@gmail.com","male", "active").statusCode(200);


    }

    @Title("Delete User")
    @Test
    public void test004() {

        usersteps.deleteUser(4278761);
    }



}