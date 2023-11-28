package Toll_App_API_Test;

import io.restassured.response.Response;
import org.example.weather.Toll_App_API.GetTollCollectionList;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTollCollectionListTest {
    @Test
    public void getTollListTest(){
        GetTollCollectionList getlList=new GetTollCollectionList();
        Response rs= getlList.getTollList();

        int statusCode = rs.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(rs.jsonPath().get("IsSuccess"), "YES");
        Assert.assertEquals(rs.jsonPath().get("message"), "success");
    }
}
