package Toll_App_API_Test;

import io.restassured.response.Response;
import org.example.weather.Toll_App_API.ResetPassword;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResetPasswordTest {
    @Test
    public void resetPasswordTest(){
        ResetPassword reset=new ResetPassword();
        Response re=reset.resetPassword();

        int statusCode = re.jsonPath().get("statusCode");

        Assert.assertEquals(statusCode, 200);

        Assert.assertEquals(re.jsonPath().get("message"), "Password set successfully!");

        Assert.assertEquals(re.jsonPath().get("IsSuccess"), "YES");
    }

}
