package Toll_App_API_Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.weather.Toll_App_API.CreateUser;
import org.example.weather.Toll_App_API.GetToken;
import org.example.weather.Toll_App_API.SubmitToll;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {
    @Test
    public void testCreateUser(){

        CreateUser cr = new CreateUser();

        Response rs = cr.createUser();

        //int statusCode = rs.statusCode();

        // To validate something, what do we need? ActualValue and ExpectedValue
        int statusCode = rs.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(rs.jsonPath().get("IsSuccess"), "YES");
        Assert.assertEquals(rs.jsonPath().get("message"), "User Created successfully!");



    }
}
