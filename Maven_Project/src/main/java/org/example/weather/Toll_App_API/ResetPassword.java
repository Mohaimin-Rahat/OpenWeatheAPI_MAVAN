package org.example.weather.Toll_App_API;

import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResetPassword {
    public Response resetPassword() {
        GetToken token=new GetToken();
        String newToken= token.generateToken();

        String auth="Bearer "+newToken;

        String resource="/cognito-admin-set-user-password";

        //String body="{\"username\":\"amrahat\",\"password\":\"AMrahat@987\"}";

        String jsonFilePath="/Users/rahat/Java/Maven_Project/src/main/resource/resetPassword.json";
        String body= ReadJSONFile.readJSON(jsonFilePath);
        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";

        Response re=RestAssured.given()
                .header("Authorization",auth)
                .body(body)
                .post(resource);
        System.out.println(re.prettyPrint());
        return re;
    }
}
