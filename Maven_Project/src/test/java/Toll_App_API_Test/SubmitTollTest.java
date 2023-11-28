package Toll_App_API_Test;

import io.restassured.response.Response;
import org.example.weather.Toll_App_API.SubmitToll;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubmitTollTest {
    @Test
    public void testSubmitTollAPI(){

        SubmitToll sb = new SubmitToll();

        Response rs = sb.submitToll();

        //int statusCode = rs.statusCode();

        // To validate something, what do we need? ActualValue and ExpectedValue
        int statusCode = rs.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);

        Assert.assertEquals(rs.jsonPath().get("message"), "success");

        Assert.assertEquals(rs.jsonPath().get("IsSuccess"), "YES");

    }
}
