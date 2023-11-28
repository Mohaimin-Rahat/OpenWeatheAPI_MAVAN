package org.example.weather.Toll_App_API;

import Utility.ReadJSONFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SubmitToll {
    public Response submitToll() {
        GetToken token= new GetToken();
        String newToken= token.generateToken();
        String auth="Bearer "+newToken;

        String resource="/tollcollection";

        String content="text/plain";

        String jsonFilePath="/Users/rahat/Java/Maven_Project/src/main/resource/submitToll.json";
        String body= ReadJSONFile.readJSON(jsonFilePath);

       // String body="{\"id\":\"3234R3dfdfdf45\",\"createdAt\":\"22-Sep-2023\",\"collectionDate\":\"22-Sep-2023\",\"createdBy\":\"Abdul\",\"updatedBy\":\"Abdul\",\"collectionPointId\":\"NY088734\",\"tagNumber\":\"RX500\",\"vehicleType\":\"HybridVehicles\",\"tollCollectionMethod\":\"Cash\",\"tollRate\":19}";

        RestAssured.baseURI="https://jnswdazms1.execute-api.us-east-1.amazonaws.com/dev";


        Response re =given()
                .header("Authorization",auth)
                .header("Content-Type",content)
                .body(body)
                .post(resource);

        System.out.println(re.prettyPrint());
        return re;
    }
}
