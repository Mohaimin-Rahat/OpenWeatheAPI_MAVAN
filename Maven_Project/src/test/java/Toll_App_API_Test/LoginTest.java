package Toll_App_API_Test;

import io.restassured.response.Response;
import org.example.weather.Toll_App_API.Login;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void testLogibTest(){
        Login lo=new Login();
        Response rs=lo.login();
        int statusCode = rs.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);

        Assert.assertEquals(rs.jsonPath().get("message"), "Log in successfully!");

        Assert.assertEquals(rs.jsonPath().get("IsSuccess"), "YES");
    }
}
