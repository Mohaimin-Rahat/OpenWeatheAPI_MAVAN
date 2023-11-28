package org.example.weather.Toll_App_API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.RestAssured.given;

public class GetToken {

    public String generateToken() {
        RestAssured.baseURI = "https://is-toll-plaza-user-pool.auth.us-east-1.amazoncognito.com";
        String resource = "/oauth2/token";

        String requestBody = "scope=feature-toll-plaza/read&grant_type=client_credentials";

        String userName = "t5bi323d5o1sp39q2jp9okjor";

        String password = "7s6jcc3l0gmaps2ce9gt6cd6nm4sif8l77e0cae3lbnb5rp0mpa";

        String join = userName + ":" + password;

        byte[] pass = join.getBytes(StandardCharsets.UTF_8);

        String base64Encode = Base64.getEncoder().encodeToString(pass);

        String content = "application/x-www-form-urlencoded";

        String basic = "Basic " + base64Encode;

        Response re = given()
                .header("Content-Type", content)
                .header("Authorization", basic)
                .body(requestBody)
                .post(resource);

        String token= re.jsonPath().getString("access_token");

        return token;
    }
        public static void main (String[]args){
        GetToken token=new GetToken();
        token.generateToken();
            System.out.println(token.generateToken());

        }


}

