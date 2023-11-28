package org.example.weather.Toll_App_API;

import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {

    public Response createUser() {
        GetToken token=new GetToken();
        String newToken=token.generateToken();
        String auth="Bearer "+newToken;

        String jsonFilePath="/Users/rahat/Java/Maven_Project/src/main/resource/createUser.json";
        String bodyToCreateUser= ReadJSONFile.readJSON(jsonFilePath);

        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";
        //String bodyToCreateUser = "{\"username\":\"amrahat\",\"password\":\"AMrahat@123\",\"email\":\"amrahat@gmail.com\",\"userType\":\"User\",\"name\":\"Test Data\"}";
        String resource="/cognito-create-user";

        String contentTypeHeader = "application/json";



        Response re = given()
                .header("Authorization",auth)
                .body(bodyToCreateUser)
                .header("Content-Type", contentTypeHeader)
                .post(resource);
        System.out.println(re.prettyPrint());

return re;
    }
}
