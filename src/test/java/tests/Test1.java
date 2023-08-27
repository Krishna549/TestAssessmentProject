package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Test1 {



    static String baseURI="http://www.omdbapi.com/?apikey=79a4a58e";
    public static Response getResponseParameters(String testStr){

        RequestSpecification httpReq=given().when();
        Response resp=httpReq.get(baseURI+testStr);
                resp.then()
                .statusCode(200)
                .log().all();
                return resp;

    }

    public static Response getResponseSearch(String testStr){

        RequestSpecification httpReq=given().when();
        Response resp=httpReq.get(baseURI+testStr);
        resp.then()
                .statusCode(200)
                .log().all();

        return resp;
    }
}
