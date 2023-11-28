package Toll_App_API_Test;

import io.restassured.response.Response;
import org.example.weather.Toll_App_API.GetUserList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUserListTest {
    @Test
    public void getUserListTest() {

        GetUserList getUser = new GetUserList();
        Response rs = getUser.getUserList();

        int statusCode = rs.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(rs.jsonPath().get("IsSuccess"), "YES");
        Assert.assertEquals(rs.jsonPath().get("message"), "User List!");
    }
}